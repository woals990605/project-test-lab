package site.metacoding.projectjeju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProjectJejuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectJejuApplication.class, args);
	}

}
