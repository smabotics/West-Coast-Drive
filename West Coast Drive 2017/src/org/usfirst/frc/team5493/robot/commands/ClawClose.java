package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClawClose extends Command {

    public ClawClose() {
    	requires(Robot.claw);  // requires the Claw Subsystem
    	setTimeout(1.0);  // used timer to control claw close;
    	                  // a little longer than claw open to 
    	                  // ensure claw fully closes
    }
    protected void initialize() {
    }
    protected void execute() {
    	Robot.claw.close();  // uses the close method created in 
    						 // Claw subsystem
    }
    protected boolean isFinished() {
        return isTimedOut();  // if 1.0s has elapsed, method ends
    }
    protected void end() {
    }
    protected void interrupted() {
    }
}
