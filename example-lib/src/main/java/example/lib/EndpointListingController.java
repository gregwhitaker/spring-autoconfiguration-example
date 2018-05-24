package example.lib;

import example.lib.annotation.ExcludeEndpointListing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Controller that lists all other endpoints in the application.
 */
@Controller
public class EndpointListingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EndpointListingController.class);

    private List<String> endpoints = new ArrayList<>();

    public EndpointListingController(BeanFactory beanFactory) {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(RestController.class));

        // Scan the classpath for @RestController annotated classes
        for (String basePackage : AutoConfigurationPackages.get(beanFactory)) {
            for (BeanDefinition beanDefinition : scanner.findCandidateComponents(basePackage)) {
                try {
                    Class<?> clazz = Class.forName(beanDefinition.getBeanClassName());

                    // If they are annotated with @ExcludeEndpointListing then they are skipped
                    if (!clazz.isAnnotationPresent(ExcludeEndpointListing.class)) {

                        // Find every path mapped with a @GetMapping annotation
                        for (Method method : clazz.getDeclaredMethods()) {
                            if (method.isAnnotationPresent(GetMapping.class)) {
                                GetMapping annotation = method.getAnnotation(GetMapping.class);
                                endpoints.addAll(Arrays.asList(annotation.value()));
                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    LOGGER.error("Error during bean scanning", e);
                }
            }
        }
    }

    @GetMapping("/endpoints")
    public ResponseEntity endpoints() {
        return ResponseEntity.ok(endpoints);
    }
}
