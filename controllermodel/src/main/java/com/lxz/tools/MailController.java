package com.lxz.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class MailController {
    @Autowired
    private JavaMailSender jms;

    @RequestMapping("/getCheckCode")
    @ResponseBody
    public String getCheckCode(String email){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        System.out.println(checkCode);
        String message = "您的验证码为："+checkCode;
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("1609078897@qq.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("验证码");
        mailMessage.setText(message);
        jms.send(mailMessage);
        return checkCode;
    }
}
