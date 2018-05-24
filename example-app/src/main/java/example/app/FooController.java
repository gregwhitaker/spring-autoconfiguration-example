package example.app;

import example.lib.annotation.ExcludeEndpointListing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExcludeEndpointListing
public class FooController {

    @GetMapping("/foo")
    public ResponseEntity<String> foo() {
        return ResponseEntity.ok("This is the foo endpoint");
    }
}
