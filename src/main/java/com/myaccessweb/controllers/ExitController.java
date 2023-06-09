package com.myaccessweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myaccessweb.services.ExitService;

@RestController
@RequestMapping(value = "/exits")
public class ExitController {
    
    @Autowired
    private ExitService exitService;
}
