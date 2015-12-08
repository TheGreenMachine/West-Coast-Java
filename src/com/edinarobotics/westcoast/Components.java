package com.edinarobotics.westcoast;

import com.edinarobotics.westcoast.subsystems.Drivetrain;

public class Components {

    private static Components instance;

    public Drivetrain drivetrain;

    private final int TOP_LEFT_CANTALON = 2;
    private final int TOP_RIGHT_CANTALON = 3;
    private final int BOTTOM_LEFT_CANTALON = 4;
    private final int BOTTOM_RIGHT_CANTALON = 5;

    private Components() {
        drivetrain = new Drivetrain(TOP_LEFT_CANTALON, BOTTOM_LEFT_CANTALON, TOP_RIGHT_CANTALON, BOTTOM_RIGHT_CANTALON);
    }

    public static Components getInstance() {
        if (instance == null) {
            instance = new Components();
        }
        return instance;
    }

}
