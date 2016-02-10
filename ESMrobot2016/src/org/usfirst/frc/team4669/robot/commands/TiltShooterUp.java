package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TiltShooterUp extends Command {
	
	private Shooter shooter;
	private double distanceToTravel;
	private boolean end;

    public TiltShooterUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	distanceToTravel = RobotMap.distanceToTravel / RobotMap.encoderCountConstant;
    	end = false;
    	requires(shooter);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
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
