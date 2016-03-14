package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.RobotMap;

//LOW BAR
public class Pos1MoveForwardTurnAndShoot extends MoveForwardTurnAndShoot{
	public Pos1MoveForwardTurnAndShoot(){
		super(RobotMap.p1Distance, RobotMap.p1Turn, RobotMap.p1Shoot);
	}
}
