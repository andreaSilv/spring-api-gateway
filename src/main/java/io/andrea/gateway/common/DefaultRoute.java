package io.andrea.gateway.common;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

import java.util.function.Function;

public abstract class DefaultRoute {

    public abstract Function<PredicateSpec, Route.AsyncBuilder> route();
}
