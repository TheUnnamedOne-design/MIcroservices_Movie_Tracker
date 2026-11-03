package com.example.ApiGateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/health")
    public ResponseEntity<String> health()
    {
        return ResponseEntity.status(HttpStatus.OK).body("API Gateway is running fine");
    }

}
