package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.RobotMap;

//THREE FROM THE LOW BAR
public class Pos4MoveForwardTurnAndShoot extends MoveForwardTurnAndShoot{
	public Pos4MoveForwardTurnAndShoot(){
		super(RobotMap.p4Distance, RobotMap.p4Turn, RobotMap.p4Shoot);
	}
}
