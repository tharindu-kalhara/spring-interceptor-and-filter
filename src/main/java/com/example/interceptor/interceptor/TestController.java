package com.example.interceptor.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {
    @GetMapping("test")
    public ResponseEntity<?> test(HttpServletResponse response) {
        System.out.println("TestController.test");
        System.out.println("response.getStatus " + response.getStatus());
        return new ResponseEntity<>("test", HttpStatus.OK);
    }
}
