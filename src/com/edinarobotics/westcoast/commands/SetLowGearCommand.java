package com.edinarobotics.westcoast.commands;

import com.edinarobotics.westcoast.Components;
import com.edinarobotics.westcoast.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class SetLowGearCommand extends Command {

	private Drivetrain drivetrain;
	private boolean lowGear;

	/**
	 * @param lowGear
	 */
	public SetLowGearCommand(boolean lowGear) {
		super("setlowgearcommand");
		this.lowGear = lowGear;
		drivetrain = Components.getInstance().drivetrain;
		requires(drivetrain);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		drivetrain.setLowGear(lowGear);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
