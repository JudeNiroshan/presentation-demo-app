package org.jude.demo.companycatalog.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping("/")
    public String get(Model model) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("TBD");
        model.addAttribute("companyList", strings);

        return "index";
    }

    @GetMapping("/register")
    public String getRegisterApplication() {
        return "register";
    }


}
