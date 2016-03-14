package org.usfirst.frc.team4669.robot.subsystems;

import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.commands.ArcadeDriveWithSNES;
import org.usfirst.frc.team4669.robot.commands.ArcadeDriveWithXbox;
import org.usfirst.frc.team4669.robot.commands.TankDriveWithSticks;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * @author FRC4669
 *
 */
public class DriveTrain extends Subsystem {
    private CANTalon frontLeftDrive;
    private CANTalon rearLeftDrive;
    private CANTalon frontRightDrive;
    private CANTalon rearRightDrive;
    private RobotDrive driveTrain;
    
    public DriveTrain() {
    	super();
    	frontLeftDrive = new CANTalon(RobotMap.frontLeftDrive);
    	frontRightDrive = new CANTalon(RobotMap.frontRightDrive);
    	rearLeftDrive = new CANTalon(RobotMap.rearLeftDrive);
    	rearRightDrive = new CANTalon(RobotMap.rearRightDrive);
    	driveTrain = new RobotDrive(frontLeftDrive, rearLeftDrive, frontRightDrive, rearRightDrive);
    	
    	// Configuring the Talons
    	frontLeftDrive.changeControlMode(TalonControlMode.PercentVbus);
    	frontLeftDrive.enableBrakeMode(true);
    	frontLeftDrive.reverseOutput(true);
    	frontLeftDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	frontLeftDrive.setPosition(0);
    	
    	rearLeftDrive.changeControlMode(TalonControlMode.PercentVbus);
    	rearLeftDrive.enableBrakeMode(true);
    	rearLeftDrive.reverseOutput(true);
    	rearLeftDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rearLeftDrive.setPosition(0);
    	
    	frontRightDrive.changeControlMode(TalonControlMode.PercentVbus);
    	frontRightDrive.enableBrakeMode(true);
    	frontRightDrive.reverseOutput(true);
    	frontRightDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	frontRightDrive.setPosition(0);
    	
    	rearRightDrive.changeControlMode(TalonControlMode.PercentVbus);
    	rearRightDrive.enableBrakeMode(true);
    	rearRightDrive.reverseOutput(true);
    	rearRightDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rearRightDrive.setPosition(0);
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
    	driveTrain.tankDrive(-leftMotor * RobotMap.driveTrainSpeedProportion, -rightMotor * RobotMap.driveTrainSpeedProportion, true);
    }
    
    public void setArcadeDrive(double moveValue, double rotateValue) {
    	driveTrain.arcadeDrive(moveValue * RobotMap.driveTrainSpeedProportion, rotateValue * RobotMap.driveTrainSpeedProportion);
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
    	return frontLeftDrive.getPosition();
    }
    
    /**
     * For getting the encoder's position.
     * @return The encoder's position
     */
    public double getRightEncoder() {
    	return -frontRightDrive.getPosition();
    }
    
    public double avgEncoderPosition() {
    	return (getLeftEncoder() + getRightEncoder()) / 2;
    }
    
    /**
     * Set current position of left encoder to zero.
     */
    public void zeroLeftEncoder() {
    	frontLeftDrive.setPosition(0);
    }
    
    /**
     * Set current position of right encoder to zero.
     */
    public void zeroRightEncoder() {
    	frontRightDrive.setPosition(0);
    }
    
    public void zeroEncoders() {
    	zeroLeftEncoder();
    	zeroRightEncoder();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDriveWithXbox());
    }
}

