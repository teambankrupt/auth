package com.example.auth.config.security.oauth;

import com.example.auth.entities.Privilege;
import com.example.auth.enums.AccessLevels;
import com.example.auth.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.util.List;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final TokenStore tokenStore;
    private final AuthService authService;

    @Autowired
    public ResourceServerConfig(TokenStore tokenStore, AuthService authService) {
        this.tokenStore = tokenStore;
        this.authService = authService;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String ADMINISTRATION = "ADMINISTRATION";
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry r = http
                .antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers(
                        "/",
                        "/api/v1/register/**",
                        "/api/v1/search/**",
                        "/api/v2/search/**",
                        "/api/v1/login**",
                        "/oauth/token**",
                        "/swagger-resources/**",
                        "/v2/api-docs",
                        "/sw/**",
                        "/api/v1/reset_password/**",
                        "/api/v1/check_token_validity",
                        "/api/v1/promos/**",
                        "/swagger-ui.html",
                        "/api/v1/profiles/user/snap/*",
                        "/api/v1/public/**"

                )
                .permitAll()
                .antMatchers(
                        "/api/v1/admin/**"
                )
                .hasAnyAuthority(ADMINISTRATION);

        List<Privilege> privileges = this.authService.getAuthorities();

        for (Privilege a : privileges) {
            r.antMatchers(a.accessesArr(AccessLevels.ALL)).hasAnyAuthority(ADMINISTRATION, a.getName());
            r.antMatchers(HttpMethod.GET, a.accessesArr(AccessLevels.READ)).hasAnyAuthority(ADMINISTRATION, a.getName());
            r.antMatchers(HttpMethod.OPTIONS, a.accessesArr(AccessLevels.CREATE)).hasAnyAuthority(ADMINISTRATION, a.getName());
            r.antMatchers(HttpMethod.POST, a.accessesArr(AccessLevels.CREATE)).hasAnyAuthority(ADMINISTRATION, a.getName());
            r.antMatchers(HttpMethod.OPTIONS, a.accessesArr(AccessLevels.UPDATE)).hasAnyAuthority(ADMINISTRATION, a.getName());
            r.antMatchers(HttpMethod.PUT, a.accessesArr(AccessLevels.UPDATE)).hasAnyAuthority(ADMINISTRATION, a.getName());
            r.antMatchers(HttpMethod.PATCH, a.accessesArr(AccessLevels.UPDATE)).hasAnyAuthority(ADMINISTRATION, a.getName());
            r.antMatchers(HttpMethod.OPTIONS, a.accessesArr(AccessLevels.DELETE)).hasAnyAuthority(ADMINISTRATION, a.getName());
            r.antMatchers(HttpMethod.DELETE, a.accessesArr(AccessLevels.DELETE)).hasAnyAuthority(ADMINISTRATION, a.getName());
        }


        r.anyRequest()
//                .authenticated()
                .hasAuthority(ADMINISTRATION)
                .and().logout().logoutSuccessUrl("/").permitAll();

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(this.tokenStore);
    }
}
