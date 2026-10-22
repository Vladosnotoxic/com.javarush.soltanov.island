package myapp.model.herbivore;

import myapp.model.Location;
import myapp.config.AppConstants;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;

public class Duck extends Herbivore {
    public static int counter = 0;

    public Duck(Location location) {
        super(AppConstants.CreatureIcon.DUCK_ICON, AppConstants.CreatureWeight.DUCK, AppConstants.CreatureMaxSize.DUCK, location);
    }

    @Override
    public Animal reproduce() {
        return new Duck(this.location);
    }


    @Override
    public void hunt() {
        if (!isAlive || !isHungry()) return;
        for (Animal animal : location.getAnimals()) {
            if (animal.isAlive() && animal.getClass() == Caterpillar.class)
                this.eat(animal);
            if (!isHungry()) return;
        }
        super.hunt();
    }
}
