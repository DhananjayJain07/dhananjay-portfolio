package com.dhananjay.cloudlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@SpringBootApplication
public class CloudLabApplication {
    public static void main(String[] args) { SpringApplication.run(CloudLabApplication.class, args); }

    @RestController
    static class InfoController {
        @GetMapping("/") Map<String, String> home() {
            return Map.of("service", "cloud-native-deployment-lab", "status", "running");
        }
    }
}