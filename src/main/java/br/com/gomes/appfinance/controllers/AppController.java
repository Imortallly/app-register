package br.com.gomes.appfinance.controllers;


import br.com.gomes.appfinance.models.Users;

import br.com.gomes.appfinance.repository.AppRepository;
import br.com.gomes.appfinance.services.ValidationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class AppController {
    @Autowired
    private AppRepository repository;

    @Autowired
    private ValidationService validate;

    @GetMapping("/index")
    public String view() {
        return "index";
    }

    @GetMapping("/welcome")
    public String list() {
        return "list";
    }

    @PostMapping("/index")
    public String saveUserAndReturnView(@Valid Users users, Model model) {
        String returnService;
        boolean passwordValid = validate.validationPassword(users.getPassword(), model);
        boolean emailValidate = validate.validationEmailDuplicate(users.getEmail(), model);
        if(emailValidate) { } else {
            return validate.errorRegisterEmail(model);
        }
        if (passwordValid) {
            users.setDate(new Date());
            repository.save(users);
            returnService = "redirect:/welcome";
        } else {
            return validate.errorRegisterPassword(model);
        }
        return returnService;
    }
}
