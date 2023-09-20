package com.casestudy.emailservice;

import com.casestudy.emailservice.kafka.OrderConsumer;


import com.casestudy.emailservice.models.Ordermail;
import com.casestudy.emailservice.repositories.OrdermailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class EmailServiceApplication implements CommandLineRunner {

	@Autowired
	private OrderConsumer orderConsumer;

	public EmailServiceApplication(OrderConsumer orderConsumer, OrdermailRepository ordermailRepository) {
		this.orderConsumer = orderConsumer;
		this.ordermailRepository = ordermailRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

	private final OrdermailRepository ordermailRepository;

	@Autowired
	public EmailServiceApplication(OrdermailRepository ordermailRepository ){
		this.ordermailRepository = ordermailRepository;
	}
	@Override
	public void run(String... args) throws Exception {
//		if (ordermailRepository.findAll().isEmpty()){
//			ordermailRepository.save(new Ordermail("shivanipatil270@gmail.com","Order Placed Successfully",false));
//		}
//
//		for (Ordermail ordermail: ordermailRepository.findAll()){
//			System.out.println(ordermail);
//		}

	}

	

	}



