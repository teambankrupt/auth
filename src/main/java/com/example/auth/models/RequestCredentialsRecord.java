package com.example.auth.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record RequestCredentialsRecord(
        // Significant Headers
        @JsonProperty("ip")
        String ip,
        @JsonProperty("invalidated")
        boolean invalidated,
        @JsonProperty("uri")
        String uri,
        @JsonProperty("body")
        String body,
        @JsonProperty("user_agent_header")
        String userAgentHeader,
        @JsonProperty("x_forwarded_for_header")
        String xForwardedForHeader,
        @JsonProperty("authorization_header")
        String authorizationHeader,
        @JsonProperty("cookie_header")
        String cookieHeader,
        @JsonProperty("referer_header")
        String refererHeader,
        @JsonProperty("x_frame_options_header")
        String xFrameOptionsHeader,
        @JsonProperty("content_type_header")
        String contentTypeHeader,
        @JsonProperty("origin_header")
        String originHeader,
        @JsonProperty("x_http_method_override_header")
        String xHTTPMethodOverrideHeader,
        @JsonProperty("content_security_policy_header")
        String contentSecurityPolicyHeader,

        // Non-Significant Headers
        @JsonProperty("accept_header")
        String acceptHeader,
        @JsonProperty("accept_language_header")
        String acceptLanguageHeader,
        @JsonProperty("host_header")
        String hostHeader,
        @JsonProperty("cache_control_header")
        String cacheControlHeader,
        @JsonProperty("connection_header")
        String connectionHeader,
        @JsonProperty("content_length_header")
        String contentLengthHeader,
        @JsonProperty("if_modified_since_header")
        String ifModifiedSinceHeader,
        @JsonProperty("if_none_match_header")
        String ifNoneMatchHeader,
        @JsonProperty("accept_encoding_header")
        String acceptEncodingHeader,
        @JsonProperty("range_header")
        String rangeHeader,
        @JsonProperty("x_requested_with_header")
        String xRequestedWithHeader,
        @JsonProperty("x_forwarded_host_header")
        String xForwardedHostHeader,
        @JsonProperty("x_forwarded_proto_header")
        String xForwardedProtoHeader,
        @JsonProperty("dnt_header")
        String dntHeader,
        @JsonProperty("accept_charset_header")
        String acceptCharsetHeader,
        @JsonProperty("accept_datetime_header")
        String acceptDatetimeHeader,
        @JsonProperty("access_control_request_method_header")
        String accessControlRequestMethodHeader,
        @JsonProperty("access_control_request_headers_header")
        String accessControlRequestHeadersHeader,
        @JsonProperty("forward_header")
        String forwardHeader,
        @JsonProperty("max_forwards_header")
        String maxForwardsHeader,
        @JsonProperty("pragma_header")
        String pragmaHeader,
        @JsonProperty("proxy_authorization_header")
        String proxyAuthorizationHeader,
        @JsonProperty("te_header")
        String TEHeader,
        @JsonProperty("upgrade_header")
        String upgradeHeader,
        @JsonProperty("via_header")
        String viaHeader,
        @JsonProperty("warning_header")
        String warningHeader,
        @JsonProperty("access_control_allow_origin_header")
        String accessControlAllowOriginHeader,
        @JsonProperty("access_control_expose_headers_header")
        String accessControlExposeHeadersHeader,
        @JsonProperty("access_control_allow_credentials_header")
        String accessControlAllowCredentialsHeader,
        @JsonProperty("access_control_max_age_header")
        String accessControlMaxAgeHeader,
        @JsonProperty("access_control_allow_methods_header")
        String accessControlAllowMethodsHeader,
        @JsonProperty("access_control_allow_headers_header")
        String accessControlAllowHeadersHeader,
        @JsonProperty("authorization_info_header")
        String authorizationInfoHeader,
        @JsonProperty("content_encoding_header")
        String contentEncodingHeader,
        @JsonProperty("forwarded_for_header")
        String forwardForHeader,
        @JsonProperty("if_range_header")
        String ifRangeHeader,
        @JsonProperty("if_unmodified_since_header")
        String ifUnmodifiedSinceHeader,
        @JsonProperty("created_at")
        Instant createdAt,
        @JsonProperty("updated_at")
        Instant updatedAt

) {
}
