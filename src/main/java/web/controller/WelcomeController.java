package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {

    @GetMapping(value = "/")
    public String greeting(ModelMap modelMap) {
        List<String> strings = new ArrayList<>();
        strings.add("Hi! You're on startup page.");
        modelMap.addAttribute("strings", strings);
        return "index";
    }

}
