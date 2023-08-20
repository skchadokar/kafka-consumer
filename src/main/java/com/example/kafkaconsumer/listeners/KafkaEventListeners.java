package com.example.kafkaconsumer.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.CountDownLatch;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventListeners {

  // KafkaListener start
  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(topics = "sayHi")
  public void userKafkaReceiverMsg(String payload) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    Msg kafkaRecevied = objectMapper.readValue(payload, Msg.class);
    System.out.println("MSG: Name :: = " + kafkaRecevied.getName());
    System.out.println("MSG: Age :: =" + kafkaRecevied.getAge());
    latch.countDown();
  }
}
