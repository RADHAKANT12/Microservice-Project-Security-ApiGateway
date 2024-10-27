package com.example.Client_Service.Client_Service.service;

import com.example.Client_Service.Client_Service.entity.Client;
import com.example.Client_Service.Client_Service.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}