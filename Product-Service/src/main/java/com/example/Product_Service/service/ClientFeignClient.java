package com.example.Product_Service.service;

import com.example.Product_Service.payload.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service", url = "http://localhost:8080/api/clients") // Client Service URL
public interface ClientFeignClient {

    @GetMapping("/{id}")
    ClientDto getClientById(@PathVariable Long id);
}
