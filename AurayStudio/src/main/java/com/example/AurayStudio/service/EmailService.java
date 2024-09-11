package com.example.AurayStudio.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.AurayStudio.dto.EmailDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService {
	private JavaMailSender javaMailSender;
	private static final String FROM_MAIL_KAKAO = "sherbet04@daum.net";  // 발신자 주소


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
			message.setFrom(FROM_MAIL_KAKAO); // 발신자는 고정된 이메일을 사용
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