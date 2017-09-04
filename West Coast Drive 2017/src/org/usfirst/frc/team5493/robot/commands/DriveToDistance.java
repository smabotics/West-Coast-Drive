package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToDistance extends Command {
	double setpoint;  // setpoint to define distance from start, passed as
					  // argument when DriveToDistance called

    public DriveToDistance(double setpoint) {
    	requires(Robot.driveBaseSonarPid);  // requires DriveBase subsystem
    	this.setpoint = setpoint;
    }
    protected void initialize() {
    	Robot.driveBaseSonarPid.setSetpoint(setpoint);
    	Robot.driveBaseSonarPid.enable();
    }
    protected void execute() {
    }
    protected boolean isFinished() {
		return Math.abs(Robot.driveBaseSonarPid.getEncoderDistance() - setpoint) < .05;
        // creates a 'range' +/- .05 from setpoint that ends command
    }
    protected void end() {
    	Robot.driveBaseSonarPid.disable();
    }
    protected void interrupted() {
    	Robot.driveBaseSonarPid.disable();
    }
}
