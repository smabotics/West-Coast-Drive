package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Wrist extends PIDSubsystem {
	private static final double Kp = 2.0,  // Proportional control USED
		Ki = 0.0,  // NO integral control
		Kd = 0.0;  // Potentiometer Voltage @ stow location (vertical)
	public static final double PICKUP = 2.4;
	private static final double STOW = 0.5;
	SpeedController WristMotor = new VictorSP(RobotMap.Wrist);
	AnalogInput pot = new AnalogInput(RobotMap.WristPot);
    // Initialize your subsystem here
    public Wrist() {
        super("Wrist", Kp, Ki, Kd);
        setSetpoint(STOW);
        enable();
    }
    public void initDefaultCommand() { }
    protected double returnPIDInput() {
        return pot.getVoltage();
    }
    protected void usePIDOutput(double output) {
        WristMotor.set(output);
    }
}
