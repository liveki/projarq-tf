package com.bcopstein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
  @Bean
  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    System.out.println("passei pelo gateway");
    return builder.routes().route(p -> p.path("/vendas/*").uri("http://servVenda:8080")).build();
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
