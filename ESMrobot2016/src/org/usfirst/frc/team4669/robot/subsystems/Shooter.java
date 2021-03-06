
package org.usfirst.frc.team4669.robot.subsystems;

import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.commands.TiltShooterWithJoystick;
//import org.usfirst.frc.team4669.robot.commands.TiltShooterWithXbox;

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
		rightShooter.changeControlMode(TalonControlMode.Speed);
		rightShooter.reverseSensor(true);
		rightShooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		rightShooter.configEncoderCodesPerRev(RobotMap.shooterEncoderCounts);
		rightShooter.setPID(0,0,0,0.05,0,12, 0);
		
		// leftShooter setup
		leftShooter = new CANTalon(RobotMap.leftShooter);
		leftShooter.changeControlMode(TalonControlMode.Speed);
		leftShooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		leftShooter.configEncoderCodesPerRev(RobotMap.shooterEncoderCounts);
		leftShooter.setPID(0,0,0,0.05,0,12, 0);
		
		// tiltMotor setup
		tiltMotor = new CANTalon(RobotMap.tiltMotor);
		tiltMotor.changeControlMode(TalonControlMode.PercentVbus);
		tiltMotor.reverseOutput(false);
    	tiltMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	//tiltMotor.setPID(0.1, 0.001, 1.0);
    	tiltMotor.setPosition(0);
    	tiltMotor.enableBrakeMode(true);
    	
    	// servo setup
    	servo = new Servo(RobotMap.servo);
    	servo.setAngle(90);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public int getRightShooterRPM() {
		return rightShooter.getEncVelocity()*600/RobotMap.shooterEncoderCounts;
	}
	
	public int getLeftShooterRPM() {
		return leftShooter.getEncVelocity()*600/RobotMap.shooterEncoderCounts;
	}
	
	public void setRightShooterRPM(double velocity) {
		rightShooter.set(velocity*RobotMap.shooterEncoderCounts/6000);
	}
	
	public void setLeftShooterRPM(double velocity) {
		leftShooter.set(velocity*RobotMap.shooterEncoderCounts/6000);
	}
	
	public void setShootingRPM(double velocity) {
		setRightShooterRPM(-velocity);
		setLeftShooterRPM(velocity);
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
		tiltMotor.changeControlMode(TalonControlMode.PercentVbus);
		tiltMotor.set(RobotMap.shooterTiltSpeedProportion*speed);
	}
	
	public void setTilt(double position) {
		tiltMotor.changeControlMode(TalonControlMode.Position);
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
	
	public double getServoAngle() {
		return servo.getAngle();
	}

	public boolean getLimitSwitchClosed() {
		return tiltMotor.isRevLimitSwitchClosed();
	}
	
	public void disableLimitSwitch() {
		tiltMotor.enableLimitSwitch(false, false);
	}
	
	public void enableLimitSwitch() {
		tiltMotor.enableLimitSwitch(true, true);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TiltShooterWithJoystick());
    }

}