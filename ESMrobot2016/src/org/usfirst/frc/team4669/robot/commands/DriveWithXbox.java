package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.OIXbox;
import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithXbox extends Command {
	private DriveTrain driveTrain;
	private OIXbox oixbox;
//	private TurnToDegree  turn = new TurnToDegree(0);
//	private int pov;
	
    public DriveWithXbox() {
    	driveTrain = Robot.driveTrain;
    	oixbox = Robot.oixbox;
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	pov = oixbox.getPOV();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if (oixbox.getPOV() > -1) { //pov used
//    		if (!turn.isRunning() && pov == oixbox.getPOV()) { //no change in POV
//    			driveTrain.setArcadeDrive(oixbox.getRightTrigger()-oixbox.getLeftTrigger(), 0);
//    		}
//    		else if (!turn.isRunning() && pov != oixbox.getPOV()) { //change in POV
//    			pov = oixbox.getPOV();
//    			turn = new TurnToDegree(pov);
//    			turn.start();
//    		}
//    	}
//    	else if (turn.isRunning()) {
//    		turn.end();
//    	}
//    	else { //tank drive
    		driveTrain.setMotors(-oixbox.getLeftY(), -oixbox.getRightY());
//    	}
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
