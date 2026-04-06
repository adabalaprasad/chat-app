package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController 
{

	 @Autowired
	 private SimpMessagingTemplate messagingTemplate;

	 @MessageMapping("/send")
	 @SendTo("/topic/messages")
	 public ChatMessage send(ChatMessage message) 
	 {

	        System.out.println("Client sent: " + message.getSender() + " -> " + message.getContent());

	        return message;
	    }
}