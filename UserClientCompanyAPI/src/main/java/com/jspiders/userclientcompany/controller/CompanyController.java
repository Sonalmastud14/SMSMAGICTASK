package com.jspiders.userclientcompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.jspiders.userclientcompany.pojo.Company;
import com.jspiders.userclientcompany.repository.CompanyRepository;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
    private CompanyRepository companyRepository;

	 @GetMapping("/companies")
	    public List<Company> listCompanies() {
	        return companyRepository.findAll();
	   }

    @PostMapping("/companies")
    public Company createCompany(@RequestBody Company newCompany) {
        return companyRepository.save(newCompany);
    }
}
