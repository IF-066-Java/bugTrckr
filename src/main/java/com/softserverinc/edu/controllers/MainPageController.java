package com.softserverinc.edu.controllers;

import com.softserverinc.edu.form.LoginForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * Created by volodymyr on 7/30/16.
 */
@Controller
@SessionAttributes("loginForm")
public class MainPageController {

    public  static final Logger LOGGER = LoggerFactory.getLogger(MainPageController.class);


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginPost(@Valid @ModelAttribute("loginForm") LoginForm loginForm,
                            BindingResult result, Model model) {


        if (result.hasErrors()) {
            return "index";
        }

        model.addAttribute("loginForm", loginForm);
        LOGGER.debug("Login email: " + loginForm.getEmail());
        LOGGER.debug("Login password: " + loginForm.getPassword());
        return "index";

    }

    @RequestMapping(value = "/", params = "logout", method = RequestMethod.GET)
    public String logout(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "index";
    }

    @RequestMapping(value = "/", params = "logout", method = RequestMethod.POST)
    public String processLogout(@ModelAttribute("loginForm") LoginForm loginForm,
                                Model model, SessionStatus status) {

        model.addAttribute("loginForm", loginForm);
        LOGGER.debug("Logout email: " + loginForm.getEmail());
        LOGGER.debug("Logout password: " + loginForm.getPassword());

        loginForm.setPassword("");
        loginForm.setEmail("");

        //Mark Session Complete
        //flush out the session data
        status.setComplete();

        return "index";
    }

}