package org.usfirst.frc.team4669.robot;

import org.usfirst.frc.team4669.robot.commands.Shoot;
import org.usfirst.frc.team4669.robot.commands.TiltShooterDown;
import org.usfirst.frc.team4669.robot.commands.TiltShooterFloor;
import org.usfirst.frc.team4669.robot.commands.TiltShooterPID;
import org.usfirst.frc.team4669.robot.commands.TiltShooterStart;
import org.usfirst.frc.team4669.robot.commands.CalibrateIMU;
import org.usfirst.frc.team4669.robot.commands.GetVisionValues;
import org.usfirst.frc.team4669.robot.commands.Intake;
import org.usfirst.frc.team4669.robot.commands.TiltShooterUp;
import org.usfirst.frc.team4669.robot.commands.Turn;
import org.usfirst.frc.team4669.robot.commands.TurnOffLight;
import org.usfirst.frc.team4669.robot.commands.TurnOnLight;
import org.usfirst.frc.team4669.robot.commands.ZeroEncoderDriveTrain;
import org.usfirst.frc.team4669.robot.commands.ZeroEncoderShooter;

import edu.wpi.first.wpilibj.Joystick;
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
    private Joystick shooterStick = new Joystick(RobotMap.armJoy);
    
	public OI() {
    	//Variables for joystick buttons
    	JoystickButton shooter1 = new JoystickButton(shooterStick, 1); //trigger
    	JoystickButton shooter2 = new JoystickButton(shooterStick, 2); //side button
    	JoystickButton right1 = new JoystickButton(rightStick, 1); //RIGHT 1
    	JoystickButton right2 = new JoystickButton(rightStick, 2); //RIGHT 2 
    	JoystickButton right4 = new JoystickButton(leftStick, 4); //RIGHT 4
    	JoystickButton left3 = new JoystickButton(leftStick, 3); //LEFT 3
    	JoystickButton left2 = new JoystickButton(leftStick, 2); //LEFT 2
    	JoystickButton left5 = new JoystickButton(leftStick, 5); //LEFT 5
    	
    	shooter1.whileHeld(new Intake());
    	shooter2.whenPressed(new Shoot());
    	right1.whileHeld(new Intake());
    	right2.whenPressed(new Shoot());
    	
    	left3.whileHeld(new TiltShooterDown());
    	left2.whileHeld(new TiltShooterUp());
    	
    	left5.whenPressed(new Turn(180));
    	right4.whenPressed(new Turn(180));
    	
    	
    	//SmartDashboard commands
    	SmartDashboard.putData("GetVisionValues", new GetVisionValues());
    	SmartDashboard.putData("TurnOnLight", new TurnOnLight());
    	SmartDashboard.putData("TurnOffLight", new TurnOffLight());
    	
    	SmartDashboard.putData("TiltShooterPID", new TiltShooterPID());
    	
    	SmartDashboard.putData("Shoot", new Shoot());
    	SmartDashboard.putData("Intake", new Intake());
    	
    	SmartDashboard.putData("TiltShooterUp", new TiltShooterUp());
    	SmartDashboard.putData("TiltShooterDown", new TiltShooterDown());
    	SmartDashboard.putData("TiltShooterStart", new TiltShooterStart());
    	SmartDashboard.putData("TiltShooterFloor", new TiltShooterFloor());
    	
    	//IMU calibrate
    	SmartDashboard.putData("IMU Zero Reading", new CalibrateIMU());
    	
    	SmartDashboard.putData("Zero Shooter Encoder", new ZeroEncoderShooter());
    	SmartDashboard.putData("Zero DriveTrain Encoder", new ZeroEncoderDriveTrain());
    	
//    	SmartDashboard.putData("Turn Degrees", new Turn(degree));
//    	SmartDashboard.putData("Turn Clockwise Degrees", new TurnClockwise(degree));
    }
    
    public double getLeftY() {
    	return leftStick.getY();
    }
    
    public double getRightY() {
    	return rightStick.getY();
    }
    
    public double getShooterY() {
    	return shooterStick.getY();
    }
}

