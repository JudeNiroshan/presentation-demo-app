package org.jude.demo.companycatalog.service;

import org.jude.demo.companycatalog.model.Company;
import org.jude.demo.companycatalog.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company save(Company newCompany) {
        return this.companyRepository.save(newCompany);
    }

    public List<Company> save(List<Company> companies) {
        return companies.stream().map(this::save).collect(Collectors.toList());
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }
}
