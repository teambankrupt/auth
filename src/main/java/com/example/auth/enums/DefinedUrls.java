package com.example.auth.enums;

public enum DefinedUrls {

	HTTP_PUBLIC(null, new String[]{
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
			"/connect/**",
			"/topic/**"
	}),
	WEB_PUBLIC(null, new String[]{
			"/resources/**",
			"/fonts/**",
			"/material/**",
			"/css/**",
			"/js/**",
			"/images/**",
			"/uploads/**"
	}),
	API_PUBLIC(null, new String[]{
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
			"/api/*/public/**"
	}),
	API_PREFIX("/api/**", null),
	ADMINISTRATIVE_URLS(null, new String[]{
			"/admin/*"
	}),
	API_ADMINISTRATIVE_URLS(null, new String[]{
			"/api/*/admin/**"
	}),
	LOGIN_URL("/login", null),
	LOGOUT_URL("/logout", null),
	LOGIN_FAILURE_URL("/login?error", null),
	ACCESS_DENIED_URL("/login?access-denied", null),
	DASHBOARD_URL("/admin/dashboard", null);


	private final String url;
	private final String[] urls;

	DefinedUrls(String url, String[] urls) {
		this.url = url;
		this.urls = urls;
	}

	public String[] getUrls() {
		return urls;
	}

	public String getUrl() {
		return url;
	}
}
