package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBar extends CommandGroup{
	public LowBar() {
		addSequential(new TiltShooterFloor());
		addSequential(new MoveForwardInches(100));
	}
}
