package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.DriveWithJoysticks;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveBase extends PIDSubsystem {
	SpeedController lFront = new Victor(RobotMap.L_Front);
	SpeedController rFront = new Victor(RobotMap.R_Front);
	SpeedController lRear = new Victor(RobotMap.L_Rear);
	SpeedController rRear = new Victor(RobotMap.R_Rear);
	private static final double Kp = 2.0,
		Ki = 0.0,
		Kd = 0.0;
	private RobotDrive drive = new RobotDrive(lFront, lRear, rFront, rRear);
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
    	double position =  sonar.getVoltage()*40.31;  // need to multiply raw voltage (V)
    							   // by 40.31 to get position in inches
    	DriverStation.reportWarning("Sonar Position: " + position, true);
    	return position;
    }
    public double getEncoderAverage()  {
    	return (leftEncoder.get() + rightEncoder.get())/2.0;
    }
    public double getEncoderDistance()  {
    	return getEncoderAverage()*Math.PI*4.0/1440.0;  // 1440 Pulses per Revolution for E4T;
    					// PI * wheel diameter (4.0 inches) per Revolution
    }
}
