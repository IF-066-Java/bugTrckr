package com.softserverinc.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by volodymyr on 7/30/16.
 */
@Controller
public class RootController {

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }

}