
package org.usfirst.frc.team4669.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team4669.robot.commands.ExampleCommand;
import org.usfirst.frc.team4669.robot.subsystems.Camera;
import org.usfirst.frc.team4669.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4669.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4669.robot.subsystems.IMUSubsystem;
import org.usfirst.frc.team4669.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
/**
 * @author FRC4669
 *
 */
public class Robot extends IterativeRobot {

	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static DriveTrain driveTrain;
	public static IMUSubsystem imu = new IMUSubsystem();
	public static Shooter shooter;
	private Timer timer = new Timer();
	public static final Camera camera = new Camera();

    Command autonomousCommand;
    SendableChooser chooser;
    
    //Initialize GRIP network table arrays;
    NetworkTable visionTable0;
    double[] defaultValue = new double[0];
	double[] centerX = new double[1];
	double[] centerY = new double[1];

    public Robot() {
    	
    }
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	//Initialize subsystems and variables
		driveTrain = new DriveTrain();
        shooter = new Shooter();
    	oi = new OI();
    	
    	//Zero encoders
    	driveTrain.zeroEncoders();
    	imu.calibrate();
    	imu.reset();
    	
//    	visionTable0 = NetworkTable.getTable("GRIP/myContoursReport");
		
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new ExampleCommand());
       // chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
        

    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
        
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        // Low Bar
//        new TiltShooter(degree); //tilt arm down
//        new MoveForwardInches(distance); //move past lowbar
//        new Turn(degree); //face robot towards tower
//        new TiltShooter(degree); //aim up at high goal
//        new Shoot(); //shoot
//        
//        // Cheval De Frise
//        new MoveForwardInches(distance); //move onto ramp
//        new TiltShooter(degree); //push down cdf with arm
//        new MoveForwardInches(distance); //move past cdf
//        new Turn(degree); //face robot towards tower
//        new TiltShooter(); //aim up at high goal
//        new Shoot(); //shoot
//        
//        //Ramparts/moat/rockwall/rough terrain
//        new MoveForwardInches(distance); //move past obstacle
//        new Turn(degree); //turn to face towards tower
//        new TiltShooter(degree); //tilt shooter down and aim at goal
//        new Shoot(); //shoot
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        shooter.zeroTiltEncoder();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateSmartDashboard();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    /**
     * Puts all data listed onto the SmartDashboard.
     */
    public void updateSmartDashboard() {
    	
    	//Update Shooter encoder values on SmartDashboard
    	SmartDashboard.putNumber("Shooter Encoder", shooter.getTiltEncoder());
    	
    	//Update driveTrain encoder values on SmartDashboard
    	SmartDashboard.putNumber("Left Encoder", driveTrain.getLeftEncoder());
    	SmartDashboard.putNumber("Right Encoder", driveTrain.getRightEncoder());
    	
    	//Update IMU values on SmartDashboard
    	SmartDashboard.putNumber("IMU", imu.getAngle());
    	SmartDashboard.putNumber("TiltEncoder", Robot.shooter.getTiltPosition());
    	
    	//Shooter Tilt Angle Data Stuff
    	//SmartDashboard.putNumber("Current Angle:", (shooter.getTiltPosition()*(360/12288)));
    	//SmartDashboard.putNumber("Set Angle:", 0);
    	
    	//Get centerX and centerY from GRIP network tables
//    	centerX = visionTable0.getNumberArray("centerX", defaultValue);
//    	centerY = visionTable0.getNumberArray("centerY", defaultValue);
//    	for(int i = 0; i<centerX.length; i++){ 
//    		SmartDashboard.putNumber("Center X", centerX[0]);
//    		SmartDashboard.putNumber("Center Y", centerY[0]);
//    		
//    	}
    }
}
