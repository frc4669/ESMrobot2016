package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.RobotMap;

//NEXT TO THE LOW BAR close to the low bar
public class Pos2LMoveForwardTurnAndShoot extends MoveForwardTurnAndShoot{
	public Pos2LMoveForwardTurnAndShoot(){
		super(RobotMap.p2LDistance, RobotMap.p2LTurn, RobotMap.p2LShoot);
	}
}
