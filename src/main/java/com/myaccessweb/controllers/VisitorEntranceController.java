package com.myaccessweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myaccessweb.services.VisitorEntranceService;

@RestController
@RequestMapping(value = "/entrances")
public class VisitorEntranceController {
    
    @Autowired
    private VisitorEntranceService visitorEntranceService;
}
