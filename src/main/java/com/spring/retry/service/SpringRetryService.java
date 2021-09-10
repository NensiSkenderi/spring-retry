package com.spring.retry.service;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

public interface SpringRetryService {

    @Retryable( value = NullPointerException.class, maxAttempts = 3)
    public String candidateOfRetry(boolean simulateRetry, boolean simulateFallback);

    @Recover
    public String fallbackMethod(RuntimeException e);
}
