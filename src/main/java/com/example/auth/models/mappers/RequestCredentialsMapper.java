package com.example.auth.models.mappers;

import com.example.auth.entities.RequestCredentials;
import com.example.auth.models.RequestCredentialsRecord;
import org.springframework.stereotype.Component;

@Component
public class RequestCredentialsMapper {

    public RequestCredentials toEntity(RequestCredentialsRecord record) {
        if (record == null) {
            return null;
        }
        return new RequestCredentials(
                record.ip(),
                false,
                record.uri(),
                record.body(),
                record.userAgentHeader(),
                record.xForwardedForHeader(),
                record.authorizationHeader(),
                record.cookieHeader(),
                record.refererHeader(),
                record.xFrameOptionsHeader(),
                record.contentTypeHeader(),
                record.originHeader(),
                record.xHTTPMethodOverrideHeader(),
                record.contentSecurityPolicyHeader(),
                record.acceptHeader(),
                record.acceptLanguageHeader(),
                record.hostHeader(),
                record.cacheControlHeader(),
                record.connectionHeader(),
                record.contentLengthHeader(),
                record.ifModifiedSinceHeader(),
                record.ifNoneMatchHeader(),
                record.acceptEncodingHeader(),
                record.rangeHeader(),
                record.xRequestedWithHeader(),
                record.xForwardedHostHeader(),
                record.xForwardedProtoHeader(),
                record.dntHeader(),
                record.acceptCharsetHeader(),
                record.acceptDatetimeHeader(),
                record.accessControlRequestMethodHeader(),
                record.accessControlRequestHeadersHeader(),
                record.forwardHeader(),
                record.maxForwardsHeader(),
                record.pragmaHeader(),
                record.proxyAuthorizationHeader(),
                record.TEHeader(),
                record.upgradeHeader(),
                record.viaHeader(),
                record.warningHeader(),
                record.accessControlAllowOriginHeader(),
                record.accessControlExposeHeadersHeader(),
                record.accessControlAllowCredentialsHeader(),
                record.accessControlMaxAgeHeader(),
                record.accessControlAllowMethodsHeader(),
                record.accessControlAllowHeadersHeader(),
                record.authorizationInfoHeader(),
                record.contentEncodingHeader(),
                record.forwardForHeader(),
                record.ifRangeHeader(),
                record.ifUnmodifiedSinceHeader()
        );
    }

    public RequestCredentialsRecord toRecord(RequestCredentials entity) {
        if (entity == null) {
            return null;
        }
        return new RequestCredentialsRecord(
                entity.getIp(),
                entity.isInvalidated(),
                entity.getUri(),
                entity.getBody(),
                entity.getUserAgentHeader(),
                entity.getForwardForHeader(),
                entity.getAuthorizationHeader(),
                entity.getCookieHeader(),
                entity.getRefererHeader(),
                entity.getxFrameOptionsHeader(),
                entity.getContentTypeHeader(),
                entity.getOriginHeader(),
                entity.getxHTTPMethodOverrideHeader(),
                entity.getContentSecurityPolicyHeader(),
                entity.getAcceptHeader(),
                entity.getAcceptLanguageHeader(),
                entity.getHostHeader(),
                entity.getCacheControlHeader(),
                entity.getConnectionHeader(),
                entity.getContentLengthHeader(),
                entity.getIfModifiedSinceHeader(),
                entity.getIfNoneMatchHeader(),
                entity.getAcceptEncodingHeader(),
                entity.getRangeHeader(),
                entity.getxRequestedWithHeader(),
                entity.getxForwardedHostHeader(),
                entity.getxForwardedProtoHeader(),
                entity.getDntHeader(),
                entity.getAcceptCharsetHeader(),
                entity.getAcceptDatetimeHeader(),
                entity.getAccessControlRequestMethodHeader(),
                entity.getAccessControlRequestHeadersHeader(),
                entity.getForwardHeader(),
                entity.getMaxForwardsHeader(),
                entity.getPragmaHeader(),
                entity.getProxyAuthorizationHeader(),
                entity.getTEHeader(),
                entity.getUpgradeHeader(),
                entity.getViaHeader(),
                entity.getWarningHeader(),
                entity.getAccessControlAllowOriginHeader(),
                entity.getAccessControlExposeHeadersHeader(),
                entity.getAccessControlAllowCredentialsHeader(),
                entity.getAccessControlMaxAgeHeader(),
                entity.getAccessControlAllowMethodsHeader(),
                entity.getAccessControlAllowHeadersHeader(),
                entity.getAuthorizationInfoHeader(),
                entity.getContentEncodingHeader(),
                entity.getForwardForHeader(),
                entity.getIfRangeHeader(),
                entity.getIfUnmodifiedSinceHeader(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
