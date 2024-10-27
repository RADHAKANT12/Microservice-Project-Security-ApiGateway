package com.example.Client_Service.Client_Service.controller;

import com.example.Client_Service.Client_Service.entity.Client;
import com.example.Client_Service.Client_Service.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // http://localhost:8080/api/clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    // http://localhost:8080/api/clients/1


    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }
    // http://localhost:8080/api/clients

    @PostMapping
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }
}
