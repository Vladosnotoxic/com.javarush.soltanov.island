package myapp.utility;

import myapp.config.AppConstants;
import myapp.model.Plant;
import myapp.model.abstraction.Creature;
import myapp.model.abstraction.Herbivore;
import java.util.concurrent.ThreadLocalRandom;

public class EatUtil {

    public static boolean canEat(Creature hunter, Creature prey) {
        if (hunter instanceof Herbivore && prey instanceof Plant) {
            return true;
        }
        int chance = AppConstants.chanceToEat.get(hunter.getClass()).getOrDefault(prey.getClass(), 0);
        return chance == 100 || (chance != 0 && ThreadLocalRandom.current().nextInt(100) < chance);
    }

}
