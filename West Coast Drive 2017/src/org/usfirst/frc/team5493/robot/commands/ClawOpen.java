package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.subsystems.Claw;
import edu.wpi.first.wpilibj.command.Command;

public class ClawOpen extends Command {

    public ClawOpen() {
    	requires(Robot.claw);  // requires the Claw Subsystem.  Since there is
    	setTimeout(0.8);   // NO feedback control from a sensor on the claw,
    	      			   // a Timer is used to control how long the motor
    					   // is ON.  The time is found experimentally. 
    }
    protected void initialize() {
    }
    protected void execute() {
    	Robot.claw.open();  // calls the OPEN method created in Claw Subsystem
    }
    protected boolean isFinished() {
        return isTimedOut();  // if 0.8s has elapsed, end the method
    }
    protected void end() {
    }
    protected void interrupted() {
    }
}
