package org.usfirst.frc.team4669.robot.subsystems;

import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.commands.TankDriveWithSticks;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    private SpeedController leftDrive;
    private SpeedController rightDrive;
    private RobotDrive driveTrain;
    
    public DriveTrain() {
    	super();
    	leftDrive = new CANTalon(RobotMap.leftDrive);
    	rightDrive = new CANTalon(RobotMap.rightDrive);
    	driveTrain = new RobotDrive(leftDrive, rightDrive);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    /**
     * Sets the speed of both motors.
     * @param leftMotor Sets the speed of the left motor.
     * @param rightMotor Sets the speed of the right motor.
     */
    public void setMotors(double leftMotor, double rightMotor) {
    	driveTrain.tankDrive(leftMotor, rightMotor);
    }
    
    /**
     * Stops the motor using the RobotDrive method: stopMotor().
     */
    public void stopMotors() {
    	driveTrain.stopMotor();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDriveWithSticks());
    }
}

