package org.usfirst.frc.team4669.robot;

import org.usfirst.frc.team4669.robot.commands.Shoot;
import org.usfirst.frc.team4669.robot.commands.TiltShooterLowBar;
import org.usfirst.frc.team4669.robot.commands.TiltDown;
import org.usfirst.frc.team4669.robot.commands.TiltToFloor;
import org.usfirst.frc.team4669.robot.commands.TiltToHighGoal;
import org.usfirst.frc.team4669.robot.commands.TiltToLowGoal;
import org.usfirst.frc.team4669.robot.commands.TiltAtBatter;
import org.usfirst.frc.team4669.robot.commands.TiltToStart;
import org.usfirst.frc.team4669.robot.commands.AlignToGoal;
import org.usfirst.frc.team4669.robot.commands.AlignToNorth;
import org.usfirst.frc.team4669.robot.commands.CalibrateIMU;
import org.usfirst.frc.team4669.robot.commands.GetVisionValues;
import org.usfirst.frc.team4669.robot.commands.Intake;
import org.usfirst.frc.team4669.robot.commands.MoveForwardUntilLevel;
import org.usfirst.frc.team4669.robot.commands.TiltUp;
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
    	JoystickButton shooter2 = new JoystickButton(shooterStick, 2);
    	JoystickButton shooter3 = new JoystickButton(shooterStick, 3);
    	JoystickButton shooter4 = new JoystickButton(shooterStick, 4);
    	JoystickButton shooter5 = new JoystickButton(shooterStick, 5);
    	JoystickButton shooter6 = new JoystickButton(shooterStick, 6);
    	JoystickButton shooter7 = new JoystickButton(shooterStick, 7);
    	JoystickButton shooter8 = new JoystickButton(shooterStick, 8);
    	JoystickButton shooter9 = new JoystickButton(shooterStick, 9);
    	JoystickButton shooter10 = new JoystickButton(shooterStick, 10);
    	JoystickButton shooter11 = new JoystickButton(shooterStick, 11);
//    	JoystickButton right1 = new JoystickButton(rightStick, 1); //RIGHT 1
//    	JoystickButton right2 = new JoystickButton(rightStick, 2); //RIGHT 2 
//    	JoystickButton right4 = new JoystickButton(leftStick, 4); //RIGHT 4
//    	JoystickButton left3 = new JoystickButton(leftStick, 3); //LEFT 3
//    	JoystickButton left2 = new JoystickButton(leftStick, 2); //LEFT 2
//    	JoystickButton left5 = new JoystickButton(leftStick, 5); //LEFT 5
    	
    	shooter1.whileHeld(new Intake());
    	shooter2.whenPressed(new TiltToStart());
    	shooter3.whenPressed(new TiltToFloor());
    	shooter4.whenPressed(new Turn(-5));
    	shooter5.whenPressed(new Turn(5));
    	shooter6.whenPressed(new Shoot());
    	shooter7.whenPressed(new AlignToGoal());
    	shooter8.whenPressed(new TiltAtBatter());
    	shooter9.whenPressed(new TiltShooterLowBar());
    	shooter10.whenPressed(new TiltToLowGoal());
    	shooter11.whenPressed(new TiltToHighGoal());
    	
//    	right1.whileHeld(new Intake());
//    	right2.whenPressed(new Shoot());
//    	
//    	left3.whileHeld(new TiltShooterDown());
//    	left2.whileHeld(new TiltShooterUp());
//    	
//    	left5.whenPressed(new Turn(180));
//    	right4.whenPressed(new Turn(180));
    	
    	
    	//SmartDashboard commands
    	SmartDashboard.putData("GetVisionValues", new GetVisionValues());
    	SmartDashboard.putData("TurnOnLight", new TurnOnLight());
    	SmartDashboard.putData("TurnOffLight", new TurnOffLight());
    	
    	SmartDashboard.putData("Shoot", new Shoot());
    	SmartDashboard.putData("Intake", new Intake());
    	
    	SmartDashboard.putData("TiltUp", new TiltUp());
    	SmartDashboard.putData("TiltDown", new TiltDown());
    	SmartDashboard.putData("TiltToStart", new TiltToStart());
    	SmartDashboard.putData("TiltToFloor", new TiltToFloor());
    	SmartDashboard.putData("TiltToBaseAngle", new TiltAtBatter());
    	
    	//IMU calibrate
    	SmartDashboard.putData("IMU Zero Reading", new CalibrateIMU());
    	
    	SmartDashboard.putData("Zero Shooter Encoder", new ZeroEncoderShooter());
    	SmartDashboard.putData("Zero DriveTrain Encoder", new ZeroEncoderDriveTrain());
    	
    	SmartDashboard.putData("AlignToNorth", new AlignToNorth());
    	SmartDashboard.putData("MoveForwardUntilLevel", new MoveForwardUntilLevel());
    	
    }
    
    public double getLeftY() {
    	return leftStick.getY();
    }
    
    public double getRightY() {
    	return rightStick.getY();
    }
    
    public double getShooterY() {
    	double y = shooterStick.getY();
		if (Math.abs(y) > 0.2) {
			return y; 
		}
		else {
			return 0;
		}
    }
    
}

