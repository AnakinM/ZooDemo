package pl.pjatk.zoo.ZooDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pjatk.zoo.ZooDemo.Models.Animal;
import pl.pjatk.zoo.ZooDemo.Models.AnimalDiet;
import pl.pjatk.zoo.ZooDemo.Models.AnimalType;
import pl.pjatk.zoo.ZooDemo.Models.Zoo;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ZooDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooDemoApplication.class, args);
	}

}
