package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveForwardInches extends Command {
	
	private DriveTrain driveTrain;
	private double distanceToTravel;
	private boolean end;

    public MoveForwardInches(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveTrain = Robot.driveTrain;
    	distanceToTravel = distance / RobotMap.encoderCountConstant;
    	end = false;
    	requires(driveTrain);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.zeroEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	end = distanceToTravel < driveTrain.getLeftEncoder();
    	driveTrain.setMotors(-1, -1);

    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return distanceToTravel < driveTrain.getLeftEncoder();
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
