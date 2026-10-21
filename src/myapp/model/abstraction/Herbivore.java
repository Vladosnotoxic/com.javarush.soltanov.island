package myapp.model.abstraction;

import myapp.model.Location;
import myapp.model.Plant;

public abstract class Herbivore extends Animal {

    public Herbivore(String icon, double weight, int maxSize, Location location) {
        super(icon, weight, maxSize, location);
    }

    @Override
    public void hunt() {
        if (!isAlive || !isHungry()) return;
        for (Plant plant : location.getPlants()) {
            if (!plant.isAlive) continue;
            this.eat(plant);
            if (!isHungry()) return;
        }
    }
}
