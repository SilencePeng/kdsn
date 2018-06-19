package com.usping.kdsn.message.controller;

import com.usping.kdsn.bean.Message;
import com.usping.kdsn.message.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    private final static Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    private final MessageService messageService;

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    public GreetingController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/sendMessage")
    public void sendMessage (Message message) {
        logger.info("接收到了信息" + message.getSenderUsername());
        try {
            messageService.saveInstance(message);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("保存信息失败，原因为： " + e.getMessage());
        }
//        String destUser = message.getReceiverUsername();
        messagingTemplate.convertAndSend("/queue/chat",message);
    }
}

