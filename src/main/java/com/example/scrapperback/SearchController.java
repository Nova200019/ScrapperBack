package com.example.scrapperback;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @GetMapping("/")
    public String home() {
        return "index"; // Name of the HTML file in src/main/resources/templates
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        // Call service to process query and get results
        // model.addAttribute("results", results);
        return "searchResults"; // Update HTML template accordingly
    }
}