package org.jude.demo.companycatalog.controller;

import org.jude.demo.companycatalog.model.Company;
import org.jude.demo.companycatalog.service.CompanyService;
import org.jude.demo.companycatalog.utils.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DecimalFormat;

@Controller
public class RegistrationController {

    public static final String UPLOAD_DIR = "uploaded_files/";

    private final CompanyService companyService;

    public RegistrationController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/register")
    public String getRegisterApplication() {
        return "register";
    }

    @PostMapping("/register")
    public String submitRegistrationApplication(@RequestParam("file") MultipartFile file,
                                                @RequestParam("companyName") String companyName,
                                                @RequestParam("domain") String domain,
                                                @RequestParam("year") int year,
                                                @RequestParam("location") String city) throws IOException {
        // save the uploaded file to local storage
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileUploadUtil.saveFile(UPLOAD_DIR, fileName, file);

        // save company details in database
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setDomain(domain);
        company.setFoundedYear(year);
        company.setLocation(city);

        DecimalFormat df = new DecimalFormat("#.##");
        double rating = Math.random() + 4;
        company.setRating(Double.parseDouble(df.format(rating)));

        String imgPath = UPLOAD_DIR + fileName;
        company.setImgLocation(imgPath);

        companyService.save(company);
        return "redirect:/";
    }
}
