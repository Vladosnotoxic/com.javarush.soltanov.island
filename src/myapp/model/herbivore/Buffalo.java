package myapp.model.herbivore;

import myapp.config.AppConstants;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;

public class Buffalo extends Herbivore {

    public Buffalo(Location location) {
        super(AppConstants.CreatureIcon.BUFFALO_ICON, AppConstants.CreatureWeight.BUFFALO, AppConstants.CreatureMaxSize.BUFFALO, location);
    }

    @Override
    public Animal reproduce() {
        return new Buffalo(this.location);
    }
}
