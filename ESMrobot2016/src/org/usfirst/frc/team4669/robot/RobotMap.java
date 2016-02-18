package org.usfirst.frc.team4669.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	// DRIVE MOTORS
	public static final int frontLeftDrive = 8;
	public static final int frontRightDrive = 7;
	public static final int rearLeftDrive = 5;
	public static final int rearRightDrive = 4;
	
	//SHOOTER MOTORS
	public static final int tiltMotor = 3;
	public static final int leftShooter = 1;
	public static final int rightShooter = 2;
	
	public static final int servo = 0;
	
	//DRIVE TRAIN SPEED PROPORTION
	public static final double driveTrainSpeedProportion = 0.7;
	
	//SHOOTER TILT SPEED PROPORTION
	public static final double shooterTiltSpeedProportion = 1;
	
	// JOYSTICKS
	public static final int leftJoy = 0;
	public static final int rightJoy = 1;
	public static final int armJoy = 2;
	
	//SENSORS
	public static final double encoderCounts = 1440;
	
	
	// OTHER
	public static final double wheelDiameter = 7.65;
	/**
	 * Calculates circumference of wheel given diameter.
	 */
	public static final double wheelCircumference = Math.PI * wheelDiameter;
	
	public static final double encoderCountConstant = wheelCircumference / encoderCounts;
	
	
	
}
