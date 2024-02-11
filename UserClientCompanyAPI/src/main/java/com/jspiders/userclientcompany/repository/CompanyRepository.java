package com.jspiders.userclientcompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.userclientcompany.pojo.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
