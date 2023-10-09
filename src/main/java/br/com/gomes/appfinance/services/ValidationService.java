package br.com.gomes.appfinance.services;

import br.com.gomes.appfinance.models.Users;
import br.com.gomes.appfinance.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class ValidationService {
    @Autowired
    private AppRepository repository;

    public boolean validationPassword(String password, Model model) {
        boolean validate = false;
        if (password.length() > 6) {
            boolean hasUpperCase = false;
            boolean hasDigit = false;
            boolean hasSpecialDigit = false;
            for (int i = 0; i < password.length(); i++) {
                char passwordText = password.charAt(i);
                if (Character.isUpperCase(passwordText)) {
                    hasUpperCase = true;
                } else if (Character.isDigit(passwordText)) {
                    hasDigit = true;
                } else if (passwordText == '!' || passwordText == '@' || passwordText == '$' || passwordText == '%') {
                    hasSpecialDigit = true;
                }
                validate = hasUpperCase && hasDigit && hasSpecialDigit;
            }
        }
        return validate;
    }

    public String errorRegisterPassword(Model model) {
        cleanObjUser();
        model.addAttribute("errorMessagePassword", true);
        return "/index";
    }

    public String errorRegisterEmail(Model model) {
        cleanObjUser();
        model.addAttribute("errorMessageEmail", true);
        return "/index";
    }
    public boolean validationEmailDuplicate(String email, Model model) {
        boolean validate = false;
        try {
            Users existingUser = repository.findByEmail(email);
            validate = false;
            if (existingUser != null) {
                errorRegisterEmail(model);
            } else {
                validate = true;
            }
        } catch (IncorrectResultSizeDataAccessException e) {
            errorRegisterEmail(model);
        }
        return validate;
    }

    public void cleanObjUser() {
        Users user = new Users();
        user.setEmail("");
        user.setPassword("");
        user.setAddress_1("");
        user.setAddress_2("");
        user.setCity("");
        user.setState("");
        user.setZip("");
    }
}

