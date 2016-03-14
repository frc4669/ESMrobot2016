package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.RobotMap;

//MIDDLE POSITION
public class Pos3MoveForwardTurnAndShoot extends MoveForwardTurnAndShoot{
	public Pos3MoveForwardTurnAndShoot(){
		super(RobotMap.p3Distance, RobotMap.p3Turn, RobotMap.p3Shoot);
	}
}
