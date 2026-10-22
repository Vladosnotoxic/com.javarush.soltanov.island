package myapp.model;

import myapp.config.AppConstants;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;
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

    public Location() {
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
        animals.removeIf(n -> !n.isAlive() || n.getLocation() != this);
        plants.removeIf(n -> !n.isAlive());
    }

    public void transferAnimal(Animal animal, Location newLocation) {
        this.getLock().lock();
        try {
            this.animals.remove(animal);
        } finally {
            this.getLock().unlock();
        }
        newLocation.getLock().lock();
        try {
            newLocation.animals.add(animal);
        }finally {
            newLocation.getLock().unlock();
        }
    }

    private void initCreature() {
        Random random = new Random();
        int minAnimal;
        int count = random.nextInt(100, AppConstants.CreatureMaxSize.PLANTS);

        for (int i = 0; i < count; i++) {
            plants.add(new Plant(this));
        }

        for (Class<? extends Animal> animalClass : AppConstants.spawnList) {
            try {
                Animal newAnimal = animalClass.getDeclaredConstructor(Location.class).newInstance(this);
                minAnimal = newAnimal instanceof Herbivore ? 15 : 5;
                count = random.nextInt(minAnimal, (int) (newAnimal.getMaxSize() * 0.8));
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
            int toGrow = ThreadLocalRandom.current().nextInt(30, 90);
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
