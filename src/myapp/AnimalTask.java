package myapp;

import myapp.model.Island;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import java.util.concurrent.Callable;

public class AnimalTask implements Callable<Void> {
    private final Island island;
    private final Animal animal;
    private final Location location;
    private int currentDay;

    public AnimalTask(Island island, Animal animal, int day) {
        this.island = island;
        this.animal = animal;
        this.location = animal.getLocation();
        this.currentDay = day;
    }

    @Override
    public Void call() throws Exception {
        if (!animal.isAlive()) return null;
        location.getLock().lockInterruptibly();
        try{
            if (!animal.isAlive()) return null;
            animal.multiply(currentDay);
            animal.hunt();
            animal.starve();

//            System.out.println(animal.getClass().getSimpleName() + " -> сытость: " + animal.getSatiety() + ", жив: " + animal.isAlive());
        }finally {
            location.getLock().unlock();
        }
        return null;
    }
}
