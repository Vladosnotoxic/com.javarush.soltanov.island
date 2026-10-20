package myapp.config;

import myapp.model.abstraction.Animal;
import myapp.model.herbivore.*;
import myapp.model.predator.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AppConstants {


    interface CreatureMaxSize {
        int PLANTS = 500;
        int WOLF = 10;
        int BEAR = 10;
        int HORSE = 20;
        int MOUSE = 50;
        int DUCK = 20;
        int CATERPILLAR = 20;
    }

    interface CreatureMaxWeight {
        int PLANTS = 1;
        double WOLF = 50;
        double BEAR = 500;
        double HORSE = 400;
        double MOUSE = 0.05;
        double DUCK = 1;
        double CATERPILLAR = 0.01;
    }

    interface CreatureIcon {
        String PLANT_ICON = "\uD83C\uDF31";
        String WOLF_ICON = "\uD83D\uDC3A";
        String BEAR_ICON = "\uD83D\uDC3B";
        String HORSE_ICON = "\uD83D\uDC0E";
        String MOUSE_ICON = "\uD83D\uDC01";
        String DUCK_ICON = "\uD83E\uDD86";
        String CATERPILLAR_ICON = "\uD83D\uDC1B";

    }

    List<Class<? extends Animal>> spawnList = List.of(
            Wolf.class,
            Bear.class,
            Horse.class,
            Mouse.class,
            Duck.class,
            Caterpillar.class
    );

    Map<Class<? extends Animal>, Map<Class<? extends Animal>, Integer>> chanceToEat = Map.of(
            Wolf.class, Map.of(
                    Horse.class, 10,
                    Mouse.class, 80,
                    Duck.class, 40
            ),

            Bear.class, Map.of(
                    Horse.class, 40,
                    Mouse.class, 90,
                    Duck.class, 10

            ),Duck.class, Map.of(
                    Caterpillar.class, 90)

    );
}
