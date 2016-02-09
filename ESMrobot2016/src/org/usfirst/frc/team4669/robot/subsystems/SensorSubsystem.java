
package org.usfirst.frc.team4669.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.analog.adis16448.frc.ADIS16448_IMU;
/**
 *
 */
public class SensorSubsystem extends Subsystem {
    
	ADIS16448_IMU imu;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public SensorSubsystem() {
		imu = new ADIS16448_IMU();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


