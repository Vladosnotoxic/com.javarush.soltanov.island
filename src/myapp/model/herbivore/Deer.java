package myapp.model.herbivore;

import myapp.config.AppConstants;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;

public class Deer extends Herbivore {

    public Deer(Location location) {
        super(AppConstants.CreatureIcon.DEER_ICON, AppConstants.CreatureWeight.DEER, AppConstants.CreatureMaxSize.DEER, location);
    }

    @Override
    public Animal reproduce() {
        return new Deer(this.location);
    }
}
