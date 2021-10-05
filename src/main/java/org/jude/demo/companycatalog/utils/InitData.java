package org.jude.demo.companycatalog.utils;

import org.jude.demo.companycatalog.model.Company;
import org.jude.demo.companycatalog.service.CompanyService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitData {

    private final CompanyService companyService;

    public InitData(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostConstruct
    private void loadDataFromExternalSystems(){
        List<Company> companies = dummyCompanyList();
        List<Company> saved = companyService.save(companies);
        System.out.println("New additions===" + saved.size());
    }

    private List<Company> dummyCompanyList(){
        ArrayList<Company> companies = new ArrayList<>();
        companies.add(buildCompany("Google Inc.", "Software Services", 1992, "Mount View", 4.33, "/uploaded_files/BigG.png"));
        companies.add(buildCompany("Facebook", "Software Services", 2006, "Los Angeles", 4.12, "/uploaded_files/fb.svg"));

        return companies;
    }

    private Company buildCompany(String name, String domain, int year, String location, double rating, String imgLocation){
        Company company = new Company();
        company.setCompanyName(name);
        company.setDomain(domain);
        company.setFoundedYear(year);
        company.setRating(rating);
        company.setLocation(location);
        company.setImgLocation(imgLocation);

        return company;
    }
}
