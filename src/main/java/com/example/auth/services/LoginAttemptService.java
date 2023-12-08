package com.example.auth.services;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
@Scope("singleton")
public class LoginAttemptService {
    private final int MAX_ATTEMPT = 10;
    private LoadingCache<String, Integer> attemptsCache;

    public LoginAttemptService() {
        super();
        attemptsCache = CacheBuilder.newBuilder().
                expireAfterWrite(1, TimeUnit.DAYS).build(new CacheLoader<String, Integer>() {
                    public Integer load(String key) {
                        return 0;
                    }
                });
    }

    public void loginSucceeded(String key) {
        attemptsCache.invalidate(key);
    }

    public void loginFailed(String key) {
        int attempts;
        try {
            attempts = attemptsCache.get(key);
            System.out.println("CACHE: Putting key: " + key);
            System.out.println("CACHE: Current: " + attempts);
        } catch (ExecutionException e) {
            attempts = 0;
            System.out.println("CACHE: Exception: " + e.getMessage());
            System.out.println("CACHE: attempts reset");
        }
        System.out.println("CACHE: attempts="+attempts);
        attempts++;
        System.out.println("CACHE: attempts="+attempts);
        attemptsCache.put(key, attempts);
        System.out.println("CACHE: " + attemptsCache.asMap().toString());
    }

    public boolean isBlocked(String key) {
        try {
            return attemptsCache.get(key) >= MAX_ATTEMPT;
        } catch (ExecutionException e) {
            return false;
        }
    }
}
