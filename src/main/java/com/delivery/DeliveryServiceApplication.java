package com.delivery;

import com.delivery.dto.DeliveryPersonResponse;
import com.delivery.entity.DeliveryPerson;
import com.delivery.entity.Restaurant;
import com.delivery.repository.DeliveryPersonRepository;
import com.delivery.repository.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeliveryServiceApplication implements CommandLineRunner {

	@Autowired
	private RestaurantsRepository restaurantsRepository;

	@Autowired
	private DeliveryPersonRepository deliveryPersonRepository;

	public static void main(String[] args) {
		SpringApplication.run(DeliveryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//registering some new restaurants and delivery persons
		Restaurant rest1 = new Restaurant("Falavours of China","acchutam.kulthe@neosoft@neosoftmail.com","6787890987");
		Restaurant rest2 = new Restaurant("Pawars","acchutam.kulthe@neosoft@neosoftmail.com","0987898767");
		Restaurant rest3 = new Restaurant("Sujay","abhishek.baghel@neosoftmail.com","56787689873");
		Restaurant rest4 = new Restaurant("Zaiqa","abhishek.baghel@neosoftmail.com","6578765435");
		Restaurant rest5 = new Restaurant("Dawat-E-Iran","arbaaz.sayed@neosoftmail.com","8989767878");
		this.restaurantsRepository.save(rest1);
		this.restaurantsRepository.save(rest2);
		this.restaurantsRepository.save(rest3);
		this.restaurantsRepository.save(rest4);
		this.restaurantsRepository.save(rest5);

		//creating new Delivery persons
		DeliveryPerson person1 = new DeliveryPerson("Arbaaz", "Sayed","arbaaz.sayed@neosoftmail.com","8390816370");
		DeliveryPerson person2 = new DeliveryPerson("Acchutam", "Kulthe","acchutam.kulthe@neosoftmail.com","7687987678");
		DeliveryPerson person3 = new DeliveryPerson("Abhishek", "Baghel","abhishek.baghel@neosoftmail.com","9890986789");
		this.deliveryPersonRepository.save(person1);
		this.deliveryPersonRepository.save(person2);
		this.deliveryPersonRepository.save(person3);
	}
}
