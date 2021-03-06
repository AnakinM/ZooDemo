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
        return new Zoo(1, name, "Gdansk", false, null);
    }

    public List<Zoo> findAllZoos() {
        return zooRepository.findAll();
    }

    public Zoo findZooById(Integer id) {
        Optional<Zoo> byId = zooRepository.findById(id);
        return byId.orElse(new Zoo());
    }

    public void addPrefixToName(Zoo zoo) {
        String prefixName;
        if (zoo.getName() != null && zoo.getLocation().equals("Gdansk")) {
            prefixName = "Gdanskie zoo " + zoo.getName();
        }
        else if (zoo.getName() != null && zoo.getLocation().equals("Warszawa")) {
            prefixName = "Warszawskie zoo " + zoo.getName();
        }
        else {
            prefixName = "zoo " + zoo.getName();
        }
        zoo.setName(prefixName);
    }

    public void addAnimalToZoo(Zoo zoo, Animal animal) {
        if (zoo.getAnimals() != null) {
            zoo.getAnimals().add(animal);
        }
    }

    public void changeZooLocationIfEmpty(Zoo zoo, String newLocation) {
        if (zoo.getLocation() != null && (zoo.getAnimals() == null || zoo.getAnimals().isEmpty())) {
            zoo.setLocation(newLocation);
        }
    }

    public boolean isAnimalOk (Animal animal) {
        return animal.isHealthy() && !animal.isHungry();
    }

    public void changeAnimalDietIfSick (Animal animal) {
        if (!animal.isHealthy() && animal.getDiet() == AnimalDiet.MEAT) {
            animal.setDiet(AnimalDiet.MIXED);
        }
    }

    public void feedAnimalIfHungry (Animal animal) {
        if (animal.isHungry()) {
            animal.setHungry(false);
        }
    }
}
