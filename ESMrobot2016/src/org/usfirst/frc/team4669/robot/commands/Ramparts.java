package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Ramparts extends CommandGroup{
	public Ramparts() {
		addSequential(new MoveForwardNorthSlow(150));
		addSequential(new AlignToNorth());
	}
}
