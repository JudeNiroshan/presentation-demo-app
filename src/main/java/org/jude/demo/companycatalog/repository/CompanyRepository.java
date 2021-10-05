package org.jude.demo.companycatalog.repository;

import org.jude.demo.companycatalog.model.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Override
    List<Company> findAll();
}
