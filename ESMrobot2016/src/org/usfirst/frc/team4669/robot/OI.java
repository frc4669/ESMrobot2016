package org.usfirst.frc.team4669.robot;

import org.usfirst.frc.team4669.robot.commands.MoveSixInches;
import org.usfirst.frc.team4669.robot.commands.Shoot;
import org.usfirst.frc.team4669.robot.commands.TiltShooterDown;
import org.usfirst.frc.team4669.robot.commands.CalibrateIMU;
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
    private Joystick leftStick = new Joystick(RobotMap.leftJoy);
    private Joystick rightStick = new Joystick(RobotMap.rightJoy);
    
	public OI() {
    	//Variables for joystick buttons
    	JoystickButton left3 = new JoystickButton(leftStick, 3); //TiltUp
    	JoystickButton left2 = new JoystickButton(leftStick, 2); //TiltDown
    	JoystickButton right3 = new JoystickButton(rightStick, 3); //Shoot
    	JoystickButton right2 = new JoystickButton(rightStick, 2); //SuckItUp
    	
    	JoystickButton leftTrigger = new JoystickButton(leftStick, 1);
    	JoystickButton rightTrigger = new JoystickButton(rightStick, 1);
    	
    	//Button commands
    	//leftTrigger.whenPressed(new ZeroEncoder());
    	right3.whenPressed(new Shoot());
    	right2.whenPressed(new Intake());
    	
    	//SmartDashboard commands
    	SmartDashboard.putData("Shoot", new Shoot());
    	SmartDashboard.putData("Intake", new Intake());
    	SmartDashboard.putData("TiltShooterUp", new TiltShooterUp());
    	SmartDashboard.putData("TiltShooterDown", new TiltShooterDown());
    	
    	//IMU calibrate
    	SmartDashboard.putData("IMU Calibrate", new CalibrateIMU());
    }
    
    public double getLeftY() {
    	return leftStick.getY();
    }
    
    public double getRightY() {
    	return rightStick.getY();
    }
}

