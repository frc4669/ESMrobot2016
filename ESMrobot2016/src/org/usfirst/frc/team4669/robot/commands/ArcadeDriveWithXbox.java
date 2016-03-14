package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.OIXbox;
import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeDriveWithXbox extends Command {
	private DriveTrain driveTrain;
	private OIXbox oixbox;
    public ArcadeDriveWithXbox() {
    	driveTrain = Robot.driveTrain;
    	oixbox = Robot.oixbox;
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.setArcadeDrive(-oixbox.getLeftY(), -oixbox.getLeftX());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
