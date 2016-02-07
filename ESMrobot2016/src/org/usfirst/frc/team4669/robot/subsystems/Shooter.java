package org.usfirst.frc.team4669.robot.subsystems;

import org.usfirst.frc.team4669.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
	
	private CANTalon rightShooter;
	private CANTalon leftShooter;
	
	public Shooter() {
		// rightShooter setup.
		rightShooter = new CANTalon(RobotMap.rightShooter);
		rightShooter.changeControlMode(TalonControlMode.Speed);
		rightShooter.configEncoderCodesPerRev(1440);
		
		leftShooter = new CANTalon(RobotMap.leftShooter);
		leftShooter.changeControlMode(TalonControlMode.Speed);
		leftShooter.configEncoderCodesPerRev(1440);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public int getRightShooterRPM() {
		rightShooter.getEncVelocity();
	}
	
	public int getLeftShooterRPM() {
		leftShooter.getEncVelocity();
	}
	
	/**
	 * Sets the speed of the motor.
	 * @param speed A number from -1024 to +1024
	 */
	public void setRightShooterSpeed(double speed) {
		rightShooter.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

