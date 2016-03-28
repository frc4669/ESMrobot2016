package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardTurnAndShoot extends CommandGroup{
	public MoveForwardTurnAndShoot(double distance, double turn, double shooter){
		addSequential(new TiltToHighGoal());
		addSequential(new MoveForwardInches(distance));	
		addSequential(new Turn(turn));
//		addSequential(new AlignToGoal());
		addSequential(new Shoot());
	}
}
