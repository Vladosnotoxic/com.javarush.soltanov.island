package myapp.model.abstraction;

import myapp.config.AppConstants;
import myapp.config.Configuration;
import myapp.model.Island;
import myapp.model.Location;
import myapp.utility.EatUtil;
import myapp.utility.LocationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

    public void move(Island island) {
        if (!this.isAlive) return;

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int maxMove = random.nextInt(this.maxLocationMove + 1);
        List<Location> possibleLocation;

        for (int k = 0; k < maxMove; k++) {

            possibleLocation = checkPossibleLocation(island);
            Location newLocation = possibleLocation.get(random.nextInt(possibleLocation.size()));

            if (this.location != newLocation) {
                if (LocationUtil.isAnimalNonMax(newLocation, this)) return;
                this.location.transferAnimal(this, newLocation);
                this.location = newLocation;
            }
        }
    }

    private List<Location> checkPossibleLocation(Island island) {
        Location[][] allLocation = island.getLocations();
        List<Location> possibleLocation = new ArrayList<>();
        int foundX = 0;
        int foundY = 0;

        findLocation:
        for (int i = 0; i < allLocation.length; i++) {
            for (int j = 0; j < allLocation[i].length; j++) {
                if (allLocation[i][j] == this.location) {
                    foundX = i;
                    foundY = j;
                    break findLocation;
                }
            }
        }

        if (foundX + 1 < allLocation.length) possibleLocation.add(allLocation[foundX + 1][foundY]);
        if (foundX - 1 >= 0) possibleLocation.add(allLocation[foundX - 1][foundY]);
        if (foundY + 1 < allLocation[foundX].length) possibleLocation.add(allLocation[foundX][foundY + 1]);
        if (foundY - 1 >= 0) possibleLocation.add(allLocation[foundX][foundY - 1]);
        return possibleLocation;
    }

    public abstract void hunt();

    protected void eat(Creature prey) {
        if (!isAlive || this.location != prey.location) return;
        if (prey.isAlive && EatUtil.canEat(this, prey)) {
            prey.die();
            this.upSatiety(prey);
        }
    }

    public abstract Animal reproduce();

    public void multiply(int currentDay) {
        if (!this.isAlive || lastReproducedDay == currentDay || (Configuration.IS_SATIETY_FOR_MULTIPLY && this.satiety <= Configuration.DEFAULT_SATIETY)) {
            return;
        }
        if (LocationUtil.isAnimalNonMax(location, this) && LocationUtil.isAnimalMin(location, this)) {
            for (Animal animal : location.getAnimals()) {
                if (!animal.isAlive) continue;
                if (animal.getClass() == this.getClass() && animal != this && animal.lastReproducedDay != currentDay) {
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

    private Double setMaxEatableWeight() {
        return AppConstants.maxEatableWeight.get(this.getClass());
    }

    private Integer setMaxLocationMove() {
        return AppConstants.maxLocationMove.get(this.getClass());
    }
}
