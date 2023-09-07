package com.mscgift.service;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import com.mscgift.MyConfiguration;





@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MyConfiguration myConfiguration;
	
	
	
	@Override
	public void sendOTPToUserMailId(String toMailId, String otp) {
        SimpleMailMessage mailData = new SimpleMailMessage();
        mailData.setTo(toMailId);
        mailData.setSubject("Mial for OTP");
        
        
        final StringBuffer strEmail = new StringBuffer();
        strEmail.append(otp);
        mailData.setText(String.valueOf(strEmail));
        
        
        
        MailSender mailsender = myConfiguration.javaMailSenderForOTP();
        mailsender.send(mailData);
    }
	

	
	

}
