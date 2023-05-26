package com.delivery.service;

import com.delivery.dto.Customer;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailingService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.sender}")
    private String fromMail;

    public void sendOrderPlacedEmailRestRaunt(String toMail, Customer customer) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Order Received!!");
        helper.setTo(toMail);
        helper.setFrom(fromMail);

        boolean html = true;

        helper.setText("<h3>Hey There!!<h3> <br> " +
                "<h5><i>Order placed in your restraunt.</i></h5> <br>" +
                "<h5><i>Here are the details</i></h5>"+customer.getFirstName()+" "+customer.getPhoneNo(),html);

        javaMailSender.send(mimeMessage);
    }

    public void sendOrderreceivedMailDeliveryBoy(String toMail,Customer customer) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Order Received!!");
        helper.setTo(toMail);
        helper.setFrom(fromMail);

        boolean html = true;

        helper.setText("<h3>Hey There!!<h3> <br> " +
                "<h5><i>Below are the delivery details</i></h5> <br>" +
                "<h5><i>"+customer.getFirstName()+" "+customer.getPhoneNo()+" </i></h5>",html);

        javaMailSender.send(mimeMessage);
    }

}
