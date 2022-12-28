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
    @Value("${org.quantil.gateway.objective-evaluation-service.uri}")
    private String objectiveEvaluationServiceUri;
    @Value("${org.quantil.gateway.quantum-circuit-generation.uri}")
    private String quantumCircuitGenerationUri;
    @Value("${org.quantil.gateway.optimization-service.uri}")
    private String optimizationServiceUri;
    @Value("${org.quantil.gateway.circuit-execution-service.uri}")
    private String circuitExecutionUri;
    @Value("${org.quantil.gateway.circuit-cutting-service.uri}")
    private String circuitCuttingUri;
    @Value("${org.quantil.gateway.warm-starting-service.uri}")
    private String warmStartingUri;

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
            .route("objective-evaluation", route -> route
                .path(CONTEXT_PATH + "/objective-evaluation/**")
                .and()
                .method(HttpMethod.POST)
                .filters(f->f.rewritePath("/quokka/objective-evaluation/(?<segment>.*)","/${segment}"))
                .uri(objectiveEvaluationServiceUri))
            .route("circuit-generation", route -> route
                .path(CONTEXT_PATH + "/circuit-generation/**")
                .and()
                .method(HttpMethod.POST)
                .filters(f->f.rewritePath("/quokka/circuit-generation/(?<segment>.*)","/${segment}"))
                .uri(quantumCircuitGenerationUri))
            .route("optimization", route -> route
                .path(CONTEXT_PATH + "/optimization/**")
                .and()
                .method(HttpMethod.POST)
                .filters(f->f.rewritePath("/quokka/optimization/(?<segment>.*)","/${segment}"))
                .uri(optimizationServiceUri))
            .route("circuit-execution", route -> route
                .path(CONTEXT_PATH + "/circuit-execution/**")
                .and()
                .method(HttpMethod.POST)
                .filters(f->f.rewritePath("/quokka/circuit-execution/(?<segment>.*)","/${segment}"))
                .uri(circuitExecutionUri))
            .route("circuit-cutting", route -> route
                .path(CONTEXT_PATH + "/circuit-cutting/**")
                .and()
                .method(HttpMethod.POST)
                .filters(f->f.rewritePath("/quokka/circuit-cutting/(?<segment>.*)","/${segment}"))
                .uri(circuitCuttingUri))
            .route("warm-starting", route -> route
                .path(CONTEXT_PATH + "/warm-starting/**")
                .and()
                .method(HttpMethod.POST)
                .filters(f->f.rewritePath("/quokka/warm-starting/(?<segment>.*)","/${segment}"))
                .uri(warmStartingUri))
            .build();
    }
}
