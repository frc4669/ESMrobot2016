
package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.subsystems.DriveTrain;

/**
 *
 */
public class TurnToGoal extends Command {
	
	private DriveTrain driveTrain;
	private double degreesToTurn;
	private double distanceToTravel;

	public TurnToGoal() {
        driveTrain = Robot.driveTrain;
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.zeroEncoders();
    	double distance = -0.15*Robot.visionTable.getNumber("w", 130)+28.5;
    	double degree = Math.atan((Robot.visionTable.getNumber("x", 320)-320)/distance);
    	degreesToTurn = degree*(RobotMap.wheelBase*Math.PI/360); //16.5 distance between wheels
    	distanceToTravel = degreesToTurn / RobotMap.encoderCountConstant;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if degree is positive, robot will turn clockwise, else if negative, robot turns counterclockwise
    	if (degreesToTurn > 0) {
    		driveTrain.setArcadeDrive(0, -RobotMap.driveTrainSpeedProportion);
    	}
    	else if (degreesToTurn < 0) {
    		driveTrain.setArcadeDrive(0, RobotMap.driveTrainSpeedProportion);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (degreesToTurn > 0) {
    		return driveTrain.getLeftEncoder() > distanceToTravel || driveTrain.getRightEncoder() < -distanceToTravel;
    	}
    	else if (degreesToTurn < 0) {
    		return driveTrain.getLeftEncoder() < distanceToTravel ||driveTrain.getRightEncoder() > -distanceToTravel;
    	}
    	else {
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.stopMotors();
    	driveTrain.zeroEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
