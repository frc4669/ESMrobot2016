package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChevalDeFrise extends CommandGroup{
	public ChevalDeFrise() {
		addSequential(new MoveForwardInches(RobotMap.autoToCheval));
		addSequential(new TiltShooter(RobotMap.chevalTilt));
		addSequential(new MoveForwardInches(RobotMap.chevalDistance));
	}

	
	
}
