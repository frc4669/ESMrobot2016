
package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.subsystems.Shooter;

/**
 *
 */
public class Shoot extends Command {
	
	private Shooter shooter;
	private Timer timer;
	
    public Shoot() {
    	shooter = Robot.shooter;
    	timer = new Timer();
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shooter.setLeftShooterSpeed(1);
    	shooter.setRightShooterSpeed(-1);
    	if (timer.get() > 0.5) {
    		shooter.setServoAngle(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > 1;
    }

    // Called once after isFinished returns true
    protected void end() {
    	timer.stop();
    	shooter.setLeftShooterSpeed(0);
    	shooter.setRightShooterSpeed(0);
    	shooter.setServoAngle(120);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
