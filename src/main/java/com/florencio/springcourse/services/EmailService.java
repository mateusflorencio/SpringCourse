package com.florencio.springcourse.services;

import org.springframework.mail.SimpleMailMessage;

import com.florencio.springcourse.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
