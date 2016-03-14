package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4669.robot.subsystems.IMUSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveForwardUntilLevel extends Command {
	
	private DriveTrain driveTrain;
	private IMUSubsystem imu;

    public MoveForwardUntilLevel() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveTrain = Robot.driveTrain;
    	imu = Robot.imu;
    	requires(driveTrain);
    	requires(imu);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.setMotors(1, 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return imu.isLevel();
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
