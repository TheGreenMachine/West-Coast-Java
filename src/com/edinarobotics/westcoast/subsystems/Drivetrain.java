package com.edinarobotics.westcoast.subsystems;

import com.edinarobotics.utils.subsystems.Subsystem1816;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

public class Drivetrain extends Subsystem1816 {

    private CANTalon topLeft, topRight, bottomLeft, bottomRight;
    private double leftStick, rightStick;

    private RobotDrive robotDrive;

    public Drivetrain(int topLeft, int bottomLeft, int topRight, int bottomRight) {
        this.topLeft = new CANTalon(topLeft);
        this.topRight = new CANTalon(topRight);
        this.bottomLeft = new CANTalon(bottomLeft);
        this.bottomRight = new CANTalon(bottomRight);

        robotDrive = new RobotDrive(this.topLeft, this.bottomLeft, this.topRight, this.bottomRight);
    }

    @Override
    public void update() {
        robotDrive.tankDrive(leftStick, rightStick);
    }

    public void setDefaultCommand(Command command){
        if(getDefaultCommand() != null){
            super.getDefaultCommand().cancel();
        }
        super.setDefaultCommand(command);
    }

    public void setLeftStick(double leftStick) {
        this.leftStick = leftStick;
        update();
    }

    public void setRightStick(double rightStick) {
        this.rightStick = rightStick;
        update();
    }
}