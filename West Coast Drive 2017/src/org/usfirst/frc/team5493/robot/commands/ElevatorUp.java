package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ElevatorUp extends Command {
    public ElevatorUp() {
        requires(Robot.elevator);
    }
    protected void initialize() {
    	setTimeout(.2);
    }
    protected void execute() {
    	Robot.elevator.disable();
    	Robot.elevator.up();
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
