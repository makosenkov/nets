package mksnkv.nets;

import mksnkv.nets.controllers.EntitiesController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses= EntitiesController.class)
public class NetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetsApplication.class, args);
	}

}
