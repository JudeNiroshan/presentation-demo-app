package org.jude.demo.companycatalog.controller;

import org.jude.demo.companycatalog.model.Company;
import org.jude.demo.companycatalog.service.CompanyService;
import org.jude.demo.companycatalog.service.DummyDataGenerateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CompanyService companyService;

    private final DummyDataGenerateService dummyDataGenerateService;

    public HomeController(CompanyService companyService, DummyDataGenerateService dummyDataGenerateService) {
        this.companyService = companyService;
        this.dummyDataGenerateService = dummyDataGenerateService;
    }

    @GetMapping("/")
    public String get(Model model) {
        List<Company> companyList = companyService.findAll();
        model.addAttribute("companyList", companyList);
        return "index";
    }

    @GetMapping("/generate-data")
    public String generateData() {

        dummyDataGenerateService.loadDataFromExternalSystems();
        return "redirect:/";
    }

    @GetMapping("/health")
    public String status() {
        return "ok";
    }
}
