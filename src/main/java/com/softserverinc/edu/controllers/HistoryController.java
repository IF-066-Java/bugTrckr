package com.softserverinc.edu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 37.0 on 05.08.2016.
 */
@Controller
//@RequestMapping(value = "/history", method = RequestMethod.GET)
public class HistoryController {

    public String worklogIndex() {
        return "history";
    }

}
