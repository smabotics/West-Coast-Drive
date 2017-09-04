package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.ClawDoNothing;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {
    // Instantiate VEX 393 ClawMotor with Victor SP Speed Controller
	private SpeedController clawMotor = new Talon(RobotMap.Claw);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ClawDoNothing());
    }
    public void open()  {
    	clawMotor.set(1.0);   // method to OPEN claw
    }
    public void close()  {
    	clawMotor.set(-1.0);   // method to CLOSE claw
    }
    public void doNothing() {
    	clawMotor.set(0.0);    // method to STOP claw
    }
}

