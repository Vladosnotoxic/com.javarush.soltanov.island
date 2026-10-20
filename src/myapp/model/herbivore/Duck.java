package myapp.model.herbivore;

import myapp.Location;
import myapp.config.AppConstants;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;

public class Duck extends Herbivore {
    public Duck(Location location) {
        super(AppConstants.CreatureIcon.MOUSE_ICON, AppConstants.CreatureMaxWeight.DUCK, AppConstants.CreatureMaxSize.DUCK, location);
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
