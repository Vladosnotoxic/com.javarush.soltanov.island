package myapp.model.herbivore;

import myapp.model.Location;
import myapp.config.AppConstants;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;

public class Horse extends Herbivore {

    public Horse(Location location) {
        super(AppConstants.CreatureIcon.HORSE_ICON, AppConstants.CreatureWeight.HORSE, AppConstants.CreatureMaxSize.HORSE, location);
    }

    @Override
    public Animal reproduce() {
        return new Horse(this.location);
    }

}
