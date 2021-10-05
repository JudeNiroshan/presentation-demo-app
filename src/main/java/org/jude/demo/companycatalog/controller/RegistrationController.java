package org.jude.demo.companycatalog.controller;

import org.jude.demo.companycatalog.utils.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class RegistrationController {

    public static final String UPLOAD_DIR = "uploaded_files/";

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


        return "index";
    }
}
