package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class WristUp extends Command {
    public WristUp() {
	  requires(Robot.wrist);
    }
    protected void initialize() {
    }
    protected void execute() {
    	Robot.wrist.rotateup();
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
    }
    protected void interrupted() {
    }
}
