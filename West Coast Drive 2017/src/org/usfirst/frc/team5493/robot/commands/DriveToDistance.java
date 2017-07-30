package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToDistance extends Command {
	double setpoint;  // setpoint to define distance from start, passed as
					  // argument when DriveToDistance called

    public DriveToDistance(double setpoint) {
    	requires(Robot.driveBase);  // requires DriveBase subsystem
    	this.setpoint = setpoint;
    }
    protected void initialize() {
    	Robot.driveBase.setSetpoint(setpoint);
    	Robot.driveBase.enable();
    }
    protected void execute() {
    }
    protected boolean isFinished() {
		return Math.abs(Robot.driveBase.getEncoderDistance() - setpoint) < .05;
        // creates a 'range' +/- .05 from setpoint that ends command
    }
    protected void end() {
    	Robot.driveBase.disable();
    }
    protected void interrupted() {
    	Robot.driveBase.disable();
    }
}
