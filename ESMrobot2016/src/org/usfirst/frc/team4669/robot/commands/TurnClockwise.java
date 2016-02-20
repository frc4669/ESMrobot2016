
package org.usfirst.frc.team4669.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.subsystems.DriveTrain;

/**
 *
 */
public class TurnClockwise extends Command {
	
	private DriveTrain driveTrain = Robot.driveTrain;
	private static double degreesToTurn;
	private double distanceToTravel;

    public TurnClockwise(double degree) {
        // Use requires() here to declare subsystem dependencies
    	degreesToTurn = degree*(16.5*Math.PI/360);
    	distanceToTravel = degreesToTurn / RobotMap.encoderCountConstant;
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.zeroEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.setMotors(-1, 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return driveTrain.getLeftEncoder() > distanceToTravel;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.stopMotors();
    	driveTrain.zeroEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
