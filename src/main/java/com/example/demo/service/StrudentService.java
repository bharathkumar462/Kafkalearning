package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StrudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    KafkaTemplate<String, Customer> kafkaTemplate;



    public void produceMessage(String key, Customer msg) {
        kafkaTemplate.sendDefault(key, msg);

    }

}


