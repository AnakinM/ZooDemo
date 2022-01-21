package pl.pjatk.zoo.ZooDemo.Services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.pjatk.zoo.ZooDemo.Models.Animal;
import pl.pjatk.zoo.ZooDemo.Models.AnimalDiet;
import pl.pjatk.zoo.ZooDemo.Models.AnimalType;
import pl.pjatk.zoo.ZooDemo.Models.Zoo;
import pl.pjatk.zoo.ZooDemo.Repositories.ZooRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ZooServiceIT {

    @Autowired
    private ZooService zooService = new ZooService(null);

    @MockBean
    private ZooRepository zooRepository;

    @Test
    void shouldAddPrefixToNameGdansk () {
        Zoo zoo = new Zoo(null, "Jurasic Park", "Gdansk", false, List.of());
        zooService.addPrefixToName(zoo);
        assertThat(zoo.getName()).isEqualTo("Gdanskie zoo Jurasic Park");
    }

    @Test
    void shouldAddPrefixToNameWarszawa () {
        Zoo zoo = new Zoo(null, "Jurasic Park", "Warszawa", false, List.of());
        zooService.addPrefixToName(zoo);
        assertThat(zoo.getName()).isEqualTo("Warszawskie zoo Jurasic Park");
    }

    @Test
    void shouldAddPrefixToNameInne () {
        Zoo zoo = new Zoo(null, "Jurasic Park", "Poznan", false, List.of());
        zooService.addPrefixToName(zoo);
        assertThat(zoo.getName()).isEqualTo("zoo Jurasic Park");
    }

    @Test
    void shouldAddAnimalToZoo () {
        Zoo zoo = new Zoo(null, "Jurasic Park", "Gdansk", false, new ArrayList<>());
        Animal animal = new Animal(null, "tadek", AnimalDiet.MEAT, AnimalType.LAND, false, true);
        zooService.addAnimalToZoo(zoo, animal);
        assertThat(zoo.getAnimals()).isNotNull().hasSize(1);
    }

    @Test
    void shouldChangeZooLocationIfEmpty () {
        Zoo zoo = new Zoo(null, "Jurasic Park", "Gdansk", false, List.of());
        zooService.changeZooLocationIfEmpty(zoo, "Warszawa");
        assertThat(zoo.getLocation()).isEqualTo("Warszawa");
    }

    @Test
    void shouldNotChangeZooLocationIfNotEmpty () {
        Animal animal = new Animal(null, "tadek", AnimalDiet.MEAT, AnimalType.LAND, false, true);
        Zoo zoo = new Zoo(null, "Jurasic Park", "Gdansk", false, List.of(animal));
        zooService.changeZooLocationIfEmpty(zoo, "Warszawa");
        assertThat(zoo.getLocation()).isEqualTo("Gdansk");
    }

    @Test
    void shouldIsAnimalOk () {
        Animal animal = new Animal(null, "tadek", AnimalDiet.MEAT, AnimalType.LAND, false, true);
        boolean isOk = zooService.isAnimalOk(animal);
        assertThat(animal.isHealthy() && !animal.isHungry()).isEqualTo(isOk);
    }

    @Test
    void shouldChangeAnimalDietIfSick () {
        Animal animal = new Animal(null, "tadek", AnimalDiet.MEAT, AnimalType.LAND, false, false);
        zooService.changeAnimalDietIfSick(animal);
        assertThat(animal.getDiet()).isEqualTo(AnimalDiet.MIXED);
    }

    @Test
    void shouldFeedAnimalIfHungry () {
        Animal animal = new Animal(null, "tadek", AnimalDiet.MEAT, AnimalType.LAND, false, true);
        zooService.feedAnimalIfHungry(animal);
        assertThat(animal.isHungry()).isFalse();
    }
}
