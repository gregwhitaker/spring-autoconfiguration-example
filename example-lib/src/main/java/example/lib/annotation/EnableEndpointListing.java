package example.lib.annotation;

import example.lib.EndpointListingConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Enables the endpoint listing endpoint.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(EndpointListingConfiguration.class)
public @interface EnableEndpointListing {

}
