package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChevalDeFrise extends CommandGroup{
	public ChevalDeFrise() {
		addSequential(new MoveForwardNorth(RobotMap.autoToCheval));
		addSequential(new TiltShooter(RobotMap.chevalTilt));
		addSequential(new MoveForwardNorth(RobotMap.chevalDistance));
		addSequential(new AlignToNorth());
	}
}
