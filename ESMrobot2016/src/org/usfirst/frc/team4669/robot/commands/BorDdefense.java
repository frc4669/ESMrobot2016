package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BorDdefense extends CommandGroup{
	public BorDdefense() {
		addSequential(new MoveForwardNorth(150));
		addSequential(new AlignToNorth());
	}
}
