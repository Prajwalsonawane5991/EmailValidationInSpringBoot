package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Component
public class EmailUtilUser {
	@Autowired
	private JavaMailSender javamailsender;
	
	public void sendOtpEmail(String email,String otp)throws MessagingException
	{
//		SimpleMailMessage simplemailMessage= new SimpleMailMessage();
//		simplemailMessage.setTo(email);
//		simplemailMessage.setSubject("Verify OTP");
//		simplemailMessage.setText("Hello,Your otp is "+ otp);
		MimeMessage mimeMessage=javamailsender.createMimeMessage();
		MimeMessageHelper mimemessageHelper=new MimeMessageHelper(mimeMessage);
		mimemessageHelper.setTo(email);
		mimemessageHelper.setSubject("verify OTP");
		mimemessageHelper.setText("""
				<div>
				<a href="http://localhost:9191/user/verify-account?email=%s&otp=%s" target="blank">click to verify</a>
				</div>
				""".formatted(email,otp),true);
		javamailsender.send(mimeMessage);
	}

	
}
