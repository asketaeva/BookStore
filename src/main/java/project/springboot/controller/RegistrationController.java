package project.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.springboot.dto.UserRegistration;
import project.springboot.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistration userRegistration(){
        return new UserRegistration();
    }
    @PostMapping
    public String registerUser(@ModelAttribute("user")UserRegistration registration){
        userService.save(registration);
        return "redirect:/registration?success";
    }

    @GetMapping
    public String registrationForm(Model model){
        return "registration";
    }
}
