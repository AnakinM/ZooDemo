package pl.pjatk.zoo.ZooDemo.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.zoo.ZooDemo.Models.Animal;
import pl.pjatk.zoo.ZooDemo.Models.AnimalDiet;
import pl.pjatk.zoo.ZooDemo.Models.AnimalType;
import pl.pjatk.zoo.ZooDemo.Models.Zoo;

import java.util.List;

@RestController
@RequestMapping("/zoo")
public class ZooRestController {

    @GetMapping("/example")
    public ResponseEntity<Zoo> getExampleZoo() {
        Animal tadek = new Animal(0, "Wolf", AnimalDiet.MEAT, AnimalType.LAND, false, true);
        List<Animal> wolves = List.of(tadek);
        Zoo jurassicPark = new Zoo(0, "Jurassic Park", "Some island", false, wolves);
        return ResponseEntity.ok(jurassicPark);
    }
}
