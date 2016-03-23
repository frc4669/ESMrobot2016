
package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4669.robot.subsystems.IMUSubsystem;

/**
 *
 */
public class TurnToDegree extends Command {
	
	private DriveTrain driveTrain;
	private IMUSubsystem imu;
	private double degreesToTurn;
	private double distanceToTravel;
	private double degree;
	private boolean rotateLeft = false;
	private boolean rotateRight = false;

	public TurnToDegree(double degree) {
        driveTrain = Robot.driveTrain;
        imu = Robot.imuSubsystem;
        this.degree = degree;
    	requires(driveTrain);
    	requires(imu);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	degreesToTurn =  (imu.getAngle() - degree -180)*(RobotMap.wheelBase*Math.PI/360); //16.5 distance between wheels
    	distanceToTravel = degreesToTurn / RobotMap.encoderCountConstant;
        driveTrain.zeroEncoders();
        if (Math.abs(imu.getAngle() -degree) > 180) {
    		rotateRight = true;
    		rotateLeft = false;
    	}
    	else if (Math.abs(imu.getAngle() -degree) <= 180) {
    		rotateLeft = true;
    		rotateRight = false;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (rotateRight) {
    		driveTrain.setArcadeDrive(0, -RobotMap.driveTrainSpeedProportion);
    	}
    	else if (rotateLeft) {
    		driveTrain.setArcadeDrive(0, RobotMap.driveTrainSpeedProportion);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	if (degreesToTurn > 0) {
//    		return driveTrain.getLeftEncoder() > distanceToTravel;
//    	}
//    	else if (degreesToTurn < 0) {
//    		return driveTrain.getRightEncoder() > -distanceToTravel;
//    	}
//    	else {
//    		return true;
//    	}

    	double angle = imu.getAngle();
        return angle<degree+5 && angle>degree-5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.stopMotors();
    	driveTrain.zeroEncoders();
    	rotateLeft = false;
    	rotateRight = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
