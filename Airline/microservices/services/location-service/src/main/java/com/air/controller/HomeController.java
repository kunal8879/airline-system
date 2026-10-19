package com.air.controller;

import com.air.payload.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public ApiResponse HomeController() {
        ApiResponse response = new ApiResponse();
        response.setMessage("Test");
        return response;
    }
}
