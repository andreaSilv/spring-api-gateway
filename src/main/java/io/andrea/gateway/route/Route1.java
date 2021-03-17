package io.andrea.gateway.route;

import io.andrea.gateway.UriConfiguration;
import io.andrea.gateway.common.DefaultRoute;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class Route1 extends DefaultRoute {

    private final UriConfiguration uriConfiguration;

    @Override
    public Function<PredicateSpec, Route.AsyncBuilder> route() {
        return p -> p
				.path("/get")
				.filters(f -> f.addRequestHeader("Hello", "World"))
				.uri(uriConfiguration.getHttpbin());
    }
}
