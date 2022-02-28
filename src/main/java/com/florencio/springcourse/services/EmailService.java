package com.florencio.springcourse.services;

import org.springframework.mail.SimpleMailMessage;

import com.florencio.springcourse.domain.Cliente;
import com.florencio.springcourse.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);

}
