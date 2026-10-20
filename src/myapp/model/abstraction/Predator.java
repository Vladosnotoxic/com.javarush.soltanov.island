package myapp.model.abstraction;

import myapp.Location;

public abstract class Predator extends Animal {

    public Predator(String icon, double weight, int maxSize, Location location) {
        super(icon, weight, maxSize, location);
    }

    @Override
    public void hunt() {
        if (!isAlive || !isHungry()) return;
        for (Animal animal : location.getAnimals()){
            if(this == animal || !animal.isAlive) continue;
            this.eat(animal);
            if (!isHungry()) return;
        }
    }
}
