
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
	
	public IMUSubsystem() {
		super();
		imu.startLiveWindowMode();
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
	
	public void calibrate() {
		imu.calibrate();
	}
	
	public void reset() {
		north = imu.getAngleZ();
	}
	
	public double getNorth() {
		return north;
	}

}

