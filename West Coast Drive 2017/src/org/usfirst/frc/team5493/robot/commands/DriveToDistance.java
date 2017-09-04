package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.subsystems.DriveBaseSonarPID;
import org.usfirst.frc.team5493.robot.subsystems.IDriveBaseSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToDistance extends Command {
	double setpoint;  // setpoint to define distance from start, passed as
					  // argument when DriveToDistance called

	private DriveBaseSonarPID driveBase;
	
    public DriveToDistance(IDriveBaseSubsystem driveBaseToUse, double setpoint) {
    	driveBase = (DriveBaseSonarPID) driveBaseToUse;
    	
    	requires(driveBase);  // requires DriveBase subsystem
    }
    
    protected void initialize() {
    	driveBase.setSetpoint(setpoint);
    	driveBase.enable();
    }
    protected void execute() {
    }
    protected boolean isFinished() {
		return Math.abs(driveBase.getEncoderDistance() - setpoint) < .05;
        // creates a 'range' +/- .05 from setpoint that ends command
    }
    protected void end() {
    	driveBase.disable();
    }
    protected void interrupted() {
    	driveBase.disable();
    }
}
