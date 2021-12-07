package com.hcl.walmart.api;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class MailController {
@Autowired
private JavaMailSender sender;
@PostMapping("/sendMail")
public ResponseEntity sendMail() {
    MimeMessage message = sender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
   String html="<p>Hi!</p><a href=\"myhcl.com\">Link text</a>";
    try {
        helper.setTo("sai555977charan@gmail.com");
      helper.setText(html);
        helper.setSubject("Mail From Spring Boot");
    } catch (MessagingException e) {
        e.printStackTrace();
        return new ResponseEntity(HttpStatus.OK);
    }
    sender.send(message);
    return new ResponseEntity(HttpStatus.OK);
}
}
