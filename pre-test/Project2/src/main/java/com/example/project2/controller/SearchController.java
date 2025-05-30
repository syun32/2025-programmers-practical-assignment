package com.example.project2.controller;

import com.example.project2.domain.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@RestController
public class SearchController {
    private final String DATA_DIR = "./data/input";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/api/reservation/search")
    public ResponseEntity<?> searchByCustomerName(@RequestParam @NotBlank String customerName) {
        List<Customer> customers;
        try {
            customers = objectMapper.readValue(
                    Files.readAllBytes(Paths.get(DATA_DIR, "reservation.json")),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        List<Customer> response;
        if (customerName.equals("all")) {
            response = customers;
        }
        else {
            response = new ArrayList<>();
            for (Customer customer : customers) {
                if (customer.getCustomer_name().contains(customerName)) {
                    response.add(customer);
                }
            }
        }
        Collections.sort(response);

        return ResponseEntity.ok(response);
    }
}
