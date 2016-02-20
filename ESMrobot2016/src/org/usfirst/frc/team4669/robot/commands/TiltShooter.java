package org.usfirst.frc.team4669.robot.commands;


import org.usfirst.frc.team4669.robot.Robot;

import com.sun.xml.internal.fastinfoset.Encoder;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TiltShooter extends Command {
	private double encoderValueToTurn = 0;
	private double EncoderValueForOneRevolution = 0;
	
    public TiltShooter(double degree) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	encoderValueToTurn = degree*(EncoderValueForOneRevolution);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.shooter.getTiltEncoder() > (encoderValueToTurn)) {
    		Robot.shooter.setTiltMotorSpeed(-1.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shooter.getTiltEncoder() <= (encoderValueToTurn);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.setTiltMotorSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}