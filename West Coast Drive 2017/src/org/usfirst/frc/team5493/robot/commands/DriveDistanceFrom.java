package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveDistanceFrom extends Command {
	double setpoint;  // create a setpoint variable in Inches.  It will be passed
					  // as an argument when DriveDistance From is called

    public DriveDistanceFrom(double setpoint) {
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
		return Math.abs(Robot.driveBase.getSonarPosition() - setpoint) < .05;
        // creates a 'range' +/- .05 from setpoint that ends command
    }
    protected void end() {
    	Robot.driveBase.disable();  // if command is finished, disable robot
    }
    protected void interrupted() {
    	Robot.driveBase.disable();  // if command is interrupted, disable robot
    }
}
