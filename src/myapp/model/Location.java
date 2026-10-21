package myapp.model;

import myapp.config.AppConstants;
import myapp.model.abstraction.Animal;
import myapp.utility.LocationUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class Location {
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final ArrayList<Plant> plants = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    protected Location() {
        initCreature();
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeCreature() {
        animals.removeIf(n -> !n.isAlive());
        plants.removeIf(n -> !n.isAlive());
    }

    private void initCreature() {
        Random random = new Random();
        int count = random.nextInt(10, AppConstants.CreatureMaxSize.PLANTS);

        for (int i = 0; i < count; i++) {
            plants.add(new Plant(this));
        }

        for (Class<? extends Animal> animalClass : AppConstants.spawnList) {
            try {
                Animal newAnimal = animalClass.getDeclaredConstructor(Location.class).newInstance(this);
                count = random.nextInt(newAnimal.getMaxSize());
                for (int i = 0; i < count; i++) {
                    animals.add(animalClass.getDeclaredConstructor(Location.class).newInstance(this));
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public void growPlants() {
        if (LocationUtil.isPlantsNonMax(this)) {
            int toGrow = ThreadLocalRandom.current().nextInt(1, 30);
            for (int i = 0; i < toGrow; i++) {
                if (LocationUtil.isPlantsNonMax(this)) {
                    plants.add(new Plant(this));
                }
            }
        }
    }

    public List<Animal> animalCopy() {
        return List.copyOf(this.getAnimals());

    }
}
