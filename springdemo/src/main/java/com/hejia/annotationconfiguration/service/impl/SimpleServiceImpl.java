package com.hejia.annotationconfiguration.service.impl;

import com.hejia.annotationconfiguration.repository.SimpleRepository;
import com.hejia.annotationconfiguration.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleServiceImpl implements SimpleService {
    @Autowired
    private SimpleRepository simpleRepository;

    public SimpleServiceImpl() {
    }

    public SimpleServiceImpl(SimpleRepository simpleRepository) {
        this.simpleRepository = simpleRepository;
    }

    public SimpleRepository getSimpleRepository() {
        return simpleRepository;
    }

    public void setSimpleRepository(SimpleRepository simpleRepository) {
        this.simpleRepository = simpleRepository;
    }
}
