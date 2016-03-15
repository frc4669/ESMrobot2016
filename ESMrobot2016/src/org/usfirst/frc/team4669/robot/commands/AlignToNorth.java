
package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4669.robot.subsystems.IMUSubsystem;

/**
 *
 */
public class AlignToNorth extends Command {

	private DriveTrain driveTrain;
	private IMUSubsystem imu;
	
    public AlignToNorth() {
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
    	if (imu.getAngle() - imu.getNorth() > 180) {
    		driveTrain.setMotors(0.6, -0.6);
    	}
    	else if (imu.getAngle() - imu.getNorth() <= 180) {
    		driveTrain.setMotors(-0.6, 0.6);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double angle = imu.getAngle();
    	double north = imu.getNorth();
        return angle<north+2 && angle>north-2;
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
