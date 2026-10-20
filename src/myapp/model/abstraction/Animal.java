package myapp.model.abstraction;

import myapp.Location;
import myapp.utility.EatUtil;
import myapp.utility.LocationUtil;


public abstract class Animal extends Creature {

    protected int satiety = 20;
    protected int maxSatiety = 30;
    protected int lastReproducedDay = -1;

    public Animal(String icon, double weight, int maxSize, Location location) {
        super(icon, weight, maxSize, location);

    }

    public int getSatiety() {
        return satiety;
    }

    public abstract void hunt();

    public void eat(Creature prey) {
        if (!isAlive) return;
        if (prey.isAlive && EatUtil.canEat(this, prey)) {
            prey.die();
            this.satiety += 10;
            if (satiety >= maxSatiety) satiety = maxSatiety;
        }
    }

    public abstract Animal reproduce();

    public void multiply(int currentDay) {
        if (!this.isAlive && lastReproducedDay == currentDay) {
            return;
        }
        if (LocationUtil.isAnimalNonMax(location, this) && LocationUtil.isAnimalMin(location, this)) {

            location.addAnimal(this.reproduce());

        }
    }

    public void starve() {
        satiety -= 10;
        if (satiety <= 0) this.die();
    }

    public void die() {
        if (!isAlive) return;
        isAlive = false;
//        location.removeAnimal(this);
    }

    public boolean isHungry() {
        return satiety < maxSatiety;
    }
}
