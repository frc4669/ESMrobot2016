package org.usfirst.frc.team4669.robot;

import org.usfirst.frc.team4669.robot.commands.Shoot;
import org.usfirst.frc.team4669.robot.commands.TiltShooterDown;
import org.usfirst.frc.team4669.robot.commands.AlignToGoal;
import org.usfirst.frc.team4669.robot.commands.CalibrateIMU;
import org.usfirst.frc.team4669.robot.commands.Intake;
import org.usfirst.frc.team4669.robot.commands.TiltShooterUp;
import org.usfirst.frc.team4669.robot.commands.Turn;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OISNES {
	
    private Joystick snesControl = new Joystick(RobotMap.snes1);
    private Joystick snesControl2 = new Joystick(RobotMap.snes2);
    
	public OISNES() {

		JoystickButton buttonL = new JoystickButton(snesControl, 7);
		JoystickButton buttonR = new JoystickButton(snesControl, 8);
		JoystickButton buttonX = new JoystickButton(snesControl, 1);
		JoystickButton buttonY = new JoystickButton(snesControl, 4);
		JoystickButton buttonA = new JoystickButton(snesControl, 2);
		JoystickButton buttonB = new JoystickButton(snesControl, 3);
		JoystickButton buttonSelect = new JoystickButton(snesControl, 9);
		JoystickButton buttonStart = new JoystickButton(snesControl, 10);
		
		buttonL.whileHeld(new Turn(-45));
		buttonR.whileHeld(new Turn(45));
		buttonX.whileHeld(new TiltShooterUp());
		buttonY.whileHeld(new TiltShooterDown());
		buttonA.whenPressed(new Shoot());
		buttonB.whileHeld(new Intake());
		buttonSelect.whenPressed(new CalibrateIMU());
		buttonStart.whenPressed(new AlignToGoal());
		
		JoystickButton buttonL2 = new JoystickButton(snesControl2, 7);
		JoystickButton buttonR2 = new JoystickButton(snesControl2, 8);
		JoystickButton buttonX2 = new JoystickButton(snesControl2, 1);
		JoystickButton buttonY2 = new JoystickButton(snesControl2, 4);
		JoystickButton buttonA2 = new JoystickButton(snesControl2, 2);
		JoystickButton buttonB2 = new JoystickButton(snesControl2, 3);
		JoystickButton buttonSelect2 = new JoystickButton(snesControl2, 9);
		JoystickButton buttonStart2 = new JoystickButton(snesControl2, 10);
		
		buttonL2.whileHeld(new Turn(-45));
		buttonR2.whileHeld(new Turn(45));
		buttonX2.whileHeld(new TiltShooterUp());
		buttonY2.whileHeld(new TiltShooterDown());
		buttonA2.whenPressed(new Shoot());
		buttonB2.whileHeld(new Intake());
		buttonSelect2.whenPressed(new CalibrateIMU());
		buttonStart2.whenPressed(new AlignToGoal());
		
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
    
    public double getY2() {
    	return snesControl2.getY();
    }
    
    public double getX2() {
    	return snesControl2.getX();
    }
    
    public boolean getDPadLeft2() {
    	return snesControl2.getX() < 0.0;
    }
    
    public boolean getDPadRight2() {
    	return snesControl2.getX() > 0.0;
    }
    
    public boolean getDPadUp2() {
    	return snesControl2.getY() < 0.0;
    }
    
    public boolean getDPadDown2() {
    	return snesControl2.getY() > 0.0;
    }
}

