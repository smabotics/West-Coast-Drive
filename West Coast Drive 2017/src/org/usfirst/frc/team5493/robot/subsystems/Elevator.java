package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {
	private static final double Kp = 4.0,  // Uses proportional control
		Ki = 0.0,      // NOT using integral control
		Kd = 0.0,      // NOT using differential control
		BOTTOM = 2.6,  // Voltage on Potentiometer @ Elevator Bottom
		TOP = 3.8;     // Voltage on Potentiometer @ Elevator Top
	                   // NOTE:  Both voltages found experimentally on Robot
		SpeedController ElevatorMotor = new VictorSP(RobotMap.Elevator);
		AnalogInput pot = new AnalogInput(RobotMap.ElevPot);
    // Initialize your subsystem here
    public Elevator() {
    	super("Elevator", Kp, Ki, Kd);  // create a 'super' constructor
    	setSetpoint(TOP);  // Location where PID controller take Elevator
    	enable();  // enables the PID controller
    }
    public void initDefaultCommand() {  }
    protected double returnPIDInput() {
        return pot.getVoltage();
    }
    protected void usePIDOutput(double output) {
        ElevatorMotor.set(output);
    }
}
