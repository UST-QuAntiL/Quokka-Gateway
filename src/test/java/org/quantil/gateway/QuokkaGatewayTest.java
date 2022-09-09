package org.quantil.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {
        "org.quantil.gateway.quokka.uri=http://localhost:${wiremock.server.port}",
    }
)
@AutoConfigureWireMock(port = 0)
class QuokkaGatewayTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testGateway() {
        webClient.get()
            .uri("/")
            .exchange()
            .expectStatus().isOk();
    }

}
