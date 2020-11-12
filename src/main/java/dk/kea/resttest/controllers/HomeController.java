package dk.kea.resttest.controllers;

import dk.kea.resttest.service.RestConsumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private RestConsumeService restConsumeService;

    public HomeController(RestConsumeService restConsumeService) {
        this.restConsumeService = restConsumeService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("quote", restConsumeService.fetchSingleQuote());
        model.addAttribute("quotearray", restConsumeService.fetchAllQuotes());
        return "index";
    }
}
