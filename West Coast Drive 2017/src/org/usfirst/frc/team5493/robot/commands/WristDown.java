package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class WristDown extends Command {
    public WristDown() {
    	requires(Robot.wrist);
    }
    protected void initialize() {
    	setTimeout(0.1);
    }
    protected void execute() {
    	Robot.wrist.disable();
    	Robot.wrist.rotatedown();
    }
    protected boolean isFinished() {
        return isTimedOut();
    }
    protected void end() {
    	Robot.wrist.rotatenothing();
    }
    protected void interrupted() {
    }
}
