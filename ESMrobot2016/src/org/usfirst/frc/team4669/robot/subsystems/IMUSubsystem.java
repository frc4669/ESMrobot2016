
package org.usfirst.frc.team4669.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IMUSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ADIS16448_IMU imu = new ADIS16448_IMU();
	public double north;
	public double levelX;
	public double levelY;
	
	public IMUSubsystem() {
		super();
		calibrate();
		reset();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public double getAngle() {
		double angle = imu.getAngleZ()-north;
		while (angle >= 360) {
			angle -= 360;
		}
		while (angle < 0) {
			angle += 360;
		}
		return angle;
	}
	
	public double getAngleZ() {
		return imu.getAngleZ();
	}
	
	public void calibrate() {
		imu.calibrate();
	}
	
	public void reset() {
		levelX = imu.getAngleX();
		levelY = imu.getAngleY();
		north = imu.getAngleZ();
		while (north >= 360) {
			north -= 360;
		}
		while (north < 0) {
			north += 360;
		}
	}
	
	public double getNorth() {
		return north;
	}
	
	public double getAngleX() {
		return imu.getAngleX();
	}
	
	public double getAngleY() {
		return imu.getAngleY();
	}
	
	public double getInitialLevelX() {
		return levelX;
	}
	
	public double getInitialLevelY() {
		return levelY;
	}
	
	public boolean isLevel() {
		if (Math.abs(levelX-getAngleX()) > 5) {
			return false;
		}
		else if (Math.abs(levelY-getAngleY()) > 5) {
			return false;
		}
		return true;
	}

}

