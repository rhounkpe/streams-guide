package be.digitcom.streams;

import be.digitcom.streams.models.Employee;
import be.digitcom.streams.models.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.stream.Stream;

@SpringBootApplication
public class StreamsGuideApplication {

	public static enum Number {
		ONE, TWO, THREE, FOUR;
	}

	public static void main(String[] args) {
		SpringApplication.run(StreamsGuideApplication.class, args);

		Number number = Number.THREE;
		String message = switch (number) {
			case ONE -> {yield "Got a 1";}
			case TWO -> {yield "Got a 2";}
			case THREE -> {yield "Got a 3";}
			case FOUR -> {yield "Got a 4";}
			default -> {yield "More than 4";}
		};

		System.out.println(message);
	}

}
