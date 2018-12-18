package ru.bellintegrator.training.client.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.training.model.Client;
import ru.bellintegrator.training.view.ClientView;

import java.net.URI;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
public class ClientTest {
    @LocalServerPort
    int serverPort = 8888;

    @Test
    public void test() throws Exception {

//        Client client = new Client("Иван", "Иванов", "Иванович", "Охранник", "234567", Long.valueOf(1), Long.valueOf(1), Long.valueOf(1), true);

        RestTemplate restTemplate = new RestTemplate();


            final String baseUrl = "http://localhost:" + serverPort + "/client";
            URI uri = new URI(baseUrl);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity entity = new HttpEntity(headers);

            ResponseEntity<ClientView> result = restTemplate.exchange(uri, HttpMethod.GET, entity, ClientView.class);
            ClientView view = result.getBody();

            System.out.println(view.citizenship_id);

    }
}
