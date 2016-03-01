package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TiltShooterPID extends Command {
	private double encoderValueToTurn = 0;
	private double encoderValueForOneRevolution = 0;
	private Shooter shooter;
	
    public TiltShooterPID() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	shooter = Robot.shooter;
    	//encoderValueToTurn = degree/360 *(encoderValueForOneRevolution);
    	requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shooter.setTilt(shooter.getTiltPosition()-300);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }
}