package pl.pjatk.zoo.ZooDemo.Services;

import org.springframework.stereotype.Service;
import pl.pjatk.zoo.ZooDemo.Models.Animal;
import pl.pjatk.zoo.ZooDemo.Models.AnimalDiet;
import pl.pjatk.zoo.ZooDemo.Models.AnimalType;
import pl.pjatk.zoo.ZooDemo.Models.Zoo;
import pl.pjatk.zoo.ZooDemo.Repositories.ZooRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ZooService {

    private final ZooRepository zooRepository;

    public ZooService(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    public Zoo getExampleZoo() {
        Animal wolf = new Animal(null, "tadek", AnimalDiet.MEAT, AnimalType.LAND, false, true);
        List<Animal> wolves = List.of(wolf);
        Zoo zoo = new Zoo(null, "Jurassic Park", "Gdansk", false, wolves);
        return zooRepository.save(zoo);
    }

    public Zoo getEmptyZoo() {
        return new Zoo(1, "Jurassic Park", "Gdansk", false, null);
    }

    public Zoo getEmptyZooForName(String name){
        return new Zoo(1, "Jurassic Park", name, false, null);
    }

    public List<Zoo> findAllZoos() {
        return zooRepository.findAll();
    }

    public Optional<Zoo> findZooById(Integer id) {
        return zooRepository.findById(id);
    }
}
