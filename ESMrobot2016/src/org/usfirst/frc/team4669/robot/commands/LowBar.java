package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBar extends CommandGroup{
	public LowBar() {
		addSequential(new TiltShooter(degree));
		addSequential(new MoveForwardInches(distance));
		addSequential(new Turn(degree));
		addSequential(new TiltShooter(degree));
		addSequential(new Shoot());
	}
}
