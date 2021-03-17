package io.andrea.gateway.route;

import io.andrea.gateway.UriConfiguration;
import io.andrea.gateway.common.DefaultRoute;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class Route2 extends DefaultRoute {

    private final UriConfiguration uriConfiguration;

    @Override
    public Function<PredicateSpec, Route.AsyncBuilder> route() {
        return p -> p
                .host("*.hystrix.com")
                .filters(f -> f
                        .hystrix(config -> config
                                .setName("mycmd")
                                .setFallbackUri("forward:/fallback")))
                .uri(uriConfiguration.getHttpbin());
    }

}
