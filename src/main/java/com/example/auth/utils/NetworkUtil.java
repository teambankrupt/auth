package com.example.auth.utils;

import com.example.auth.models.RequestCredentialsRecord;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class NetworkUtil {
    public static String getClientIP() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

    public static RequestCredentialsRecord getRequestCredentials() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        String ip = xForwardedForHeader == null ? request.getRemoteAddr() : xForwardedForHeader.split(",")[0];
        var requestBody = getRequestBody(request);
        return new RequestCredentialsRecord(
                ip,
                requestBody,
                request.getHeader("User-Agent"),
                xForwardedForHeader,
                request.getHeader("Authorization"),
                request.getHeader("Cookie"),
                request.getHeader("Referer"),
                request.getHeader("X-Frame-Options"),
                request.getHeader("Content-Type"),
                request.getHeader("Origin"),
                request.getHeader("X-HTTP-Method-Override"),
                request.getHeader("Content-Security-Policy"),

                request.getHeader("Accept"),
                request.getHeader("Accept-Language"),
                request.getHeader("Host"),
                request.getHeader("Cache-Control"),
                request.getHeader("Connection"),
                request.getHeader("Content-Length"),
                request.getHeader("If-Modified-Since"),
                request.getHeader("If-None-Match"),
                request.getHeader("Accept-Encoding"),
                request.getHeader("Range"),
                request.getHeader("X-Requested-With"),
                request.getHeader("X-Forwarded-Host"),
                request.getHeader("X-Forwarded-Proto"),
                request.getHeader("DNT"),
                request.getHeader("Accept-Charset"),
                request.getHeader("Accept-Datetime"),
                request.getHeader("Access-Control-Request-Method"),
                request.getHeader("Access-Control-Request-Headers"),
                request.getHeader("Forwarded"),
                request.getHeader("Max-Forwards"),
                request.getHeader("Pragma"),
                request.getHeader("Proxy-Authorization"),
                request.getHeader("TE"),
                request.getHeader("Upgrade"),
                request.getHeader("Via"),
                request.getHeader("Warning"),
                request.getHeader("Access-Control-Allow-Origin"),
                request.getHeader("Access-Control-Expose-Headers"),
                request.getHeader("Access-Control-Allow-Credentials"),
                request.getHeader("Access-Control-Max-Age"),
                request.getHeader("Access-Control-Allow-Methods"),
                request.getHeader("Access-Control-Allow-Headers"),
                request.getHeader("Authorization-Info"),
                request.getHeader("Content-Encoding"),
                request.getHeader("Forwarded-For"),
                request.getHeader("If-Range"),
                request.getHeader("If-Unmodified-Since")
        );
    }

    public static String getRequestBody(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8))
        ) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            return null;
        }

        return stringBuilder.toString();
    }
}
