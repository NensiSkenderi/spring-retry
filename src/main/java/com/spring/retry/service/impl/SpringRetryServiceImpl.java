package com.spring.retry.service.impl;

import com.spring.retry.service.SpringRetryService;
import org.springframework.stereotype.Component;

@Component
public class SpringRetryServiceImpl implements SpringRetryService {

    @Override
    public String candidateOfRetry(boolean simulateRetry, boolean simulateFallback) {
        if(simulateRetry){
            //so if simulateFallback is false this will be called 3 times
            System.out.println("Retry is true so we simulate exception scenario");
                if(simulateFallback) {
                    System.out.println("fallback true, simulating fallback");
                    throw new RuntimeException();
                }
            throw new NullPointerException("Simulated spring retry");
        }

        return "Hello from backend";
    }

    @Override
    public String fallbackMethod(RuntimeException e) {
        System.out.println("All retries completed, so Fallback method called!!!");
        return "All retries completed, so Fallback method called!!!";
    }
}
