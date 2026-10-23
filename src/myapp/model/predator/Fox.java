package myapp.model.predator;

import myapp.config.AppConstants;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Predator;

public class Fox extends Predator {

    public Fox(Location location) {
        super(AppConstants.CreatureIcon.FOX_ICON, AppConstants.CreatureWeight.FOX, AppConstants.CreatureMaxSize.FOX, location);
    }

    @Override
    public Animal reproduce() {
        return new Fox(this.location);
    }
}