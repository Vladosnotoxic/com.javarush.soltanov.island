package myapp;

import myapp.model.Island;
import myapp.model.Location;
import myapp.model.abstraction.Animal;

import java.util.concurrent.Callable;

public class AnimalTask implements Callable<Void> {
    private final Island island;
    private final Animal animal;
    private final Location location;
    private final int currentDay;

    public AnimalTask(Island island, Animal animal, int day) {
        this.island = island;
        this.animal = animal;
        this.location = animal.getLocation();
        this.currentDay = day;
    }

    @Override
    public Void call() throws Exception {
        if (!animal.isAlive() || animal.getLocation() != location) return null;

        location.getLock().lockInterruptibly();

        try {
            if (!animal.isAlive()) return null;
            animal.hunt();
            animal.multiply(currentDay);
            animal.starve();

        } finally {
            location.getLock().unlock();
        }

        if (animal.isAlive()) {
            animal.move(island);
        }
        return null;
    }
}
