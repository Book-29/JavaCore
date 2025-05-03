package ru.innopolis.attestation3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.innopolis.attestation3.model.Patient;

@SpringBootApplication
public class Attestation3Application {

	public static void main(String[] args) {
		SpringApplication.run(Attestation3Application.class, args);

//проверка HTTP-клиента
		//RestTemplate restTemplate = new RestTemplate();
		//String url = "http://localhost:8080/api/patients";

		//ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

	//	if (response.getStatusCode().is2xxSuccessful()) {
	//		System.out.println("Response in JSON format: " + response.getBody());
	//	} else {
	//		System.out.println("Failed to fetch data");
	//	}
	}


	}




