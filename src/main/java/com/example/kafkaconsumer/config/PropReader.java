package com.example.kafkaconsumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("file:/etc/secrets/application.properties")
@Component
@ConfigurationProperties("kafka")
public class PropReader {

  private String bus;
  private String groupId;
  private String topic;

  public String getBus() {
    return bus;
  }

  public void setBus(String bus) {
    this.bus = bus;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }
}
