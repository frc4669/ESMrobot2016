package org.usfirst.frc.team4669.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LightRelay extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Relay lightRelay;
	
	public LightRelay() {
		super();
		lightRelay = new Relay(0);
	}
	
	public void turnOnLight() {
		lightRelay.set(Relay.Value.kForward);
	}
	
	public void turnOffLight() {
		lightRelay.set(Relay.Value.kOff);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
