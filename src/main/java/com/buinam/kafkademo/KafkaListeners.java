package com.buinam.kafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "${spring.kafka.consumer.topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    void listen(@Payload String message,
                @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts
    ) {
        System.out.println("Received Message: " + message + " - with key: " + key + " - from partition: " + partition + " - from topic: " + topic + " - at: " + ts);
    }
}