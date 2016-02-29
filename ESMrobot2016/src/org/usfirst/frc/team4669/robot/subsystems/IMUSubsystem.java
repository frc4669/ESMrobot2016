
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
	public double initialAngle;
	
	public IMUSubsystem() {
		super();
		imu.startLiveWindowMode();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public double getAngle() {
		double angle = imu.getAngleZ();
		if (angle > 360) {
			angle -= 360;
		}
		else if (angle < -360) {
			angle += 360;
		}
		return angle;
	}
	
	public void calibrate() {
		imu.calibrate();
	}
	
	public void reset() {
		initialAngle = imu.getAngleZ() + 360;
		if (initialAngle > 360) {
			initialAngle -= 360;
		}
	}

}

