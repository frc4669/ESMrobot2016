
package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4669.robot.OI;
import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.subsystems.Shooter;

/**
 *
 */
public class TiltShooterWithJoystick extends Command {
	
	private Shooter shooter;
	private OI oi = Robot.oi;

    public TiltShooterWithJoystick() {
    	shooter = Robot.shooter;
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shooter.enableLimitSwitch();
    	if (!shooter.getLimitSwitchClosed()) {
    		shooter.setTiltMotorSpeed(RobotMap.shooterTiltSpeedProportion*oi.getShooterY());
    	}
    	else if (shooter.getLimitSwitchClosed() && oi.getShooterY() > 0.0) {
    		shooter.setTiltMotorSpeed(0);
    		shooter.zeroTiltEncoder();
    	}
    	else {
    		shooter.disableLimitSwitch();
    		shooter.setTiltMotorSpeed(RobotMap.shooterTiltSpeedProportion*oi.getShooterY());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	shooter.setTiltMotorSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
