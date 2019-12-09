package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class ProducerConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public KafkaTemplate<String, String> stringProducer() {
        ProducerFactory producerFactory = new DefaultKafkaProducerFactory(kafkaProperties.buildProducerProperties());
        KafkaTemplate kafkaTemplate = new KafkaTemplate(producerFactory);
        kafkaTemplate.setDefaultTopic("student");
        return kafkaTemplate;
    }


}
