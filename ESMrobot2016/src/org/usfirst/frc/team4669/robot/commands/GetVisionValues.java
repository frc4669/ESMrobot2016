package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.subsystems.LightRelay;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class GetVisionValues extends Command {

	private LightRelay lightRelay;
	private NetworkTable visionTable;
	private boolean getValuesDone;
	
    public GetVisionValues() {
    	lightRelay = Robot.lightRelay;
    	visionTable = Robot.visionTable;
    	getValuesDone = false;
        // Use requires() here to declare subsystem dependencies
        requires(lightRelay);
        setRunVision(true);
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (getRunVision()) {
    		if (getLightOn() && !getLightOnDone()) {
    			lightRelay.turnOnLight();
    			setLightOnDone(true);
    		}
    		else if (getLightOnDone() && !getLightOn()) {
    			lightRelay.turnOffLight();
    			setLightOnDone(false);
    		}
    	}
    	else if (!getRunVision()) {
    		getValuesOnVisionTable();
    		getValuesDone = true;
    	}
    }
    
    
    private void getValuesOnVisionTable() {
		// TODO Auto-generated method stub
		
	}

	private void setRunVision(boolean b) {
		visionTable.putBoolean("runVision", b);
	}
    
    private boolean getRunVision() {
		return visionTable.getBoolean("runVision", false);
	}

    private void setLightOnDone(boolean b) {
		visionTable.putBoolean("lightOnDone", b);
	}

	private boolean getLightOnDone() {
		return visionTable.getBoolean("lightOnDone", false);
	}

	private boolean getLightOn() {
		return visionTable.getBoolean("lightOn", false);
	}
	

	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getValuesDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
