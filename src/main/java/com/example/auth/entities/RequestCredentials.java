package com.example.auth.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "request_credentials", schema = "auth")
public class RequestCredentials extends BaseEntity {

    // Significant Headers
    @Column(name = "ip", columnDefinition = "inet")
    private String ip;

    @Column(name = "body", columnDefinition = "text")
    private String body;

    @Column(name = "user_agent_header", columnDefinition = "text")
    private String userAgentHeader;

    @Column(name = "x_forwarded_for_header", columnDefinition = "text")
    private String xForwardedForHeader;

    @Column(name = "authorization_header", columnDefinition = "text")
    private String authorizationHeader;

    @Column(name = "cookie_header", columnDefinition = "text")
    private String cookieHeader;

    @Column(name = "referer_header", columnDefinition = "text")
    private String refererHeader;

    @Column(name = "x_frame_options_header", length = 256)
    private String xFrameOptionsHeader;

    @Column(name = "content_type_header", length = 256)
    private String contentTypeHeader;

    @Column(name = "origin_header", length = 256)
    private String originHeader;

    @Column(name = "x_http_method_override_header", length = 256)
    private String xHTTPMethodOverrideHeader;

    @Column(name = "content_security_policy_header", columnDefinition = "text")
    private String contentSecurityPolicyHeader;

    // Non-Significant Headers
    @Column(name = "accept_header", columnDefinition = "text")
    private String acceptHeader;

    @Column(name = "accept_language_header", length = 256)
    private String acceptLanguageHeader;

    @Column(name = "host_header", length = 256)
    private String hostHeader;

    @Column(name = "cache_control_header", length = 256)
    private String cacheControlHeader;

    @Column(name = "connection_header", length = 256)
    private String connectionHeader;

    @Column(name = "content_length_header", length = 256)
    private String contentLengthHeader;

    @Column(name = "if_modified_since_header", length = 256)
    private String ifModifiedSinceHeader;

    @Column(name = "if_none_match_header", length = 256)
    private String ifNoneMatchHeader;

    @Column(name = "accept_encoding_header", columnDefinition = "text")
    private String acceptEncodingHeader;

    @Column(name = "range_header", length = 256)
    private String rangeHeader;

    @Column(name = "x_requested_with_header", length = 256)
    private String xRequestedWithHeader;

    @Column(name = "x_forwarded_host_header", length = 256)
    private String xForwardedHostHeader;

    @Column(name = "x_forwarded_proto_header", length = 256)
    private String xForwardedProtoHeader;

    @Column(name = "dnt_header", length = 256)
    private String dntHeader;

    @Column(name = "accept_charset_header", length = 256)
    private String acceptCharsetHeader;

    @Column(name = "accept_datetime_header", length = 256)
    private String acceptDatetimeHeader;

    @Column(name = "access_control_request_method_header", length = 256)
    private String accessControlRequestMethodHeader;

    @Column(name = "access_control_request_headers_header", length = 256)
    private String accessControlRequestHeadersHeader;

    @Column(name = "forward_header", length = 256)
    private String forwardHeader;

    @Column(name = "max_forwards_header", length = 256)
    private String maxForwardsHeader;

    @Column(name = "pragma_header", length = 256)
    private String pragmaHeader;

    @Column(name = "proxy_authorization_header", length = 256)
    private String proxyAuthorizationHeader;

    @Column(name = "te_header", length = 256)
    private String TEHeader;

    @Column(name = "upgrade_header", length = 256)
    private String upgradeHeader;

    @Column(name = "via_header", length = 256)
    private String viaHeader;

    @Column(name = "warning_header", length = 256)
    private String warningHeader;

    @Column(name = "access_control_allow_origin_header", length = 256)
    private String accessControlAllowOriginHeader;

    @Column(name = "access_control_expose_headers_header", length = 256)
    private String accessControlExposeHeadersHeader;

    @Column(name = "access_control_allow_credentials_header", length = 256)
    private String accessControlAllowCredentialsHeader;

    @Column(name = "access_control_max_age_header", length = 256)
    private String accessControlMaxAgeHeader;

    @Column(name = "access_control_allow_methods_header", length = 256)
    private String accessControlAllowMethodsHeader;

    @Column(name = "access_control_allow_headers_header", length = 256)
    private String accessControlAllowHeadersHeader;

    @Column(name = "authorization_info_header", length = 256)
    private String authorizationInfoHeader;

    @Column(name = "content_encoding_header", length = 256)
    private String contentEncodingHeader;

    @Column(name = "forwarded_for_header", length = 256)
    private String forwardForHeader;

    @Column(name = "if_range_header", length = 256)
    private String ifRangeHeader;

    @Column(name = "if_unmodified_since_header", length = 256)
    private String ifUnmodifiedSinceHeader;

    public RequestCredentials() {
    }

    public RequestCredentials(
            String ip, String body, String userAgentHeader, String xForwardedForHeader,
            String authorizationHeader, String cookieHeader, String refererHeader,
            String xFrameOptionsHeader, String contentTypeHeader, String originHeader,
            String xHTTPMethodOverrideHeader, String contentSecurityPolicyHeader, String acceptHeader,
            String acceptLanguageHeader, String hostHeader, String cacheControlHeader,
            String connectionHeader, String contentLengthHeader, String ifModifiedSinceHeader,
            String ifNoneMatchHeader, String acceptEncodingHeader, String rangeHeader,
            String xRequestedWithHeader, String xForwardedHostHeader, String xForwardedProtoHeader,
            String dntHeader, String acceptCharsetHeader, String acceptDatetimeHeader,
            String accessControlRequestMethodHeader, String accessControlRequestHeadersHeader,
            String forwardHeader, String maxForwardsHeader, String pragmaHeader,
            String proxyAuthorizationHeader, String TEHeader, String upgradeHeader, String viaHeader,
            String warningHeader, String accessControlAllowOriginHeader,
            String accessControlExposeHeadersHeader, String accessControlAllowCredentialsHeader,
            String accessControlMaxAgeHeader, String accessControlAllowMethodsHeader, String accessControlAllowHeadersHeader,
            String authorizationInfoHeader, String contentEncodingHeader, String forwardForHeader,
            String ifRangeHeader, String ifUnmodifiedSinceHeader
    ) {
        this.ip = ip;
        this.userAgentHeader = userAgentHeader;
        this.xForwardedForHeader = xForwardedForHeader;
        this.authorizationHeader = authorizationHeader;
        this.cookieHeader = cookieHeader;
        this.refererHeader = refererHeader;
        this.xFrameOptionsHeader = xFrameOptionsHeader;
        this.contentTypeHeader = contentTypeHeader;
        this.originHeader = originHeader;
        this.xHTTPMethodOverrideHeader = xHTTPMethodOverrideHeader;
        this.contentSecurityPolicyHeader = contentSecurityPolicyHeader;
        this.acceptHeader = acceptHeader;
        this.acceptLanguageHeader = acceptLanguageHeader;
        this.hostHeader = hostHeader;
        this.cacheControlHeader = cacheControlHeader;
        this.connectionHeader = connectionHeader;
        this.contentLengthHeader = contentLengthHeader;
        this.ifModifiedSinceHeader = ifModifiedSinceHeader;
        this.ifNoneMatchHeader = ifNoneMatchHeader;
        this.acceptEncodingHeader = acceptEncodingHeader;
        this.rangeHeader = rangeHeader;
        this.xRequestedWithHeader = xRequestedWithHeader;
        this.xForwardedHostHeader = xForwardedHostHeader;
        this.xForwardedProtoHeader = xForwardedProtoHeader;
        this.dntHeader = dntHeader;
        this.acceptCharsetHeader = acceptCharsetHeader;
        this.acceptDatetimeHeader = acceptDatetimeHeader;
        this.accessControlRequestMethodHeader = accessControlRequestMethodHeader;
        this.accessControlRequestHeadersHeader = accessControlRequestHeadersHeader;
        this.forwardHeader = forwardHeader;
        this.maxForwardsHeader = maxForwardsHeader;
        this.pragmaHeader = pragmaHeader;
        this.proxyAuthorizationHeader = proxyAuthorizationHeader;
        this.TEHeader = TEHeader;
        this.upgradeHeader = upgradeHeader;
        this.viaHeader = viaHeader;
        this.warningHeader = warningHeader;
        this.accessControlAllowOriginHeader = accessControlAllowOriginHeader;
        this.accessControlExposeHeadersHeader = accessControlExposeHeadersHeader;
        this.accessControlAllowCredentialsHeader = accessControlAllowCredentialsHeader;
        this.accessControlMaxAgeHeader = accessControlMaxAgeHeader;
        this.accessControlAllowMethodsHeader = accessControlAllowMethodsHeader;
        this.accessControlAllowHeadersHeader = accessControlAllowHeadersHeader;
        this.authorizationInfoHeader = authorizationInfoHeader;
        this.contentEncodingHeader = contentEncodingHeader;
        this.forwardForHeader = forwardForHeader;
        this.ifRangeHeader = ifRangeHeader;
        this.ifUnmodifiedSinceHeader = ifUnmodifiedSinceHeader;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgentHeader() {
        return userAgentHeader;
    }

    public void setUserAgentHeader(String userAgentHeader) {
        this.userAgentHeader = userAgentHeader;
    }

    public String getxForwardedForHeader() {
        return xForwardedForHeader;
    }

    public void setxForwardedForHeader(String xForwardedForHeader) {
        this.xForwardedForHeader = xForwardedForHeader;
    }

    public String getAuthorizationHeader() {
        return authorizationHeader;
    }

    public void setAuthorizationHeader(String authorizationHeader) {
        this.authorizationHeader = authorizationHeader;
    }

    public String getCookieHeader() {
        return cookieHeader;
    }

    public void setCookieHeader(String cookieHeader) {
        this.cookieHeader = cookieHeader;
    }

    public String getRefererHeader() {
        return refererHeader;
    }

    public void setRefererHeader(String refererHeader) {
        this.refererHeader = refererHeader;
    }

    public String getxFrameOptionsHeader() {
        return xFrameOptionsHeader;
    }

    public void setxFrameOptionsHeader(String xFrameOptionsHeader) {
        this.xFrameOptionsHeader = xFrameOptionsHeader;
    }

    public String getContentTypeHeader() {
        return contentTypeHeader;
    }

    public void setContentTypeHeader(String contentTypeHeader) {
        this.contentTypeHeader = contentTypeHeader;
    }

    public String getOriginHeader() {
        return originHeader;
    }

    public void setOriginHeader(String originHeader) {
        this.originHeader = originHeader;
    }

    public String getxHTTPMethodOverrideHeader() {
        return xHTTPMethodOverrideHeader;
    }

    public void setxHTTPMethodOverrideHeader(String xHTTPMethodOverrideHeader) {
        this.xHTTPMethodOverrideHeader = xHTTPMethodOverrideHeader;
    }

    public String getContentSecurityPolicyHeader() {
        return contentSecurityPolicyHeader;
    }

    public void setContentSecurityPolicyHeader(String contentSecurityPolicyHeader) {
        this.contentSecurityPolicyHeader = contentSecurityPolicyHeader;
    }

    public String getAcceptHeader() {
        return acceptHeader;
    }

    public void setAcceptHeader(String acceptHeader) {
        this.acceptHeader = acceptHeader;
    }

    public String getAcceptLanguageHeader() {
        return acceptLanguageHeader;
    }

    public void setAcceptLanguageHeader(String acceptLanguageHeader) {
        this.acceptLanguageHeader = acceptLanguageHeader;
    }

    public String getHostHeader() {
        return hostHeader;
    }

    public void setHostHeader(String hostHeader) {
        this.hostHeader = hostHeader;
    }

    public String getCacheControlHeader() {
        return cacheControlHeader;
    }

    public void setCacheControlHeader(String cacheControlHeader) {
        this.cacheControlHeader = cacheControlHeader;
    }

    public String getConnectionHeader() {
        return connectionHeader;
    }

    public void setConnectionHeader(String connectionHeader) {
        this.connectionHeader = connectionHeader;
    }

    public String getContentLengthHeader() {
        return contentLengthHeader;
    }

    public void setContentLengthHeader(String contentLengthHeader) {
        this.contentLengthHeader = contentLengthHeader;
    }

    public String getIfModifiedSinceHeader() {
        return ifModifiedSinceHeader;
    }

    public void setIfModifiedSinceHeader(String ifModifiedSinceHeader) {
        this.ifModifiedSinceHeader = ifModifiedSinceHeader;
    }

    public String getIfNoneMatchHeader() {
        return ifNoneMatchHeader;
    }

    public void setIfNoneMatchHeader(String ifNoneMatchHeader) {
        this.ifNoneMatchHeader = ifNoneMatchHeader;
    }

    public String getAcceptEncodingHeader() {
        return acceptEncodingHeader;
    }

    public void setAcceptEncodingHeader(String acceptEncodingHeader) {
        this.acceptEncodingHeader = acceptEncodingHeader;
    }

    public String getRangeHeader() {
        return rangeHeader;
    }

    public void setRangeHeader(String rangeHeader) {
        this.rangeHeader = rangeHeader;
    }

    public String getxRequestedWithHeader() {
        return xRequestedWithHeader;
    }

    public void setxRequestedWithHeader(String xRequestedWithHeader) {
        this.xRequestedWithHeader = xRequestedWithHeader;
    }

    public String getxForwardedHostHeader() {
        return xForwardedHostHeader;
    }

    public void setxForwardedHostHeader(String xForwardedHostHeader) {
        this.xForwardedHostHeader = xForwardedHostHeader;
    }

    public String getxForwardedProtoHeader() {
        return xForwardedProtoHeader;
    }

    public void setxForwardedProtoHeader(String xForwardedProtoHeader) {
        this.xForwardedProtoHeader = xForwardedProtoHeader;
    }

    public String getDntHeader() {
        return dntHeader;
    }

    public void setDntHeader(String dntHeader) {
        this.dntHeader = dntHeader;
    }

    public String getAcceptCharsetHeader() {
        return acceptCharsetHeader;
    }

    public void setAcceptCharsetHeader(String acceptCharsetHeader) {
        this.acceptCharsetHeader = acceptCharsetHeader;
    }

    public String getAcceptDatetimeHeader() {
        return acceptDatetimeHeader;
    }

    public void setAcceptDatetimeHeader(String acceptDatetimeHeader) {
        this.acceptDatetimeHeader = acceptDatetimeHeader;
    }

    public String getAccessControlRequestMethodHeader() {
        return accessControlRequestMethodHeader;
    }

    public void setAccessControlRequestMethodHeader(String accessControlRequestMethodHeader) {
        this.accessControlRequestMethodHeader = accessControlRequestMethodHeader;
    }

    public String getAccessControlRequestHeadersHeader() {
        return accessControlRequestHeadersHeader;
    }

    public void setAccessControlRequestHeadersHeader(String accessControlRequestHeadersHeader) {
        this.accessControlRequestHeadersHeader = accessControlRequestHeadersHeader;
    }

    public String getForwardHeader() {
        return forwardHeader;
    }

    public void setForwardHeader(String forwardHeader) {
        this.forwardHeader = forwardHeader;
    }

    public String getMaxForwardsHeader() {
        return maxForwardsHeader;
    }

    public void setMaxForwardsHeader(String maxForwardsHeader) {
        this.maxForwardsHeader = maxForwardsHeader;
    }

    public String getPragmaHeader() {
        return pragmaHeader;
    }

    public void setPragmaHeader(String pragmaHeader) {
        this.pragmaHeader = pragmaHeader;
    }

    public String getProxyAuthorizationHeader() {
        return proxyAuthorizationHeader;
    }

    public void setProxyAuthorizationHeader(String proxyAuthorizationHeader) {
        this.proxyAuthorizationHeader = proxyAuthorizationHeader;
    }

    public String getTEHeader() {
        return TEHeader;
    }

    public void setTEHeader(String TEHeader) {
        this.TEHeader = TEHeader;
    }

    public String getUpgradeHeader() {
        return upgradeHeader;
    }

    public void setUpgradeHeader(String upgradeHeader) {
        this.upgradeHeader = upgradeHeader;
    }

    public String getViaHeader() {
        return viaHeader;
    }

    public void setViaHeader(String viaHeader) {
        this.viaHeader = viaHeader;
    }

    public String getWarningHeader() {
        return warningHeader;
    }

    public void setWarningHeader(String warningHeader) {
        this.warningHeader = warningHeader;
    }

    public String getAccessControlAllowOriginHeader() {
        return accessControlAllowOriginHeader;
    }

    public void setAccessControlAllowOriginHeader(String accessControlAllowOriginHeader) {
        this.accessControlAllowOriginHeader = accessControlAllowOriginHeader;
    }

    public String getAccessControlExposeHeadersHeader() {
        return accessControlExposeHeadersHeader;
    }

    public void setAccessControlExposeHeadersHeader(String accessControlExposeHeadersHeader) {
        this.accessControlExposeHeadersHeader = accessControlExposeHeadersHeader;
    }

    public String getAccessControlAllowCredentialsHeader() {
        return accessControlAllowCredentialsHeader;
    }

    public void setAccessControlAllowCredentialsHeader(String accessControlAllowCredentialsHeader) {
        this.accessControlAllowCredentialsHeader = accessControlAllowCredentialsHeader;
    }

    public String getAccessControlMaxAgeHeader() {
        return accessControlMaxAgeHeader;
    }

    public void setAccessControlMaxAgeHeader(String accessControlMaxAgeHeader) {
        this.accessControlMaxAgeHeader = accessControlMaxAgeHeader;
    }

    public String getAccessControlAllowMethodsHeader() {
        return accessControlAllowMethodsHeader;
    }

    public void setAccessControlAllowMethodsHeader(String accessControlAllowMethodsHeader) {
        this.accessControlAllowMethodsHeader = accessControlAllowMethodsHeader;
    }

    public String getAccessControlAllowHeadersHeader() {
        return accessControlAllowHeadersHeader;
    }

    public void setAccessControlAllowHeadersHeader(String accessControlAllowHeadersHeader) {
        this.accessControlAllowHeadersHeader = accessControlAllowHeadersHeader;
    }

    public String getAuthorizationInfoHeader() {
        return authorizationInfoHeader;
    }

    public void setAuthorizationInfoHeader(String authorizationInfoHeader) {
        this.authorizationInfoHeader = authorizationInfoHeader;
    }

    public String getContentEncodingHeader() {
        return contentEncodingHeader;
    }

    public void setContentEncodingHeader(String contentEncodingHeader) {
        this.contentEncodingHeader = contentEncodingHeader;
    }

    public String getForwardForHeader() {
        return forwardForHeader;
    }

    public void setForwardForHeader(String forwardForHeader) {
        this.forwardForHeader = forwardForHeader;
    }

    public String getIfRangeHeader() {
        return ifRangeHeader;
    }

    public void setIfRangeHeader(String ifRangeHeader) {
        this.ifRangeHeader = ifRangeHeader;
    }

    public String getIfUnmodifiedSinceHeader() {
        return ifUnmodifiedSinceHeader;
    }

    public void setIfUnmodifiedSinceHeader(String ifUnmodifiedSinceHeader) {
        this.ifUnmodifiedSinceHeader = ifUnmodifiedSinceHeader;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
