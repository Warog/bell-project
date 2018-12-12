package ru.bellintegrator.training.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.training.service.ClientService;
import ru.bellintegrator.training.view.ClientView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "ClientController", description = "Работа над клиентами")
@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class ClientController {

        private final ClientService clientService;

        @Autowired
        public ClientController(ClientService clientService) {
            this.clientService = clientService;
        }

        @ApiOperation(value = "Добавить клиента", httpMethod = "POST")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Success", response = String.class),
                @ApiResponse(code = 404, message = "Not Found"),
                @ApiResponse(code = 500, message = "Failure")})
        @PostMapping("/client")
        public void client(@RequestBody ClientView client) {
            clientService.add(client);
        }

        @ApiOperation(value = "Список клиентов", httpMethod = "GET")
        @GetMapping("/client")
        public List<ClientView> clients() {
            return clientService.clients();
        }

}
