package com.example.auth.services;

import com.example.auth.models.mappers.RequestCredentialsMapper;
import com.example.auth.repositories.RequestCredentialsRepo;
import com.example.auth.utils.NetworkUtil;
import com.example.common.utils.TimeUtility;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
@Scope("singleton")
public class LoginAttemptService {
    private final RequestCredentialsRepo requestCredentialsRepo;
    private final RequestCredentialsMapper requestCredentialsMapper;
    private final int MAX_ATTEMPT = 5;

    public LoginAttemptService(RequestCredentialsRepo requestCredentialsRepo, RequestCredentialsMapper requestCredentialsMapper) {
        super();
        this.requestCredentialsRepo = requestCredentialsRepo;
        this.requestCredentialsMapper = requestCredentialsMapper;
    }

    @Transactional
    public void loginSucceeded() {
        requestCredentialsRepo.invalidate(
                NetworkUtil.getClientIP(),
                TimeUtility.getDayStart(Instant.now()),
                TimeUtility.getDayEnd(Instant.now())
        );
    }

    public void loginFailed() {
        var requestCredentials = this.requestCredentialsMapper.toEntity(
                NetworkUtil.getRequestCredentials()
        );
        this.requestCredentialsRepo.save(requestCredentials);
    }

    public boolean isBlocked() {
        var attemptCount = requestCredentialsRepo.count(
                NetworkUtil.getClientIP(),
                false,
                Instant.now().minus(1, ChronoUnit.HOURS),
                Instant.now()
        );
        return attemptCount >= MAX_ATTEMPT;
    }
}
