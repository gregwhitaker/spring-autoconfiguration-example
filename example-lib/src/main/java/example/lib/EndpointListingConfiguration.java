package example.lib;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration loaded by the @EnableEndpointListing annotation.
 */
@Configuration
public class EndpointListingConfiguration {

    @Bean
    @Autowired
    public EndpointListingController endpointListingController(BeanFactory beanFactory) {
        return new EndpointListingController(beanFactory);
    }
}
