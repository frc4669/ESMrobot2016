package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.subsystems.LightRelay;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
        // Use requires() here to declare subsystem dependencies
        requires(lightRelay);
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	getValuesDone = false;
    	setRunVision(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	NetworkTable.flush();
    	if (getRunVision()) {
    		if (getLightOn() && !getLightOnDone()) {
    			lightRelay.turnOnLight();
    			if (!lightRelay.getRelayState().equals(Relay.Value.kOff)){
    				setLightOnDone(true);
    			}
    		}
    		else if (getLightOnDone() && !getLightOn()) {
    			lightRelay.turnOffLight();
    			if (lightRelay.getRelayState().equals(Relay.Value.kOff)){
    				setLightOnDone(false);
    			}
    		}
    	}
    	else if (!getRunVision()) {
    		getValuesOnVisionTable();
    		getValuesDone = true;
    	}
    }
    
    
    private void getValuesOnVisionTable() {
		// TODO Auto-generated method stub
		System.out.println("getValuesOnVisionTable");
		SmartDashboard.putNumber("VisionX", visionTable.getNumber("x", 0));
		SmartDashboard.putNumber("VisionY", visionTable.getNumber("y", 0));
		SmartDashboard.putNumber("VisionWidth", visionTable.getNumber("w", 0));
		SmartDashboard.putNumber("VisionHeight", visionTable.getNumber("h", 0));
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
