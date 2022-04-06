package com.example.auth.config.security;

import com.example.auth.enums.DefinedUrls;
import com.example.auth.enums.Privileges;
import com.example.auth.services.CustomUserDetailsService;
import com.example.auth.utils.PasswordUtil;
import com.example.common.utils.SessionIdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

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

	@Override
	public void configure(WebSecurity web) {
		web
				.ignoring()
				.antMatchers(
						DefinedUrls.WEB_PUBLIC.getUrls()
				);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers(DefinedUrls.HTTP_PUBLIC.getUrls())
				.permitAll()
				.antMatchers(DefinedUrls.ADMINISTRATIVE_URLS.getUrls())
				.hasAuthority(Privileges.ADMINISTRATION.name())
				.anyRequest()
				.hasAuthority(Privileges.ADMINISTRATION.name())
				.and()
				.formLogin()
				.loginPage(DefinedUrls.LOGIN_URL.getUrl())
				.loginProcessingUrl(DefinedUrls.LOGIN_URL.getUrl())
				.failureUrl(DefinedUrls.LOGIN_FAILURE_URL.getUrl())
				.defaultSuccessUrl(DefinedUrls.DASHBOARD_URL.getUrl())
				.permitAll()
				.and()
				.rememberMe()
				.key(
						"bankrupt_" + SessionIdentifierGenerator.alphanumeric(6)
				);
		http
				.logout()
				.logoutUrl(DefinedUrls.LOGOUT_URL.getUrl())
				.logoutSuccessUrl(DefinedUrls.LOGIN_URL.getUrl())
				.deleteCookies("JSESSIONID")
				.permitAll();
		http
				.exceptionHandling()
				.accessDeniedPage(DefinedUrls.ACCESS_DENIED_URL.getUrl())
				.authenticationEntryPoint((request, response, authException) -> {
					response.sendError(HttpServletResponse.SC_FORBIDDEN);
				});
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(this.userDetailsService)
				.passwordEncoder(PasswordUtil.getBCryptPasswordEncoder());
	}


}
