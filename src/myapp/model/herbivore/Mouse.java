package myapp.model.herbivore;

import myapp.model.Location;
import myapp.config.AppConstants;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;

public class Mouse extends Herbivore {


    public Mouse(Location location) {
        super(AppConstants.CreatureIcon.MOUSE_ICON, AppConstants.CreatureWeight.MOUSE, AppConstants.CreatureMaxSize.MOUSE, location);
    }

    @Override
    public Animal reproduce() {
        return new Mouse(this.location);
    }
}
