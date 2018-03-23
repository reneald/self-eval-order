package be.reneald.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CrossOriginResourceSharingConfig {

    private static final String ALLOWED_ORIGINS = "*";
    private static final String ALLOWED_PATH_MAPPINGS = "/**";

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(ALLOWED_PATH_MAPPINGS)
                        .allowedOrigins(ALLOWED_ORIGINS)
                        .allowedMethods("*");
            }
        };
    }

}
