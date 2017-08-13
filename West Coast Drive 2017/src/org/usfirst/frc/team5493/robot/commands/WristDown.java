package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class WristDown extends Command {
    public WristDown() {
    	requires(Robot.wrist);
    }
    protected void initialize() {
    }
    protected void execute() {
    	Robot.wrist.rotatedown();
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
    }
    protected void interrupted() {
    }
}
