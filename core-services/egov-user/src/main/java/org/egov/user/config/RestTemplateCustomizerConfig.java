// File: src/main/java/org/egov/user/config/RestTemplateCustomizerConfig.java
package org.egov.user.config;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateCustomizerConfig {

    @Bean
    public RestTemplateCustomizer authHeaderRestTemplateCustomizer() {
        return restTemplate -> restTemplate.getInterceptors().add(new AuthTokenInterceptor());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(); // Will have interceptor applied by the above customizer
    }
}
