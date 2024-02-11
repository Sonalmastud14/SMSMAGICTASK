package com.jspiders.userclientcompany.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.userclientcompany.pojo.Company;
import com.jspiders.userclientcompany.repository.ClientRepository;
import com.jspiders.userclientcompany.repository.CompanyRepository;

import ch.qos.logback.core.net.server.Client;
import lombok.Data;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CompanyRepository companyRepository;

    
    @PostMapping("/clients")
    public Client createClient(@RequestBody Client newClient) {
      
        if (companyRepository.existsById(newClient.getCompany.getId())) {
            throw new RuntimeException("Company is already assigned to another client");
        }
        return clientRepository.save(newClient);
    }

    
    @PatchMapping("/clients/{clientId}")
    public Client updateClient(@PathVariable Long clientId, @RequestBody Client updatedClient) {
        updatedClient.setId(clientId);
        return clientRepository.save(updatedClient);
    }
