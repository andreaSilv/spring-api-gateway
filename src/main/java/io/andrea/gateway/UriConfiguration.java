package io.andrea.gateway;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Getter
public class UriConfiguration {

    @Value("${app.mainUrlRoute}")
    private String httpbin = "http://httpbin.org:80";

}