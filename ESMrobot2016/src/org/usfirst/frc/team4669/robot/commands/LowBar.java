package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBar extends CommandGroup{
	public LowBar() {
		addSequential(new TiltShooter(-170));
		addSequential(new MoveForwardInches(30));
		addSequential(new Turn(45));
		addSequential(new TiltShooter(90));
		addSequential(new Shoot());
	}
}
