package org.usfirst.frc.team4669.robot;

import org.usfirst.frc.team4669.robot.commands.Intake;
import org.usfirst.frc.team4669.robot.commands.Shoot;
import org.usfirst.frc.team4669.robot.commands.TiltDown;
import org.usfirst.frc.team4669.robot.commands.TiltShooterLowBar;
import org.usfirst.frc.team4669.robot.commands.TiltToFloor;
import org.usfirst.frc.team4669.robot.commands.TiltToStart;
import org.usfirst.frc.team4669.robot.commands.TiltUp;
import org.usfirst.frc.team4669.robot.commands.Turn;
import org.usfirst.frc.team4669.robot.commands.TurnToDegree;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OIXbox {
	
    private Joystick xboxControl = new Joystick(RobotMap.xbox);
    
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
		
		buttonLB.whileHeld(new TiltDown());
		buttonRB.whileHeld(new TiltUp());
		buttonX.whenPressed(new TiltShooterLowBar());
		buttonY.whenPressed(new TiltToStart());
		buttonA.whenPressed(new TurnToDegree(180));
		buttonB.whenPressed(new TiltToFloor());
		buttonStart.whenPressed(new TurnToDegree(0));
		buttonBack.whenPressed(new Turn(45));
		buttonLeftJoy.whileHeld(new Intake());
		buttonRightJoy.whenPressed(new Shoot());
		
    }
	
	public int getPOV() {
		//DPad
		return xboxControl.getPOV();
	}
	
//	public double getTriggers() {
//		//0 to 1, right - left
//		return xboxControl.getRawAxis(3);
//	}
	
	public double getLeftTrigger() {
		return xboxControl.getRawAxis(2);
	}
	
	public double getRightTrigger() {
		return xboxControl.getRawAxis(3);
	}
    
	public double getLeftY() {
		double leftY = xboxControl.getRawAxis(1); //2?
		if (Math.abs(leftY) > 0.2) {
			return leftY; 
		}
		else {
			return 0;
		}
    }
    
    public double getLeftX() {
    	double leftX = xboxControl.getRawAxis(0); //1?
    	if (Math.abs(leftX) > 0.2) {
			return leftX; 
		}
		else {
			return 0;
		}
    }
    
    public double getRightY() {
		double rightY = xboxControl.getRawAxis(5);
		if (Math.abs(rightY) > 0.2) {
			return rightY; 
		}
		else {
			return 0;
		}
    }
    
    public double getRightX() {
    	double rightX = xboxControl.getRawAxis(4);
    	if (Math.abs(rightX) > 0.2) {
			return rightX; 
		}
		else {
			return 0;
		}
    }
    
}

