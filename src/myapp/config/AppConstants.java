package myapp.config;

import myapp.model.abstraction.Animal;
import myapp.model.herbivore.*;
import myapp.model.predator.*;
import java.util.List;
import java.util.Map;

public interface AppConstants {

    interface CreatureMaxSize {
        int PLANTS = 1000;
        int WOLF = 30;
        int BOA = 30;
        int FOX = 30;
        int BEAR = 5;
        int EAGLE = 20;
        int HORSE = 20;
        int DEER = 20;
        int RABBIT = 150;
        int MOUSE = 500;
        int GOAT = 140;
        int SHEEP = 140;
        int HOG = 50;
        int BUFFALO = 10;
        int DUCK = 200;
        int CATERPILLAR = 200;

    }

    interface CreatureWeight {
        int PLANTS = 1;
        double WOLF = 50;
        double BOA = 15;
        double FOX = 8;
        double BEAR = 500;
        double EAGLE = 6;
        double HORSE = 400;
        double DEER = 300;
        double RABBIT = 2;
        double MOUSE = 0.05;
        double GOAT = 60;
        double SHEEP = 70;
        double HOG = 400;
        double BUFFALO = 700;
        double DUCK = 1;
        double CATERPILLAR = 0.01;
    }

    interface CreatureIcon {
        String PLANT_ICON = "\uD83C\uDF31";
        String WOLF_ICON = "\uD83D\uDC3A";
        String BOA_ICON = "\uD83D\uDC0D";
        String FOX_ICON = "\uD83E\uDD8A";
        String BEAR_ICON = "\uD83D\uDC3B";
        String EAGLE_ICON = "\uD83E\uDD85";
        String HORSE_ICON = "\uD83D\uDC0E";
        String DEER_ICON = "\uD83E\uDD8C";
        String RABBIT_ICON = "\uD83D\uDC07";
        String MOUSE_ICON = "\uD83D\uDC01";
        String GOAT_ICON = "\uD83D\uDC10";
        String SHEEP_ICON = "\uD83D\uDC11";
        String HOG_ICON = "\uD83D\uDC17";
        String BUFFALO_ICON = "\uD83D\uDC03";
        String DUCK_ICON = "\uD83E\uDD86";
        String CATERPILLAR_ICON = "\uD83D\uDC1B";
    }

    List<Class<? extends Animal>> spawnList = List.of(
            Wolf.class,
            Boa.class,
            Fox.class,
            Bear.class,
            Eagle.class,
            Horse.class,
            Deer.class,
            Rabbit.class,
            Mouse.class,
            Goat.class,
            Sheep.class,
            Hog.class,
            Buffalo.class,
            Duck.class,
            Caterpillar.class
    );

    Map<Class<? extends Animal>, Map<Class<? extends Animal>, Integer>> chanceToEat = Map.of(
            Wolf.class, Map.of(
                    Horse.class, 10,
                    Deer.class, 15,
                    Rabbit.class, 60,
                    Mouse.class, 80,
                    Goat.class, 60,
                    Sheep.class, 70,
                    Hog.class, 15,
                    Buffalo.class, 10,
                    Duck.class, 40
            ),
            Boa.class, Map.of(
                    Fox.class, 15,
                    Rabbit.class, 20,
                    Mouse.class, 40,
                    Duck.class, 10
            ),
            Fox.class, Map.of(
                    Rabbit.class, 70,
                    Mouse.class, 90,
                    Duck.class, 60,
                    Caterpillar.class, 40
            ),

            Bear.class, Map.of(
                    Boa.class, 80,
                    Horse.class, 40,
                    Deer.class, 80,
                    Rabbit.class, 80,
                    Mouse.class, 90,
                    Goat.class, 70,
                    Sheep.class, 70,
                    Hog.class, 50,
                    Buffalo.class, 20,
                    Duck.class, 10

            ),Duck.class, Map.of(
                    Caterpillar.class, 90)

    );

    Map<Class<? extends Animal>, Double> maxEatableWeight = Map.ofEntries(
            Map.entry(Wolf.class, 8.0),
            Map.entry(Boa.class, 3.0),
            Map.entry(Fox.class, 2.0),
            Map.entry(Bear.class, 8.0),
            Map.entry(Eagle.class, 1.0),
            Map.entry(Horse.class, 60.0),
            Map.entry(Deer.class, 50.0),
            Map.entry(Rabbit.class, 0.45),
            Map.entry(Mouse.class, 0.01),
            Map.entry(Goat.class, 10.0),
            Map.entry(Sheep.class, 15.0),
            Map.entry(Hog.class, 50.0),
            Map.entry(Buffalo.class, 100.0),
            Map.entry(Duck.class, 0.15),
            Map.entry(Caterpillar.class, 0.0)
    );


    Map<Class<? extends Animal>, Integer> maxLocationMove = Map.ofEntries(
            Map.entry(Wolf.class, 3),
            Map.entry(Boa.class, 1),
            Map.entry(Fox.class, 2),
            Map.entry(Bear.class, 2),
            Map.entry(Eagle.class, 3),
            Map.entry(Horse.class, 4),
            Map.entry(Deer.class, 4),
            Map.entry(Rabbit.class, 2),
            Map.entry(Mouse.class, 1),
            Map.entry(Goat.class, 3),
            Map.entry(Sheep.class, 3),
            Map.entry(Hog.class, 2),
            Map.entry(Buffalo.class, 3),
            Map.entry(Duck.class, 4),
            Map.entry(Caterpillar.class, 0)
    );

}
