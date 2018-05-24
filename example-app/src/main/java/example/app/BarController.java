package example.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BarController {

    @GetMapping("/bar")
    public ResponseEntity<String> bar() {
        return ResponseEntity.ok("This is the bar endpoint");
    }

    @GetMapping("/bar1")
    public ResponseEntity<String> bar1() {
        return ResponseEntity.ok("This is the bar1 endpoint");
    }

    @GetMapping("/bar2")
    public ResponseEntity<String> bar2() {
        return ResponseEntity.ok("This is the bar2 endpoint");
    }
}
