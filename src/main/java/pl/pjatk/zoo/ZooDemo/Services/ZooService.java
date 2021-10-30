package pl.pjatk.zoo.ZooDemo.Services;

import org.springframework.stereotype.Service;
import pl.pjatk.zoo.ZooDemo.Models.Animal;
import pl.pjatk.zoo.ZooDemo.Models.AnimalDiet;
import pl.pjatk.zoo.ZooDemo.Models.AnimalType;
import pl.pjatk.zoo.ZooDemo.Models.Zoo;

import java.util.List;

@Service
public class ZooService {

    public Zoo getExampleZoo() {
        Animal wolf = new Animal(0, "tadek", AnimalDiet.MEAT, AnimalType.LAND, false, true);
        List<Animal> wolves = List.of(wolf);
        return new Zoo(0, "Jurassic Park", "Gdansk", false, wolves);
    }

    public Zoo getEmptyZoo() {
        return new Zoo(0, "Jurassic Park", "Gdansk", false, null);
    }

    public Zoo getEmptyZooForName(String name){
        return new Zoo(0, "Jurassic Park", name, false, null);
    }
}
