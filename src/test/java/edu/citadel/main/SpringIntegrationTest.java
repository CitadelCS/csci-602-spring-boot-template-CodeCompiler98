package edu.citadel.main;

import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest
public class SpringIntegrationTest {
    // executeGet implementation
    @LocalServerPort
    protected int port;

    protected TestRestTemplate restTemplate = new TestRestTemplate();
    protected ResponseEntity<String> latestResponse;

    protected void executeGet(String url) {
        latestResponse = restTemplate.getForEntity(url, String.class);
    }
    protected String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}