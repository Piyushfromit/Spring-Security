package com.mscgift.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mscgift.entity.Users;
import com.mscgift.repository.UsersRepository;
import com.mscgift.service.MailService;
import com.mscgift.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginRegisterController {
	
	
	@Autowired
	private MailService mailService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private UsersRepository userRepository;
	
	
	
	@GetMapping("/register")
	public String getRegisterUser() {
		
		return "register";
		
	}
	
	
	@PostMapping("/register")
	public String PostRegisterUser(@ModelAttribute final Users users, final HttpSession session, final Model model) {   // @ModelAttribute   @RequestBody   @ResponseBody   
		if (this.userRepository.findByEmail(users.getEmail()).isPresent()) {
            model.addAttribute("registerFailMsg", "User with this email-Id already exist,\r\n" + "please login!");
            return "register";
        }
		
		// Send OTP To User Mail-Id
		String userMailId = users.getEmail();
        String otp = generateRandom6DigitOTP();
        System.out.println("User Sent OTP: " + otp);
        System.out.println("User Mail ID: " + userMailId);
        mailService.sendOTPToUserMailId(userMailId, otp);
        session.setAttribute("userToRegister", users);
        session.setAttribute("otpSentByCode", otp);
        
        // this.historyService.saveHistory(request, user, "/register", "User Register");
       
        return "otpform";
	}
	
	public String generateRandom6DigitOTP() {
        Random random = new Random();
        int min = 100000; 
        int max = 999999; 
        int otp = random.nextInt(max - min + 1) + min;
        return Integer.toString(otp);
    }
	
	@PostMapping("/verifyotp")
    public String PostVerifyOTP(@ModelAttribute(name = "otp") String otp, final Model model, final HttpSession session) {
		Users user = (Users) session.getAttribute("userToRegister");
		String otpSentByCode = (String)session.getAttribute("otpSentByCode");
		
		if(otp.equals(otpSentByCode)) {
			final Users regUser = this.usersService.registerUser(user);
			System.out.println("User successfully Registered");
		}
		
         System.out.println("User Entered OTP: " + otp);
         
         System.out.println("Developer OTP: " + otpSentByCode);
         
         return "index";   // redirect:/home
    }


	
}
