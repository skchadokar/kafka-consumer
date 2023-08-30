package com.example.kafkaconsumer.controllers;

import com.example.kafkaconsumer.listeners.Msg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerCpntroller {

  @PostMapping("/rest/msg")
  public Msg getRestMsg(@RequestBody final Msg msg) {

    System.out.println("Rest call received age :"+ msg.getAge());
    System.out.println("Rest call received name :"+ msg.getName());
    Msg temp = new Msg();
    temp.setName(msg.getName());
    temp.setAge("37Y");
    return temp;
  }

}
