package org.usfirst.frc.team4669.robot;

import org.usfirst.frc.team4669.robot.commands.MoveSixInches;
import org.usfirst.frc.team4669.robot.commands.Shoot;
import org.usfirst.frc.team4669.robot.commands.SuckItUp;
import org.usfirst.frc.team4669.robot.commands.ZeroEncoder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private Joystick leftStick = new Joystick(RobotMap.leftJoy);
    private Joystick rightStick = new Joystick(RobotMap.rightJoy);
    
	public OI() {
    	//Variables for joystick buttons
    	JoystickButton leftTrigger = new JoystickButton(leftStick, 1);
    	JoystickButton rightTrigger = new JoystickButton(rightStick, 1);
    	
    	//Button commands
    	//leftTrigger.whenPressed(new ZeroEncoder());
    	//rightTrigger.whenPressed(new MoveSixInches());
    	
    	//SmartDashboard commands
    	SmartDashboard.putData("Shoot", new Shoot());
    	SmartDashboard.putData("SuckItUp", new SuckItUp());
    }
    
    public double getLeftY() {
    	return leftStick.getY();
    }
    
    public double getRightY() {
    	return rightStick.getY();
    }
}

