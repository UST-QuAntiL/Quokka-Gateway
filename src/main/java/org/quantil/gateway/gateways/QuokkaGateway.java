package org.quantil.gateway.gateways;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

public class QuokkaGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuokkaGateway.class);

    private static final String CONTEXT_PATH = "/quokka";


    @Value("${org.quantil.gateway.error-mitigation-service.uri}")
    private String errorMitigationServiceUri;
    @Value("${org.quantil.gateway.objective-function-service.uri}")
    private String objectiveFunctionServiceUri;
    @Value("${org.quantil.gateway.quantum-circuit-generator.uri}")
    private String quantumCircuitGeneratorUri;
    @Value("${org.quantil.gateway.optimization-service.uri}")
    private String optimizationServiceUri;
    @Value("${org.quantil.gateway.circuit-execution-service.uri}")
    private String circuitExecutionUri;

    @Value("${server.port}")
    private String gatewayUri;

    @Bean
    public RouteLocator quokkaLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("error-mitigation", route -> route
                .path(CONTEXT_PATH + "/error-mitigation/**")
                .and()
                .method(HttpMethod.POST)
                .filters(f->f.rewritePath("/quokka/error-mitigation/(?<segment>.*)","/${segment}"))
                .uri(errorMitigationServiceUri)
            )
            .route("objective-function", route -> route
                .path(CONTEXT_PATH + "/objective-function")
                .and()
                .method(HttpMethod.POST)
                .filters(f->f.rewritePath("/quokka/objective-function/(?<segment>.*)","/${segment}"))
                .uri(objectiveFunctionServiceUri))
            .route("circuit-generator", route -> route
                .path(CONTEXT_PATH + "/circuit-generator")
                .and()
                .method(HttpMethod.POST)
                .filters(f->f.rewritePath("/quokka/circuit-generator/(?<segment>.*)","/${segment}"))
                .uri(quantumCircuitGeneratorUri))
            .route("optimization", route -> route
                .path(CONTEXT_PATH + "/optimization")
                .and()
                .method(HttpMethod.POST)
                .filters(f->f.rewritePath("/quokka/optimization/(?<segment>.*)","/${segment}"))
                .uri(optimizationServiceUri))
            .route("circuit-execution", route -> route
                .path(CONTEXT_PATH + "/circuit-execution")
                .and()
                .method(HttpMethod.POST)
                .filters(f->f.rewritePath("/quokka/circuit-execution/(?<segment>.*)","/${segment}"))
                .uri(circuitExecutionUri)
            )
            .build();
    }
}
