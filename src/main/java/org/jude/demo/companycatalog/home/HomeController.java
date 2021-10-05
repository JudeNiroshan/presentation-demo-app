package org.jude.demo.companycatalog.home;

import org.jude.demo.companycatalog.model.Company;
import org.jude.demo.companycatalog.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CompanyService companyService;

    public HomeController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public String get(Model model) {
        List<Company> companyList = companyService.findAll();
        model.addAttribute("companyList", companyList);
        return "index";
    }
}
