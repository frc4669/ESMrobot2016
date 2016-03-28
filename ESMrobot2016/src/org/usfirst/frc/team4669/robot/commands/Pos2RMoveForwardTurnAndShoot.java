package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

//NEXT TO THE LOW BAR close to the middle
public class Pos2RMoveForwardTurnAndShoot extends CommandGroup{
	public Pos2RMoveForwardTurnAndShoot(){
		addSequential(new TiltShooter(RobotMap.p2RShoot));
		addSequential(new Turn(RobotMap.p2RTurn));
		addSequential(new MoveForwardInches(RobotMap.p2RDistance));	
		addSequential(new Turn(-RobotMap.p2RTurn));
		addSequential(new TiltShooter(RobotMap.p2RShoot));
//		addSequential(new AlignToGoal());
		addSequential(new Shoot());
	}
}
