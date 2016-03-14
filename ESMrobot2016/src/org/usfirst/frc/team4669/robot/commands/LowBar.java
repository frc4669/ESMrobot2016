package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBar extends CommandGroup{
	public LowBar() {
		addSequential(new MoveForwardInches(RobotMap.autoToLowBar));
		addSequential(new TiltShooter(RobotMap.lowBarTilt));
		addSequential(new MoveForwardInches(RobotMap.lowBarDistance));
	}
	
	public void addCommand(Command command) {
		addSequential(command);
	}
	
	public void addCommandGroup(CommandGroup commandGroup) {
		addSequential(commandGroup);
	}
}
