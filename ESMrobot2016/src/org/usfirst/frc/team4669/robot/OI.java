package org.usfirst.frc.team4669.robot;

import org.usfirst.frc.team4669.robot.commands.Shoot;
import org.usfirst.frc.team4669.robot.commands.TiltShooterDown;
import org.usfirst.frc.team4669.robot.commands.TiltShooterFloor;
import org.usfirst.frc.team4669.robot.commands.TiltShooterStart;
import org.usfirst.frc.team4669.robot.commands.CalibrateIMU;
import org.usfirst.frc.team4669.robot.commands.Intake;
import org.usfirst.frc.team4669.robot.commands.TiltShooterUp;
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
    	
    	//Button commands
    	//left1.whenPressed(new ZeroEncoder());
    	
    	shooter1.whileHeld(new Intake());
    	shooter2.whenPressed(new Shoot());
    	
    	//SmartDashboard commands
    	
    	SmartDashboard.putData("Shoot", new Shoot());
    	SmartDashboard.putData("Intake", new Intake());

    	SmartDashboard.putData("TiltShooterUp", new TiltShooterUp());
    	SmartDashboard.putData("TiltShooterDown", new TiltShooterDown());
    	SmartDashboard.putData("TiltShooterStart", new TiltShooterStart());
    	SmartDashboard.putData("TiltShooterFloor", new TiltShooterFloor());
    	
    	//IMU calibrate
    	SmartDashboard.putData("IMU Calibrate", new CalibrateIMU());
    	
    	
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

