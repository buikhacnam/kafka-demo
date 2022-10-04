package com.buinam.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic topic1() {
        return new NewTopic("topiccccccccccccccccccc1", 1, (short) 1);
    }
}
