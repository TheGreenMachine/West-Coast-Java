package com.edinarobotics.westcoast;

import com.edinarobotics.westcoast.commands.GamepadDriveCommand;
import com.edinarobotics.westcoast.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class WestCoast extends IterativeRobot {

	private Drivetrain drivetrain;

	@Override
	public void robotInit() {
		Components.getInstance();
		Controls.getInstance();

		drivetrain = Components.getInstance().drivetrain;
	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		drivetrain.setDefaultCommand(new GamepadDriveCommand(Controls.getInstance().gamepad));
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void disabledInit() {
		stop();
	}

	public void stop() {
		drivetrain.setLeftStick(0.0);
		drivetrain.setRightStick(0.0);
	}
}
