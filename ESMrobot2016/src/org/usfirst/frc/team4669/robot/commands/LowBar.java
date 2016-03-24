package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBar extends CommandGroup{
	public LowBar() {
		addSequential(new MoveForwardNorth(RobotMap.autoToLowBar));
		addSequential(new TiltShooterLowBar());
		addSequential(new MoveForwardNorth(RobotMap.lowBarDistance));
		addSequential(new MoveForwardUntilLevel());
		addSequential(new AlignToNorth());
	}
}
