package com.example.AurayStudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.EmailDto;

//@RequiredArgsConstructor
@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	private final String FROM_MAIL_GOOGLE = "wonyuchung@gmail.com";

	/*
	 * public boolean sendMailReject(EmailDto mail) { boolean msg = true;
	 * 
	 * MimeMessage message = javaMailSender.createMimeMessage();
	 * 
	 * try { MimeMessageHelper helper = new MimeMessageHelper(message, true,
	 * "UTF-8"); helper.setTo(mail.getTo()); helper.setSubject(mail.getSubject());
	 * helper.setFrom(FROM_MAIL_GOOGLE); helper.setText(mail.getText(), true);
	 * 
	 * javaMailSender.send(message); } catch (MessagingException e) {
	 * e.printStackTrace(); msg = false; } return msg; }
	 */
	public boolean mailSend(EmailDto mailDto) {
		try {
			// Null 검증
			if (mailDto.getTo() == null || mailDto.getTo().isEmpty()) {
				throw new IllegalArgumentException("수신자 이메일 주소가 필요합니다.");
			}
			if (mailDto.getSubject() == null || mailDto.getSubject().isEmpty()) {
				throw new IllegalArgumentException("이메일 제목이 필요합니다.");
			}
			if (mailDto.getText() == null || mailDto.getText().isEmpty()) {
				throw new IllegalArgumentException("이메일 본문이 필요합니다.");
			}

			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(mailDto.getTo());
			message.setFrom(FROM_MAIL_GOOGLE); // 발신자는 고정된 이메일을 사용
			message.setSubject(mailDto.getSubject());
			message.setText(mailDto.getText());

			javaMailSender.send(message); // 이메일 전송
			return true; // 전송 성공 시 true 반환
		} catch (IllegalArgumentException e) {
			System.err.println("메일 전송 실패: " + e.getMessage());
			return false;
		} catch (Exception e) {
			System.err.println("메일 전송 중 오류 발생: " + e.getMessage());
			return false; // 전송 실패 시 false 반환
		}
	}
	}

