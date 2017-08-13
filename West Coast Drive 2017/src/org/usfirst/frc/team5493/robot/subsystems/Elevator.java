package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.ElevatorDoNothing;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {
	private static final double Kp = 2.0,  // Uses proportional control
		Ki = 0.0,      // NOT using integral control
		Kd = 0.0;      // NOT using differential control
	public static final double BOTTOM = 2.0,  // Voltage on Potentiometer @ Elevator Bottom
		TOP = 3.0;     // Voltage on Potentiometer @ Elevator Top
	                   // NOTE:  Both voltages found experimentally on Robot
		SpeedController ElevatorMotor = new Talon(RobotMap.Elevator);
		AnalogInput elevPot = new AnalogInput(RobotMap.ElevPot);
    // Initialize your subsystem here
    public Elevator() {
    	super("Elevator", Kp, Ki, Kd);  // create a 'super' constructor
    	setSetpoint(TOP);  // Location where PID controller take Elevator
    	enable();  // enables the PID controller
    }
    public void initDefaultCommand() {  
        setDefaultCommand(new ElevatorDoNothing());
    }
    protected double returnPIDInput() {
        return elevPot.getVoltage();
    }
    protected void usePIDOutput(double output) {
        ElevatorMotor.set(output);
    }
    public void up()  {
    	ElevatorMotor.set(.5);   // method to move elevator UP
    }
    public void down()  {
    	ElevatorMotor.set(-.5);   // method to move elevator DOWN
    }
    public void nothing() {
    	ElevatorMotor.set(0.0);    // method to STOP elevator
    }
}
