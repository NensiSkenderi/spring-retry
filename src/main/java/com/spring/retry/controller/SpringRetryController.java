package com.spring.retry.controller;

import com.spring.retry.service.SpringRetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRetryController {

    @Autowired
    private SpringRetryService springRetryService;

    @GetMapping("/test")
    @ExceptionHandler(Exception.class)
    private String testSpringRetry(@RequestParam(required = false) boolean retry,
                                   @RequestParam(required = false) boolean fallback){
        System.out.println("Inside controller");
        return springRetryService.candidateOfRetry(retry, fallback);
    }
}
