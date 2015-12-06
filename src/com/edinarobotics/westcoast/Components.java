package com.edinarobotics.westcoast;

import com.edinarobotics.westcoast.subsystems.Drivetrain;

public class Components {

    private static Components instance;

    public Drivetrain drivetrain;

    private final int TOP_LEFT_CANTALON = 1;
    private final int TOP_RIGHT_CANTALON = 2;
    private final int BOTTOM_LEFT_CANTALON = 2;
    private final int BOTTOM_RIGHT_CANTALON = 4;

    private Components() {
        BOTTOM_LEFT_CANTALON = 3;
        drivetrain = new _______(TOP_LEFT_CANTALON, BOTTOM_LEFT_CANTALON, TOP_RIGHT_CANTALON, BOTTOM_RIGHT_CANTALON);
    }

    public static ________ getInstance() {
        if (instance == null) {
            instance = new Components();
        }
        return instance;
    }

}
