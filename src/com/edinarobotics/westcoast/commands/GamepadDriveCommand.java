package com.edinarobotics.westcoast.commands;

import com.edinarobotics.utils.gamepad.GamepadNew;
import com.edinarobotics.westcoast.Components;
import com.edinarobotics.westcoast.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.command.Command;

public class GamepadDriveCommand extends Command {

    private Drivetrain drivetrain;
    private GamepadNew gamepad;

    public GamepadDriveCommand(GamepadNew gamepad){
        super("gamepaddrivecommand");
        this.gamepad = gamepad;
        drivetrain = Components.getInstance().drivetrain;
        requires(drivetrain);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        double leftStick = gamepad.getLeftJoystick().getY();
        double rightStick = gamepad.getRightJoystick().getY();

        drivetrain.setLeftStick(leftStick);
        drivetrain.setRightStick(rightStick);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }

}
