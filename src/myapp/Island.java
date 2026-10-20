package myapp;

import myapp.config.Configuration;
public class Island {
    private static Island INSTANCE;
    private final Location[][] locations = new Location[Configuration.SIZE_X][Configuration.SIZE_Y];


    private Island(){};

    public static Island getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new Island();
            INSTANCE.initLocations();
        }

        return INSTANCE;
    }

    public Location[][] getLocations() {
        return locations;
    }

    private void initLocations() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
            }
        }
    }
}
