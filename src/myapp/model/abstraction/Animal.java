package myapp.model.abstraction;

import myapp.config.Configuration;
import myapp.model.Location;
import myapp.utility.EatUtil;
import myapp.utility.LocationUtil;

public abstract class Animal extends Creature {

    protected int satiety = Configuration.DEFAULT_SATIETY;
    protected int maxSatiety = Configuration.MAX_SATIETY;
    protected int lastReproducedDay = 0;

    public Animal(String icon, double weight, int maxSize, Location location) {
        super(icon, weight, maxSize, location);

    }

    public abstract void hunt();

    public void eat(Creature prey) {
        if (!isAlive) return;
        if (prey.isAlive && EatUtil.canEat(this, prey)) {
            prey.die();
            this.satiety += 5;
            if (satiety >= maxSatiety) satiety = maxSatiety;
        }
    }

    public abstract Animal reproduce();

    public void multiply(int currentDay) {
        if (!this.isAlive || lastReproducedDay == currentDay || this.satiety <= 15) {
            return;
        }
        if (LocationUtil.isAnimalNonMax(location, this) && LocationUtil.isAnimalMin(location, this)) {
            for (Animal animal : location.getAnimals()){
                if(!animal.isAlive) continue;
                if(animal.getClass() == this.getClass() && animal != this && animal.lastReproducedDay != currentDay){
                    location.addAnimal(this.reproduce());
                    animal.lastReproducedDay = currentDay;
                    this.lastReproducedDay = currentDay;
                    return;
                }
            }
        }
    }

    public void starve() {
        satiety -= 10;
        if (satiety <= 0) this.die();
    }

    public boolean isHungry() {
        return satiety < maxSatiety;
    }
}
