package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorDown extends Command {
    public ElevatorDown() {
    	requires(Robot.elevator);
    }
    protected void initialize() {
    	setTimeout(.2);
    }
    protected void execute() {
    	Robot.elevator.disable();
    	Robot.elevator.down();
    }
    protected boolean isFinished() {
        return isTimedOut();
    }
    protected void end() {
    	Robot.elevator.nothing();
    }
    protected void interrupted() {
    }
}
