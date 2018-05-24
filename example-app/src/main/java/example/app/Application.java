package example.app;

import example.lib.annotation.EnableEndpointListing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEndpointListing
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
