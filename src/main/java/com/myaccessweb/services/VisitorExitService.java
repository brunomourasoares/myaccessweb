package com.myaccessweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccessweb.repositories.VisitorExitRepository;

@Service
public class VisitorExitService {

    @Autowired
    private VisitorExitRepository visitorExitRepository;

}
