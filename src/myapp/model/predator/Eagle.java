package myapp.model.predator;

import myapp.config.AppConstants;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Predator;

public class Eagle extends Predator {

    public Eagle(Location location) {
        super(AppConstants.CreatureIcon.EAGLE_ICON, AppConstants.CreatureWeight.EAGLE, AppConstants.CreatureMaxSize.EAGLE, location);
    }

    @Override
    public Animal reproduce() {
        return new Eagle(this.location);
    }
}

