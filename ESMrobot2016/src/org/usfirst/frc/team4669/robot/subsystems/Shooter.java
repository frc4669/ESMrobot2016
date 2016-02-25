
package org.usfirst.frc.team4669.robot.subsystems;

import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.commands.TiltShooterPID;
import org.usfirst.frc.team4669.robot.commands.TiltShooterWithSticks;

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
		super();
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
		tiltMotor.changeControlMode(TalonControlMode.Position);
		tiltMotor.reverseOutput(true);
    	tiltMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	tiltMotor.setPID(5.0, 0.001, 2.0);
    	tiltMotor.setEncPosition(0);
    	
    	// servo setup
    	servo = new Servo(RobotMap.servo);
    	servo.setAngle(90);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public int getRightShooterRPM() {
		return rightShooter.getEncVelocity();
	}
	
	public int getLeftShooterRPM() {
		return leftShooter.getEncVelocity();
	}
	
	public double getTiltEncoder() {
		return tiltMotor.getEncPosition();
	}
	
	public void zeroTiltEncoder() {
		tiltMotor.setPosition(0);
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
		tiltMotor.set(RobotMap.shooterTiltSpeedProportion*speed);
	}
	
	public void setTilt(double position) {
		tiltMotor.set(position);
	}
	
	public double getTiltPosition() {
		return tiltMotor.getPosition();
	}
	
	public void setServoAngle(int angle) {
		if (angle >= 0 && angle <= 170) {
			servo.setAngle(angle);
		}
	}

	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TiltShooterPID());
    }
}