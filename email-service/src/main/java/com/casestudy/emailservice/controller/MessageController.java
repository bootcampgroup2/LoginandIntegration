package com.casestudy.emailservice.controller;

import com.casestudy.emailservice.kafka.MessageService;
import com.casestudy.emailservice.models.Ordermail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    public static final Logger LOGGER=LoggerFactory.getLogger(MessageController.class);
    @GetMapping("/{email}")
    public List<Ordermail> getUnreadMessages(@PathVariable String email) {
    	LOGGER.info("Order place......notification is been sent to user"+email);
        return messageService.getUnreadMessagesByEmail(email);
    }
    
    @PatchMapping("/update")
  		public ResponseEntity<?>updateStatus(@RequestBody Ordermail ordermail)
  		{
  			messageService.updatemessage(ordermail);
  			LOGGER.info("The user has viewed the notification(seen)");
  			return new ResponseEntity("Message updated successfully",HttpStatus.ACCEPTED);
  		
  		}
}
