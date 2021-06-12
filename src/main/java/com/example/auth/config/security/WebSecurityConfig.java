package com.example.auth.config.security;

import com.example.auth.services.CustomUserDetailsService;
import com.example.auth.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@Order(SecurityProperties.DEFAULT_FILTER_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    //
//    @Autowired
//    @Bean
//    public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
//        builder.userDetailsService(userDetailsService).passwordEncoder(PasswordUtil.getBCryptPasswordEncoder());
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(
                        "/resources/**",
                        "/fonts/**",
                        "/material/**",
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/uploads/**"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String ADMINISTRATION = "ADMINISTRATION";
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/api/**",
                        "/rest/**",
                        "/oauth/token",
                        "/",
                        "/login",
                        "/logout",
                        "/register",
                        "/reset-password/**",
                        "/public/**",
                        "/p/**",
                        "/chat/**",
                        "/topic/**"
                )
                .permitAll()
                .antMatchers("/admin/**")
                .hasAuthority(ADMINISTRATION)
                .anyRequest()
                .hasAuthority(ADMINISTRATION)
//                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/admin/dashboard")
                .permitAll()
                .and()
                .rememberMe()
                .key("absym3h4uhd");
        http
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID")
                .permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("pass").roles("USER","HOTEL","ADMIN");
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(PasswordUtil.getBCryptPasswordEncoder());
    }


}
