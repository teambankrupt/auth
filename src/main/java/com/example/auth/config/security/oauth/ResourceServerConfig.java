package com.example.auth.config.security.oauth;

import com.example.auth.entities.UrlAccess;
import com.example.auth.enums.AccessLevels;
import com.example.auth.enums.DefinedUrls;
import com.example.auth.enums.Privileges;
import com.example.auth.filters.CorsFilter;
import com.example.auth.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
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

    @Bean
    CorsFilter corsFilter() {
        return new CorsFilter();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry r = http
                .addFilterBefore(corsFilter(), UsernamePasswordAuthenticationFilter.class)
                .antMatcher(DefinedUrls.API_PREFIX.getUrl())
                .authorizeRequests()
                .antMatchers(
                        DefinedUrls.API_PUBLIC.getUrls()
                )
                .permitAll();

        Arrays.stream(HttpMethod.values())
                .forEach(method ->
                        r.antMatchers(method, DefinedUrls.API_ADMINISTRATIVE_URLS.getUrls())
                                .hasAnyAuthority(Privileges.ADMINISTRATION.name())
                );

        this.grantAccesses(r);

        r.anyRequest()
                .hasAuthority(Privileges.ADMINISTRATION.name())
                .and()
                .logout().logoutSuccessUrl("/").permitAll();

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(this.tokenStore);
    }

    private void grantAccesses(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry r) {
        List<UrlAccess> accesses = this.authService.getUrlAccesses();
        Set<String> urls = accesses.stream().map(UrlAccess::getUrl).collect(Collectors.toSet());

        for (String url : urls) {
            r.antMatchers(HttpMethod.GET, url).hasAnyAuthority(matchPrivileges(accesses, url, AccessLevels.READ).toArray(new String[0]));
            r.antMatchers(HttpMethod.POST, url).hasAnyAuthority(matchPrivileges(accesses, url, AccessLevels.CREATE).toArray(new String[0]));
            r.antMatchers(HttpMethod.PUT, url).hasAnyAuthority(matchPrivileges(accesses, url, AccessLevels.UPDATE).toArray(new String[0]));
            r.antMatchers(HttpMethod.PATCH, url).hasAnyAuthority(matchPrivileges(accesses, url, AccessLevels.UPDATE).toArray(new String[0]));
            r.antMatchers(HttpMethod.DELETE, url).hasAnyAuthority(matchPrivileges(accesses, url, AccessLevels.DELETE).toArray(new String[0]));

            // Enable Options Access
            r.antMatchers(HttpMethod.OPTIONS, url).permitAll();

            String[] allPrivileges = matchPrivileges(accesses, url, AccessLevels.ALL).toArray(new String[0]);
            if (allPrivileges.length > 0)
                r.antMatchers(url).hasAnyAuthority(allPrivileges);
        }

    }

    List<String> matchPrivileges(List<UrlAccess> accesses, String url, AccessLevels accessLevel) {
        List<String> matched = accesses.stream()
                .filter(a -> a.getUrl().equals(url))
                .filter(a -> a.getAccessLevel().equals(accessLevel))
                .map(a -> a.getPrivilege().getName())
                .collect(Collectors.toList());
        matched.add(Privileges.ADMINISTRATION.name());
        return matched;
    }

}
