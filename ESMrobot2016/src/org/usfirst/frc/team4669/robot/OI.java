package org.usfirst.frc.team4669.robot;

import org.usfirst.frc.team4669.robot.commands.MoveSixInches;
import org.usfirst.frc.team4669.robot.commands.SetShooterAngle;
import org.usfirst.frc.team4669.robot.commands.Shoot;
import org.usfirst.frc.team4669.robot.commands.TiltShooterDown;
import org.usfirst.frc.team4669.robot.commands.Intake;
import org.usfirst.frc.team4669.robot.commands.TiltShooterUp;
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
	//Add joysticks
    private Joystick leftStick = new Joystick(RobotMap.leftJoy);
    private Joystick rightStick = new Joystick(RobotMap.rightJoy);
    private Joystick armStick = new Joystick(RobotMap.armJoy);
    
	public OI() {
    	//Variables for joystick buttons
		
    	JoystickButton left1 = new JoystickButton(leftStick, 1); //trigger
    	JoystickButton left2 = new JoystickButton(leftStick, 2);
    	JoystickButton left3 = new JoystickButton(leftStick, 3);
    	
    	JoystickButton right1 = new JoystickButton(rightStick, 1); //trigger
    	JoystickButton right2 = new JoystickButton(rightStick, 2);
    	JoystickButton right3 = new JoystickButton(rightStick, 3);
    	
    	JoystickButton arm1 = new JoystickButton(armStick, 1); //trigger
    	JoystickButton arm2 = new JoystickButton(armStick, 2); //side button
    	
    	//Button commands
    			
    	//left1.whenPressed(new ZeroEncoder());
    	arm1.whileHeld(new Intake());
    	arm2.whenPressed(new Shoot());
    	
    	//SmartDashboard commands
    	
    	SmartDashboard.putData("Shoot", new Shoot());
    	SmartDashboard.putData("Intake", new Intake());
    	SmartDashboard.putData("TiltShooterUp", new TiltShooterUp());
    	SmartDashboard.putData("TiltShooterDown", new TiltShooterDown());
    	SmartDashboard.putData("Set Shooter Angle", new SetShooterAngle());
    }
    
    public double getLeftY() {
    	return leftStick.getY();
    }
    
    public double getRightY() {
    	return rightStick.getY();
    }
    
    public double getArmY() {
    	return armStick.getY();
    }
}

