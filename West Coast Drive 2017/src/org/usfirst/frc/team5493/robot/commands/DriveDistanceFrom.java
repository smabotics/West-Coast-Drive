package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.subsystems.DriveBaseSonarPID;
import org.usfirst.frc.team5493.robot.subsystems.IDriveBaseSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistanceFrom extends Command {
	double setpoint;  // create a setpoint variable in Inches.  It will be passed
					  // as an argument when DriveDistanceFrom is called

	private DriveBaseSonarPID driveBase;
	
    public DriveDistanceFrom(IDriveBaseSubsystem driveBaseToUse, double setpoint) {
    	driveBase = (DriveBaseSonarPID) driveBaseToUse;
    	
    	requires(driveBase);  // requires DriveBase subsystem
    	this.setpoint = setpoint;
    }
    protected void initialize() {
    	driveBase.setSetpoint(setpoint);
    	driveBase.enable();
    }
    protected void execute() {
    }
    protected boolean isFinished() {
		return Math.abs(driveBase.getSonarPosition() - setpoint) < 1.0;
        // creates a 'range' +/- 1.0 from setpoint that ends command
    }
    protected void end() {
    	driveBase.tankDrive(0.0, 0.0);
    	//Robot.driveBase.disable();  // if command is finished, stop tankDrive motors
    }
    protected void interrupted() {
    	driveBase.disable();  // if command is interrupted, disable DriveBase
    }
}
