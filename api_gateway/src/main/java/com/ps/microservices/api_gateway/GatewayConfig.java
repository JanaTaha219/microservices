package com.ps.microservices.api_gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class GatewayConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;


    @Bean
    @LoadBalanced
    public WebClient loadBalancedEmployeeWebClient() {
        return WebClient.builder()
                .baseUrl("http://employee-service")
                .filter(filterFunction)
                .build();
    }


    @Bean
    public WebClient loadBalancedDepartmentWebClient() {

        return WebClient.builder()
                .baseUrl("http://department-service")
                .filter(filterFunction)
                .build();
    }
}