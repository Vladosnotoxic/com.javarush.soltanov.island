package myapp.model.predator;

import myapp.config.AppConstants;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Predator;

public class Boa extends Predator {

    public Boa(Location location) {
        super(AppConstants.CreatureIcon.BOA_ICON, AppConstants.CreatureWeight.BOA, AppConstants.CreatureMaxSize.BOA, location);
    }

    @Override
    public Animal reproduce() {
        return new Boa(this.location);
    }
}
