
package org.usfirst.frc.team4669.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team4669.robot.commands.ChevalDeFrise;
import org.usfirst.frc.team4669.robot.commands.DoNothing;
import org.usfirst.frc.team4669.robot.commands.LowBar;
import org.usfirst.frc.team4669.robot.commands.MoveForwardInches;
import org.usfirst.frc.team4669.robot.commands.Pos1MoveForwardTurnAndShoot;
import org.usfirst.frc.team4669.robot.commands.Pos2LMoveForwardTurnAndShoot;
import org.usfirst.frc.team4669.robot.commands.Pos2RMoveForwardTurnAndShoot;
import org.usfirst.frc.team4669.robot.commands.Pos3MoveForwardTurnAndShoot;
import org.usfirst.frc.team4669.robot.commands.Pos4MoveForwardTurnAndShoot;
import org.usfirst.frc.team4669.robot.commands.Pos5MoveForwardTurnAndShoot;
import org.usfirst.frc.team4669.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4669.robot.subsystems.IMUSubsystem;
import org.usfirst.frc.team4669.robot.subsystems.Shooter;
import org.usfirst.frc.team4669.robot.subsystems.LightRelay;

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
	public static IMUSubsystem imu;
	public static Shooter shooter;
	public static LightRelay lightRelay;
	public static OISNES oisnes;
	public static OIXbox oixbox;
	public static CameraServer server;

	CommandGroup autonomousCommand;
    SendableChooser defenseType;
    SendableChooser defensePosition;
    
    public static NetworkTable visionTable;

    public Robot() {

    	visionTable = NetworkTable.getTable("vision");
    	
    	//Initialize subsystems and variables
    	driveTrain = new DriveTrain();
    	shooter = new Shooter();
    	imu = new IMUSubsystem();
    	lightRelay = new LightRelay();
    	oi = new OI();
    	oisnes = new OISNES();
    	oixbox = new OIXbox();
    	
    	server = CameraServer.getInstance();
        server.setQuality(20);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam2");
    }
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	//Zero encoders
    	driveTrain.zeroEncoders();
    	shooter.zeroTiltEncoder();
		
        defenseType = new SendableChooser();
        defenseType.addDefault("Do Nothing", new DoNothing());
        defenseType.addObject("Low Bar", new LowBar());
        defenseType.addObject("Cheval de Frise", new ChevalDeFrise());
        defenseType.addObject("B or D", new MoveForwardInches(120));
        SmartDashboard.putData("Auto type", defenseType);
        
        defensePosition = new SendableChooser();
        defensePosition.addDefault("Do Nothing", new DoNothing());
        defensePosition.addObject("Position1 Low Bar", new Pos1MoveForwardTurnAndShoot());
        defensePosition.addObject("Position2L", new Pos2LMoveForwardTurnAndShoot());
        defensePosition.addObject("Position2R", new Pos2RMoveForwardTurnAndShoot());
        defensePosition.addObject("Position3", new Pos3MoveForwardTurnAndShoot());
        defensePosition.addObject("Position4", new Pos4MoveForwardTurnAndShoot());
        defensePosition.addObject("Position5", new Pos5MoveForwardTurnAndShoot());
        SmartDashboard.putData("Auto position", defensePosition);
        
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
        autonomousCommand = new CommandGroup();
        autonomousCommand.addSequential((Command) defenseType.getSelected());
        autonomousCommand.addSequential((Command) defensePosition.getSelected());
        
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
    	SmartDashboard.putNumber("Shooter Tilt Encoder", shooter.getTiltPosition());
    	
    	//Update driveTrain encoder values on SmartDashboard
    	SmartDashboard.putNumber("Drive Left Encoder", driveTrain.getLeftEncoder());
    	SmartDashboard.putNumber("Drive Right Encoder", driveTrain.getRightEncoder());
    	
    	//Update IMU values on SmartDashboard
    	SmartDashboard.putNumber("IMU", imu.getAngle());
    	
    }
}
