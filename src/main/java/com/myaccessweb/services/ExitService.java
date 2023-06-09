package com.myaccessweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccessweb.repositories.ExitRepository;

@Service
public class ExitService {

    @Autowired
    private ExitRepository exitRepository;

}
