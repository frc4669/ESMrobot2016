
package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.subsystems.IMUSubsystem;

/**
 *
 */
public class CalibrateIMU extends Command {
	
	private IMUSubsystem imuSubsystem;

    public CalibrateIMU() {
    	imuSubsystem = Robot.imu;
        // Use requires() here to declare subsystem dependencies
        requires(imuSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	imuSubsystem.calibrate();
    	imuSubsystem.reset();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double north = imuSubsystem.getNorth();
    	double angleZ = imuSubsystem.getAngleZ();
    	return north-angleZ<1 && north-angleZ>-1;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
