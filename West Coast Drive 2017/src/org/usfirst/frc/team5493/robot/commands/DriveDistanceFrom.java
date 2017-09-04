package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveDistanceFrom extends Command {
	double setpoint;  // create a setpoint variable in Inches.  It will be passed
					  // as an argument when DriveDistanceFrom is called

    public DriveDistanceFrom(double setpoint) {
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
		return Math.abs(Robot.driveBaseSonarPid.getSonarPosition() - setpoint) < 1.0;
        // creates a 'range' +/- 1.0 from setpoint that ends command
    }
    protected void end() {
    	Robot.driveBaseSonarPid.tankDrive(0.0, 0.0);
    	//Robot.driveBase.disable();  // if command is finished, stop tankDrive motors
    }
    protected void interrupted() {
    	Robot.driveBaseSonarPid.disable();  // if command is interrupted, disable DriveBase
    }
}
