package myapp.model.abstraction;

import myapp.config.AppConstants;
import myapp.config.Configuration;
import myapp.model.Location;
import myapp.utility.EatUtil;
import myapp.utility.LocationUtil;

public abstract class Animal extends Creature {

    protected int satiety = Configuration.DEFAULT_SATIETY;
    protected int lastReproducedDay = 0;
    protected double maxEatableWeight;
    protected int maxLocationMove;

    public Animal(String icon, double weight, int maxSize, Location location) {
        super(icon, weight, maxSize, location);
        maxEatableWeight = setMaxEatableWeight();
        maxLocationMove = setMaxLocationMove();
    }



    public void move(){

    }

    public abstract void hunt();

    protected void eat(Creature prey) {
        if (!isAlive) return;
        if (prey.isAlive && EatUtil.canEat(this, prey)) {
            prey.die();
            this.upSatiety(prey);
        }
    }

    public abstract Animal reproduce();

    public void multiply(int currentDay) {
        if (!this.isAlive || lastReproducedDay == currentDay || (Configuration.IS_SATIETY_FOR_MULTIPLY && this.satiety <= Configuration.DEFAULT_SATIETY) ) {
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

    private void upSatiety(Creature prey) {
        if (prey.weight >= this.maxEatableWeight) {
            satiety = Configuration.MAX_SATIETY;
            return;
        }
        this.satiety += (int) (prey.weight / this.maxEatableWeight * Configuration.MAX_SATIETY);
        if (satiety >= Configuration.MAX_SATIETY) satiety = Configuration.MAX_SATIETY;
    }

    public void starve() {
        satiety -= (int) (Configuration.MAX_SATIETY * 0.2);
        if (satiety <= 0) this.die();
    }

    protected boolean isHungry() {
        return satiety < Configuration.MAX_SATIETY;
    }

    private Double setMaxEatableWeight(){
       return AppConstants.maxEatableWeight.get(this.getClass());
    }

    private Integer setMaxLocationMove(){
        return AppConstants.maxLocationMove.get(this.getClass());
    }
}
