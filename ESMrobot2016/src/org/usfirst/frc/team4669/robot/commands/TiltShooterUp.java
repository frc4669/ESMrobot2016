
package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.subsystems.Shooter;

/**
 *
 */
public class TiltShooterUp extends Command {
	
	private Shooter shooter;

    public TiltShooterUp() {
    	shooter = Robot.shooter;
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	shooter.enableLimitSwitch();
    }
   
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shooter.setTiltMotorSpeed(RobotMap.shooterTiltSpeedProportion);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (shooter.getLimitSwitchClosed()) {
    		return true;
    	}
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	shooter.setTiltMotorSpeed(0);
    	if (shooter.getLimitSwitchClosed()) {
    		shooter.zeroTiltEncoder();
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
