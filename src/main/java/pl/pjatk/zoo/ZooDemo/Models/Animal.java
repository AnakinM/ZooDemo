package pl.pjatk.zoo.ZooDemo.Models;

import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true, length = 200)
    private String specimen;

    @Column(nullable = true)
    private AnimalDiet diet;

    @Column(nullable = true)
    private AnimalType type;

    @Column()
    private boolean isHungry;

    @Column()
    private boolean isHealthy;

    public Animal() {

    }

    public Animal(Integer id, String specimen, AnimalDiet diet, AnimalType type, boolean isHungry, boolean isHealthy) {
        this.id = id;
        this.specimen = specimen;
        this.diet = diet;
        this.type = type;
        this.isHungry = isHungry;
        this.isHealthy = isHealthy;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", specimen='" + specimen + '\'' +
                ", diet=" + diet +
                ", type=" + type +
                ", isHungry=" + isHungry +
                ", isHealthy=" + isHealthy +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public AnimalDiet getDiet() {
        return diet;
    }

    public void setDiet(AnimalDiet diet) {
        this.diet = diet;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }
}
