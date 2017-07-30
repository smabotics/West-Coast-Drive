package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.DriveWithJoysticks;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveBase extends PIDSubsystem {
	private static final double Kp = 4.0,
		Ki = 0.0,
		Kd = 0.0;
	private RobotDrive drive = new RobotDrive(RobotMap.L_Front, RobotMap.L_Rear,
			RobotMap.R_Front, RobotMap.R_Rear);
	private Encoder leftEncoder = new Encoder(RobotMap.L_Encoder_A, RobotMap.L_Encoder_B);
	private Encoder rightEncoder = new Encoder(RobotMap.R_Encoder_A, RobotMap.R_Encoder_B);
	private AnalogInput sonar = new AnalogInput(RobotMap.Sonar);
    // Initialize your subsystem here
    public DriveBase() {
    	super("DriveBase", Kp, Ki, Kd);
    }
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());  // default is Joystick Driving
    }

    protected double returnPIDInput() {
        return sonar.getVoltage();  // PID input comes from sonar voltage
    }
    protected void usePIDOutput(double output) {
        tankDrive(output, output);
    }
    public void tankDrive(double left, double right)  {
    	drive.tankDrive(left, right);
    }
    public double getSonarPosition()  {
    	return sonar.getVoltage()*40.31;  // need to multiply raw voltage (V)
    							   // by 40.31 to get position in inches
    }
    public double getEncoderAverage()  {
    	return (leftEncoder.get() + rightEncoder.get())/2.0;
    }
    public double getEncoderDistance()  {
    	return getEncoderAverage()*Math.PI*4.0/1440.0;  // 1440 Pulses per Revolution for E4T;
    					// PI * wheel diameter (4.0 inches) per Revolution
    }
}
