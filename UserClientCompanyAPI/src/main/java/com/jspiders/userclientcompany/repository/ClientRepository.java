package com.jspiders.userclientcompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.userclientcompany.pojo.Company;

import ch.qos.logback.core.net.server.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    boolean existsByCompany(Company company);
}

