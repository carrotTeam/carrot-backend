package carrotTeam.carrot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CarrotBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrotBackendApplication.class, args);
	}

}
