package org.eazybank.controller;

import lombok.RequiredArgsConstructor;
import org.eazybank.dtos.CustomerDto;
import org.eazybank.entities.Customer;
import org.eazybank.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody CustomerDto customerDto) {
        try {
            String hashPwd = passwordEncoder.encode(customerDto.getPassword());
            Customer savedCustomer = customerRepository.save(new Customer(
                    customerDto.getEmail(),
                    hashPwd,
                    customerDto.getRole()
            ));

            if (savedCustomer.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("Given user details are succesfully registered");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User registration failed");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred: " + ex.getMessage());
        }
    }

}
