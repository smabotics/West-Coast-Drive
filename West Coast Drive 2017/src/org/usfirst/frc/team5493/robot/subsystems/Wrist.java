package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.WristDoNothing;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Wrist extends PIDSubsystem {
	private static final double Kp = 2.0,  // Proportional control USED
		Ki = 0.0,  // NO integral control
		Kd = 0.0;  // Potentiometer Voltage @ stow location (vertical)
	public static final double PICKUP = 2.4;   // voltage on wristPot at Pickup position
	public static final double STOW = 0.6;  // voltage on wristPot at Stow position
	SpeedController WristMotor = new Talon(RobotMap.Wrist);
	AnalogInput wristPot = new AnalogInput(RobotMap.WristPot);
    // Initialize your subsystem here
    public Wrist() {
        super("Wrist", Kp, Ki, Kd);
        setSetpoint(STOW);
        enable();
    }
    public void initDefaultCommand() { 
        setDefaultCommand(new WristDoNothing());
    }
    protected double returnPIDInput() {
        return wristPot.getVoltage();
    }
    protected void usePIDOutput(double output) {
        WristMotor.set(output);
    }
    public void rotateup()  {
    	WristMotor.set(.5);   // method to rotate wrist UP
    }
    public void rotatedown()  {
    	WristMotor.set(-.5);   // method to rotate wrist DOWN
    }
    public void rotatenothing() {
    	WristMotor.set(0.0);    // method to STOP wrist
    }
}
