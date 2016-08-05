package com.softserverinc.edu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 37.0 on 04.08.2016.
 */
@Controller
@RequestMapping(value = "/label")
public class LabelController {

    public String worklogIndex() {
        return "label";
    }

}
