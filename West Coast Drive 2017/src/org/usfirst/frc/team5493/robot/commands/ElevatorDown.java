package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorDown extends Command {
    public ElevatorDown() {
    	requires(Robot.elevator);
    }
    protected void initialize() {
    }
    protected void execute() {
    	Robot.elevator.down();
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
    }
    protected void interrupted() {
    }
}
