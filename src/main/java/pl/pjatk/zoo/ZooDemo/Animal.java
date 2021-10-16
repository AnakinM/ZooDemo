package pl.pjatk.zoo.ZooDemo;

public class Animal {
    private Integer id;
    private String specimen;
    private Diet diet;
    private AnimalType type;
    private boolean isHungry;
    private boolean isHealthy;

    public Animal(Integer id, String specimen, Diet diet, AnimalType type, boolean isHungry, boolean isHealthy) {
        this.id = id;
        this.specimen = specimen;
        this.diet = diet;
        this.type = type;
        this.isHungry = isHungry;
        this.isHealthy = isHealthy;
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

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
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