package com.jcruz.reslerianadb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@RestController
public class ReslerianaDatabaseApp {

    public static void main(String[] args) {
        SpringApplication.run(ReslerianaDatabaseApp.class, args);
    }

}
