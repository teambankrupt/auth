package com.example.auth.config.security;

import com.example.auth.entities.User;
import com.example.auth.entities.UserAuth;
import com.example.auth.repositories.UserRepo;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation")
@Component
public final class SecurityContext {

	private static UserRepo userRepo;
	private static UserAuth loggedInUser;

	public SecurityContext(UserRepo userRepo) {
		SecurityContext.userRepo = userRepo;
	}

	public static void updateAuthentication(UserAuth user) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	public static String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
			if (authentication.getPrincipal() instanceof String)
				return (String) authentication.getPrincipal();
			else
				return ((UserAuth) authentication.getPrincipal()).getUsername();
		}
		return null;
	}

	public static UserAuth getCurrentUser() {
		String username = getLoggedInUsername();
		User user = userRepo.find(username).orElse(null);
		return user == null ? null : new UserAuth(user);
	}

	public static boolean isAuthenticated() {
		return getCurrentUser() != null;
	}

	public static String getToken() {
		String token = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			token = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
		}
		return token;
	}
}
