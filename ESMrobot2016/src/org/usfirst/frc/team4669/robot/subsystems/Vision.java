
package org.usfirst.frc.team4669.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Relay lightRelay;
	
	public Vision() {
		super();
		lightRelay = new Relay(0);
	}
	
	public void turnOnLight() {
		lightRelay.set(Relay.Value.kForward);
	}
	
	public void turnOffLight() {
		lightRelay.set(Relay.Value.kOff);
	}
	
	public void getImage() {
		
	}
	
	public void getDifference() {
		
	}
	
	public void getGrayscale() {
		
	}
	
	public void threshold() {
		
	}
	
	public void getContours() {
		
	}
	
	public void getMaxContour() {
		
	}
	
	public void getConvexHull() {
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

