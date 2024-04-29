package com.feignforsongify;

import feign.Client;
import feign.Feign;
import feign.httpclient.ApacheHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public Client feignClient() {
        return new ApacheHttpClient();
    }

    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder()
                    .client(feignClient());
    }
}
