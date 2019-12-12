package com.example.demo;

import com.example.demo.model.Customer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.regex.Pattern;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.45.12:9092");
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

		StreamsBuilder builder = new StreamsBuilder();

		KStream<String, Customer> source = builder.stream("student");

//		KStream<String,List<String>> counts  = source.flatMapValues(values->Arrays.asList(values.toString())).transform();


		KafkaStreams streams = new KafkaStreams(builder.build(),props);

		streams.start();



	}


}
