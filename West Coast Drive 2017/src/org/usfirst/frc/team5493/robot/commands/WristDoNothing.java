package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WristDoNothing extends Command {
    public WristDoNothing() {
    	requires(Robot.wrist);
    }
    protected void initialize() {
    }
    protected void execute() {
    	Robot.wrist.rotatenothing();
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
    }
    protected void interrupted() {
    }
}
