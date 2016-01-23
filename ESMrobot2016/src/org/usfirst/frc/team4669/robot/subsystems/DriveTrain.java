package org.usfirst.frc.team4669.robot.subsystems;

import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.commands.TankDriveWithSticks;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
/**
 * @author ZWT
 *
 */
public class DriveTrain extends Subsystem {
    private CANTalon leftDrive;
    private CANTalon rightDrive;
    private RobotDrive driveTrain;
    
    public DriveTrain() {
    	super();
    	leftDrive = new CANTalon(RobotMap.leftDrive);
    	rightDrive = new CANTalon(RobotMap.rightDrive);
    	driveTrain = new RobotDrive(leftDrive, rightDrive);
    	
    	// Configuring the Talons
    	leftDrive.changeControlMode(TalonControlMode.PercentVbus);
    	leftDrive.enableBrakeMode(true);
    	leftDrive.reverseOutput(true);
    	leftDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	leftDrive.setPosition(0);
    	
    	rightDrive.changeControlMode(TalonControlMode.PercentVbus);
    	rightDrive.enableBrakeMode(true);
    	rightDrive.reverseOutput(true);
    	rightDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rightDrive.setPosition(0);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    
    // MOTOR MOTION CONTOL
    /**
     * Sets the speed of both motors.
     * @param leftMotor Sets the speed of the left motor.
     * @param rightMotor Sets the speed of the right motor.
     */
    public void setMotors(double leftMotor, double rightMotor) {
    	driveTrain.tankDrive(-leftMotor * RobotMap.speedProportion, -rightMotor * RobotMap.speedProportion, true);
    }
    
    /**
     * Stops the motor using the RobotDrive method: stopMotor().
     */
    public void stopMotors() {
    	driveTrain.stopMotor();
    }
    
    // Distance = (Circumference of Wheel / Number of Counts on Encoder) * Number of Counts to Move
    
    // SENSORS
    /**
     * For getting the encoder's position.
     * @return The encoder's position
     */
    public double getLeftEncoder() {
    	return leftDrive.getPosition();
    }
    
    /**
     * For getting the encoder's position.
     * @return The encoder's position
     */
    public double getRightEncoder() {
    	return -rightDrive.getPosition();
    }
    
    public double avgEncoderPosition() {
    	return (getLeftEncoder() + getRightEncoder()) / 2;
    }
    
    /**
     * Set current position of left encoder to zero.
     */
    public void zeroLeftEncoder() {
    	leftDrive.setPosition(0);
    }
    
    /**
     * Set current position of right encoder to zero.
     */
    public void zeroRightEncoder() {
    	rightDrive.setPosition(0);
    }
    
    public void zeroEncoders() {
    	zeroLeftEncoder();
    	zeroRightEncoder();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDriveWithSticks());
    }
}

