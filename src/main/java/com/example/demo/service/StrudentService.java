package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


import java.util.List;

@Service
public class StrudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    private List<Account> studentInfo() {
        return studentRepo.findAll();
    }

    public boolean produceMessages() {
        studentRepo.findAll().stream().forEach(account -> produceMessage(account.getId() + "", account.toString()));
        studentRepo.findAll().stream().forEach(account -> msgWithPartition(account.getId() + "", account.toString()));
        return true;
    }

    public void produceMessage(String msg) {
        kafkaTemplate.send("student","normal send");
        kafkaTemplate.send("student",1,"1","normal send");
        kafkaTemplate.sendDefault(msg);
    }

    public void produceMessage(String key, String msg) {
        kafkaTemplate.sendDefault(key, msg);
    }

    public void msgWithPartition(String key, String msg) {
        kafkaTemplate.sendDefault(0,key, msg);
        kafkaTemplate.sendDefault(1,key, msg);
    }

    public void sendMessage(String message) {

        ListenableFuture<SendResult<String,String>> future =
                kafkaTemplate.send("student",1,"1", message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
