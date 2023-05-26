package com.delivery.service;

import com.delivery.dto.Customer;
import com.delivery.dto.DeliveryPersonRequest;
import com.delivery.dto.DeliveryPersonResponse;
import com.delivery.entity.DeliveryPerson;
import com.delivery.repository.DeliveryPersonRepository;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class DeliveryPersonService {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.key3}")
    private String bindingkey;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DeliveryPersonRepository  deliveryPersonRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MailingService mailingService;


    public DeliveryPersonResponse savePerson(DeliveryPersonRequest request)
    {
        DeliveryPerson savedDeliveryPerson = this.deliveryPersonRepository.save(this.modelMapper.map(request, DeliveryPerson.class));
        return this.modelMapper.map(savedDeliveryPerson,DeliveryPersonResponse.class);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name1.1}"})
    public void orderPlaced(Customer customer) throws MessagingException {
        Random rand = new Random();
        long id = rand.nextLong(3);
        DeliveryPerson person = this.deliveryPersonRepository.findById(id).get();
        log.info("Rastaurant listener executed");
        log.info(person.toString());
        this.mailingService.sendOrderreceivedMailDeliveryBoy(person.getPersonEmail(),customer);
    }



    public void orderDeliveredService(String email)
    {
        this.rabbitTemplate.convertAndSend(exchange,bindingkey,email);
    }

}
