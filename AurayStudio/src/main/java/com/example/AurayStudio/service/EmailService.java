package com.example.AurayStudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.EmailDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

//@RequiredArgsConstructor
@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	private final String FROM_MAIL_GOOGLE = "wonyuchung@gmail.com";

	public boolean sendMailReject(EmailDto mail) {
		boolean msg = true;
		
		MimeMessage message = javaMailSender.createMimeMessage();
		 
		try {
	            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
	            helper.setTo(mail.getTo());
	            helper.setSubject(mail.getSubject());
	            helper.setFrom(FROM_MAIL_GOOGLE);
	            helper.setText(mail.getText(), true);

	            javaMailSender.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            msg = false;
	        }
	        return msg;
		}

	}

