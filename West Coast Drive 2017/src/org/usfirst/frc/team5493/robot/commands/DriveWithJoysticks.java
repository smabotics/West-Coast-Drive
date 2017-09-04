package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {
    	requires(Robot.driveBaseNotPid);  // requires the DriveBase subsystem
    }
    protected void initialize() {
    }
    protected void execute() {
    	Robot.driveBaseNotPid.tankDrive(-Robot.oi.getLeftSpeed(), -Robot.oi.getRightSpeed());
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
