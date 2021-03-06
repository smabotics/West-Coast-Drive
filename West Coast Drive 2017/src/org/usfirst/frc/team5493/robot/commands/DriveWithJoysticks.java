package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.subsystems.IDriveBaseSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveWithJoysticks extends Command {

	private IDriveBaseSubsystem driveBase;
	
    public DriveWithJoysticks(IDriveBaseSubsystem driveBaseToUse) {
    	driveBase = driveBaseToUse;
    	
    	requires((Subsystem) driveBase);  // requires DriveBase subsystem
    }

    protected void initialize() {
    }
    protected void execute() {
    	driveBase.tankDrive(-Robot.oi.getLeftSpeed(), -Robot.oi.getRightSpeed());
    	// getLeftSpeed and getRightSpeed => methods in OI.java
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
    }
    protected void interrupted() {
    }
}
