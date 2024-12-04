package org.eazybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.UserDetailsManager;

@SpringBootApplication
//@EnableJpaRepositories("com.eazybytes.repository") these optional since the @SpringBootApplication is in main folder
//@EntityScan("com.eazybytes.entities")
public class EazyBankBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EazyBankBackendApplication.class, args);
    }

}
