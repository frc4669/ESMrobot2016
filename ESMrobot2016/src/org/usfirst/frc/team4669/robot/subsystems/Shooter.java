
package org.usfirst.frc.team4669.robot.subsystems;

import org.usfirst.frc.team4669.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
	private CANTalon rightShooter;
	private CANTalon leftShooter;
	private CANTalon tiltMotor;
	private Servo servo;
	
	public Shooter() {
		// rightShooter setup.
		rightShooter = new CANTalon(RobotMap.rightShooter);
		rightShooter.changeControlMode(TalonControlMode.PercentVbus);
		rightShooter.configEncoderCodesPerRev((int) RobotMap.encoderCounts);
		
		// leftShooter setup
		leftShooter = new CANTalon(RobotMap.leftShooter);
		leftShooter.changeControlMode(TalonControlMode.PercentVbus);
		leftShooter.configEncoderCodesPerRev((int) RobotMap.encoderCounts);
		
		// tiltMotor setup
		tiltMotor = new CANTalon(RobotMap.tiltMotor);
		tiltMotor.changeControlMode(TalonControlMode.PercentVbus);
		tiltMotor.reverseOutput(true);
    	tiltMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	tiltMotor.setPosition(0);
    	
    	// servo setup
    	servo = new Servo(RobotMap.servo);
    	servo.setAngle(0);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public int getRightShooterRPM() {
		return rightShooter.getEncVelocity();
	}
	
	public int getLeftShooterRPM() {
		return leftShooter.getEncVelocity();
	}
	
	/**
	 * Sets the speed of the motor.
	 * @param speed A number from -1.0 to 1.0
	 */
	public void setRightShooterSpeed(double speed) {
		if (speed >= -1.0 && speed <= 1.0) {
			rightShooter.set(speed);
		}
	}
	
	public void setLeftShooterSpeed(double speed) {
		if (speed >= -1.0 && speed <= 1.0) {
			leftShooter.set(speed);
		}
	}
	
	public void setTiltMotorSpeed(double speed) {
		tiltMotor.set(speed);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

