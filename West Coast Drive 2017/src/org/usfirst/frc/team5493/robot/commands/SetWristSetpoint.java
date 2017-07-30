package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetWristSetpoint extends Command {
	private double setpoint;
    public SetWristSetpoint(double setpoint) {
    	requires(Robot.wrist);
    	this.setpoint = setpoint;
    }
    protected void initialize() {
    	Robot.wrist.setSetpoint(setpoint);
    }
    protected void execute() {
    }
    protected boolean isFinished() {
        return Math.abs(Robot.wrist.getPosition() - setpoint) < .08;
        // When the difference between actual wrist position and setpoint
        // is within .08, the command is finished
    }
    protected void end() {
    }
    protected void interrupted() {
    }
}
