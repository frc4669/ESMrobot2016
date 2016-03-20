
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
	private boolean done;
	
    public Shoot() {
    	shooter = Robot.shooter;
    	timer = new Timer();
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	timer.start();
    	done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (timer.get()==0) {
    		shooter.setServoAngle(120);
    	}
    	shooter.setShootingRPM(2000);
//    	shooter.setLeftShooterSpeed(1);
//    	shooter.setRightShooterSpeed(-1);
    	if (!done && shooter.getLeftShooterRPM()>=35000) {
    		timer.start();
    		shooter.setServoAngle(0);
    		done = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > 1;
    }

    // Called once after isFinished returns true
    protected void end() {
    	timer.stop();
    	timer.reset();
//    	shooter.setLeftShooterSpeed(0);
//    	shooter.setRightShooterSpeed(0);
    	shooter.setShootingRPM(0);
    	shooter.setServoAngle(90);
    	done = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
