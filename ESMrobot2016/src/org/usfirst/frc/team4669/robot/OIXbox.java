package org.usfirst.frc.team4669.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OIXbox {
	//Add joysticks
    private Joystick xboxControl = new Joystick(5);
    
	public OIXbox() {

		JoystickButton buttonLB = new JoystickButton(xboxControl, 5);
		JoystickButton buttonRB = new JoystickButton(xboxControl, 6);
		JoystickButton buttonX = new JoystickButton(xboxControl, 3);
		JoystickButton buttonY = new JoystickButton(xboxControl, 4);
		JoystickButton buttonA = new JoystickButton(xboxControl, 1);
		JoystickButton buttonB = new JoystickButton(xboxControl, 2);
		JoystickButton buttonBack = new JoystickButton(xboxControl, 7);
		JoystickButton buttonStart = new JoystickButton(xboxControl, 8);
		JoystickButton buttonLeftJoy = new JoystickButton(xboxControl, 9);
		JoystickButton buttonRightJoy = new JoystickButton(xboxControl, 10);
		
    }
	
	public int getPOV() {
		return xboxControl.getPOV();
	}
	
	public double getTriggers() {
		return xboxControl.getRawAxis(3);
	}
    
    public double getLeftY() {
		return xboxControl.getRawAxis(2);
    }
    
    public double getLeftX() {
    	return xboxControl.getRawAxis(1);
    }
    
    public double getRightY() {
		return xboxControl.getRawAxis(5);
    }
    
    public double getRightX() {
    	return xboxControl.getRawAxis(4);
    }
    
}

