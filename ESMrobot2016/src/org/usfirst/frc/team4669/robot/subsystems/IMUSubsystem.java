
package org.usfirst.frc.team4669.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IMUSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ADIS16448_IMU imu;
	public double initialAngle;
	
	public IMUSubsystem() {
		
		imu = new ADIS16448_IMU();
		imu.startLiveWindowMode();
		imu.calibrate();
		initialAngle = imu.getAngle() + 180;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public double getAngle() {
		return initialAngle - (imu.getAngle() + 180);
	}
	
	public void reset() {
		initialAngle = imu.getAngle() + 180;
	}

}

