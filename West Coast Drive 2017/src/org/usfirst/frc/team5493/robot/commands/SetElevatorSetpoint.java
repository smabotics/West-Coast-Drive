package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetElevatorSetpoint extends Command {
	private double setpoint;
    public SetElevatorSetpoint() {
    	requires(Robot.elevator);
    	this.setpoint = setpoint;
    }
    protected void initialize() {
    	Robot.elevator.setSetpoint(setpoint);
    }
    protected void execute() {
    }
    protected boolean isFinished() {
        return Math.abs(Robot.elevator.getPosition() - setpoint) < .05;
        // When difference between actual elevator position and setpoint 
        // is less than .05, command is finished
    }
    protected void end() {
    }
    protected void interrupted() {
    }
}
