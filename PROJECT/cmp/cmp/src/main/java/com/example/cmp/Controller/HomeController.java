package com.example.cmp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index"; // Thymeleaf template name
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return "about";

    }

    @GetMapping("/team")
    public String showTeamPage() {
        return "team"; // This will resolve to src/main/resources/templates/team.html
    }

    @GetMapping("/blog")
    public String showBlogPage() {
        return "blog"; // Looks for src/main/resources/templates/blog.html
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "contact"; // This maps to src/main/resources/templates/contact.html

    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Loads templates/login.html
    }

    @GetMapping("/admin/dashboard")
    public String showDashboard() {
        return "dashboard"; // Maps to src/main/resources/templates/dashboard.html
    }

}