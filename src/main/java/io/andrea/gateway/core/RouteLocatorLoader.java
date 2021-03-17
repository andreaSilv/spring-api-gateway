package io.andrea.gateway.core;

import io.andrea.gateway.common.DefaultRoute;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RouteLocatorLoader {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder, ApplicationContext context) {
        Map<String, DefaultRoute> defaultRouteBeans = context.getBeansOfType(DefaultRoute.class);

        RouteLocatorBuilder.Builder builder =  routeLocatorBuilder.routes();
        for(DefaultRoute defaultRoute : defaultRouteBeans.values()){
            builder.route(defaultRoute.route());
        }
        return builder.build();
    }
}
