package com.edinarobotics.westcoast.subsystems;

import com.edinarobotics.utils.controllers.SpeedControllerWrapper;
import com.edinarobotics.utils.subsystems.Subsystem1816;
import com.edinarobotics.utils.wheel.Wheel;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

public class Drivetrain extends Subsystem1816 {

	private Wheel topLeft, middleLeft, bottomLeft, topRight, middleRight, bottomRight;
	private SpeedControllerWrapper left, right;

	private double leftStick, rightStick;

	private final double LOW_GEAR = 0.6;
	private boolean lowGear = false;

	public Drivetrain(int topLeft, int middleLeft, int bottomLeft, int topRight, int middleRight, int bottomRight) {

		this.topLeft = new Wheel("Top Left", new CANTalon(topLeft), false);
		this.middleLeft = new Wheel("Middle Left", new CANTalon(middleLeft), false);
		this.bottomLeft = new Wheel("Bottom Left", new CANTalon(bottomLeft), false);
		this.topRight = new Wheel("Top Right", new CANTalon(topRight), false);
		this.middleRight = new Wheel("Middle Right", new CANTalon(middleRight), true);
		this.bottomRight = new Wheel("Bottom Right", new CANTalon(bottomRight), true);

		// To invert a wheel: this.bottomRight.setReversed(true); or change
		// false to true above.

		left = new SpeedControllerWrapper(this.topLeft, this.middleLeft, this.bottomLeft);
		right = new SpeedControllerWrapper(this.topRight, this.middleRight, this.bottomRight);
	}

	@Override
	public void update() {

		if (lowGear) {
			left.set(-leftStick * LOW_GEAR);
			right.set(-rightStick * LOW_GEAR);
		} else {
			left.set(-leftStick);
			right.set(-rightStick);
		}

	}

	public void setDefaultCommand(Command command) {
		if (getDefaultCommand() != null) {
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

	public void setLowGear(boolean lowGear) {
		this.lowGear = lowGear;
		update();
	}

}