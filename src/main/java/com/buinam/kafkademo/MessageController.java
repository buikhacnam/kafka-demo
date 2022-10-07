package com.buinam.kafkademo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class MessageController {

    @Value("${spring.kafka.consumer.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public void sendMessage(@RequestBody Message request) {
        System.out.println("Sending message: " + request.getMessage() + " with key: " + request.getKey());

        kafkaTemplate.send(topicName, request.getKey(), request.getMessage());

    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Message {
    private String message;
    private String key;
}
