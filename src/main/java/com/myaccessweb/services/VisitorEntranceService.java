package com.myaccessweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccessweb.repositories.VisitorEntranceRepository;

@Service
public class VisitorEntranceService {

    @Autowired
    private VisitorEntranceRepository visitorEntranceRepository;

}
