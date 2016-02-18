
package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.subsystems.DriveTrain;

/**
 *
 */
public class TurnAroundLeft extends Command {
	
	private static final double distanceToTurnAround = 0;
	private DriveTrain driveTrain = Robot.driveTrain;
	private double distanceToTravel = distanceToTurnAround / RobotMap.encoderCountConstant;

    public TurnAroundLeft() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.zeroEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.setMotors(-1, 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return driveTrain.getLeftEncoder() < -800;
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
