package org.usfirst.frc.team4669.robot;

import org.usfirst.frc.team4669.robot.commands.RotateLeft;
import org.usfirst.frc.team4669.robot.commands.RotateRight;
import org.usfirst.frc.team4669.robot.commands.Shoot;
import org.usfirst.frc.team4669.robot.commands.TiltShooterDown;
import org.usfirst.frc.team4669.robot.commands.AlignToGoal;
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
public class OISNES {
	//Add joysticks
    private Joystick snesControl = new Joystick(0);
    
	public OISNES() {

		JoystickButton buttonL = new JoystickButton(snesControl, 7);
		JoystickButton buttonR = new JoystickButton(snesControl, 8);
		JoystickButton buttonX = new JoystickButton(snesControl, 1);
		JoystickButton buttonY = new JoystickButton(snesControl, 4);
		JoystickButton buttonA = new JoystickButton(snesControl, 2);
		JoystickButton buttonB = new JoystickButton(snesControl, 3);
		JoystickButton buttonSelect = new JoystickButton(snesControl, 9);
		JoystickButton buttonStart = new JoystickButton(snesControl, 10);
		
		buttonL.whileHeld(new RotateLeft());
		buttonR.whileHeld(new RotateRight());
		buttonX.whileHeld(new TiltShooterUp());
		buttonY.whileHeld(new TiltShooterDown());
		buttonA.whenPressed(new Shoot());
		buttonB.whenPressed(new Intake());
		buttonSelect.whenPressed(new CalibrateIMU());
		buttonStart.whenPressed(new AlignToGoal());
		
    	//SmartDashboard commands
    	
    	SmartDashboard.putData("Shoot", new Shoot());
    	SmartDashboard.putData("Intake", new Intake());

    	SmartDashboard.putData("TiltShooterUp", new TiltShooterUp());
    	SmartDashboard.putData("TiltShooterDown", new TiltShooterDown());
    	
    	//IMU calibrate
    	SmartDashboard.putData("IMU Calibrate", new CalibrateIMU());
    	
    	//SmartDashboard.putData("Set Shooter Angle", new SetShooterAngle());
    	
    	SmartDashboard.putData("Zero Shooter Encoder", new ZeroEncoderShooter());
    	SmartDashboard.putData("Zero DriveTrain Encoder", new ZeroEncoderDriveTrain());
    }
    
    public double getY() {
    	return snesControl.getY();
    }
    
    public double getX() {
    	return snesControl.getX();
    }
    
    public boolean getDPadLeft() {
    	return snesControl.getX() < 0.0;
    }
    
    public boolean getDPadRight() {
    	return snesControl.getX() > 0.0;
    }
    
    public boolean getDPadUp() {
    	return snesControl.getY() < 0.0;
    }
    
    public boolean getDPadDown() {
    	return snesControl.getY() > 0.0;
    }
    
}
