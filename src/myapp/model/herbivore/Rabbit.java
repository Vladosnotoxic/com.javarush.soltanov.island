package myapp.model.herbivore;

import myapp.config.AppConstants;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;

public class Rabbit extends Herbivore {


    public Rabbit(Location location) {
        super(AppConstants.CreatureIcon.RABBIT_ICON, AppConstants.CreatureWeight.RABBIT, AppConstants.CreatureMaxSize.RABBIT, location);
    }

    @Override
    public Animal reproduce() {
        return new Rabbit(this.location);
    }
}

