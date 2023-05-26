package com.delivery.service;

import com.delivery.dto.Customer;
import com.delivery.dto.RestaurantRequest;
import com.delivery.dto.RestaurantResponse;
import com.delivery.entity.Restaurant;
import com.delivery.repository.RestaurantsRepository;
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
public class RestaurantService {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.key2}")
    private String despathorderKey;

    @Autowired
    private RestaurantsRepository restaurantsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MailingService mailingService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public RestaurantResponse registerRestaurant(RestaurantRequest request)
    {
        Restaurant savedRest = this.restaurantsRepository.save(this.modelMapper.map(request, Restaurant.class));
        return this.modelMapper.map(savedRest,RestaurantResponse.class);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name1.2}"})
    public void orderRecievedForRestRaunt(Customer customer) throws MessagingException {
        Random rand = new Random();
        long id = rand.nextLong(5);
        Restaurant restaurant = this.restaurantsRepository.findById(id).get();
        log.info("Rastaurant listener executed");
        log.info(restaurant.toString());

        this.mailingService.sendOrderPlacedEmailRestRaunt(restaurant.getRestaurantEmail(),customer);
    }

    public void sendOrderdespatchmail(String customerEmail) throws MessagingException {
    this.rabbitTemplate.convertAndSend(exchange,despathorderKey,customerEmail);
    }

}
