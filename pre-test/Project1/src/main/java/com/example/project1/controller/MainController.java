package com.example.project1.controller;

import com.example.project1.dto.User;
import com.example.project1.exception.InvalidDataFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class MainController {
    @RequestMapping("/")
    public ResponseEntity<?> defaultRequest() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/server-health-check")
    public ResponseEntity<?> serverHealthCheck() {
        HashMap<String, String> result = new HashMap<>();
        result.put("result", "ok");
        return ResponseEntity.ok(result);
    }

    @PostMapping("/echo")
    public ResponseEntity<?> echo(@RequestBody @Validated User user, Errors errors) {
        if (errors.hasErrors()) {
            throw new InvalidDataFormatException("Invalid data format");
        }
        return ResponseEntity.ok(user);
    }
}
