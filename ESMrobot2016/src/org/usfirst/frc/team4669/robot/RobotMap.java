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

	public static final double driveTrainSpeedProportion = 0.85;
	
	//SHOOTER TILT SPEED PROPORTION
	public static final double shooterTiltSpeedProportion = 1;
	
	// JOYSTICKS
	public static final int leftJoy = 0;
	public static final int rightJoy = 1;
	public static final int armJoy = 2;
	public static final int xbox = 3;
	public static final int snes1 = 4;
	public static final int snes2 = 5;
	
	//SENSORS
	public static final double driveTrainEncoderCounts = 1440;
	public static final double tiltArmEncoderCounts = 4096*3;
	public static final int shooterEncoderCounts = 4096;

	// OTHER
	public static final double wheelDiameter = 7.65;
	public static final double wheelBase = 16.5;
	/**
	 * Calculates circumference of wheel given diameter.
	 */
	public static final double wheelCircumference = Math.PI * wheelDiameter;
	
	public static final double encoderCountConstant = wheelCircumference / driveTrainEncoderCounts;
	
	
	//Defense Type Low Bar
	public static final double autoToLowBar = 40;
	public static final double lowBarTilt = -120;
	public static final double lowBarDistance = 60;
	
	//Defense Type Cheval de Frise
	public static final double autoToCheval = 40;
	public static final double chevalTilt = -110;
	public static final double chevalDistance = 60;
	
	
	//Defense Position 1 (low bar)
	public static final double p1Distance = 108.5;
	public static final double p1Turn = 69.0;
	public static final double p1Shoot = 45;
	
	//Defense Position 2L
	public static final double p2LDistance = 132.5;
	public static final double p2LTurn = 73.9;
	public static final double p2LShoot = 45;
	
	//Defense Position 2L
	public static final double p2RTurn = 18.1; //-18
	public static final double p2RDistance = 78.9;
	public static final double p2RShoot = 45;	
	
	//Defense Position 3
	public static final double p3Distance = 24.5;
	public static final double p3Turn = 10.7;
	public static final double p3Shoot = 45;	
	
	//Defense Position 4
	public static final double p4Distance = 24.5;
	public static final double p4Turn = -10.7;
	public static final double p4Shoot = 45;	

	//Defense Position 5
	public static final double p5Distance = 120.5;
	public static final double p5Turn = -64.4;
	public static final double p5Shoot = 45;	

}
