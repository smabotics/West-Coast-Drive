package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team5493.robot.subsystems.utils.EncoderAdjustment;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBaseNotPID extends Subsystem implements IDriveBaseSubsystem {
	SpeedController lFront = new Victor(RobotMap.L_Front);
	SpeedController rFront = new Victor(RobotMap.R_Front);
	SpeedController lRear = new Victor(RobotMap.L_Rear);
	SpeedController rRear = new Victor(RobotMap.R_Rear);

	private RobotDrive drive = new RobotDrive(lFront, lRear, rFront, rRear);

	private Encoder leftEncoder = new Encoder(RobotMap.L_Encoder_A, RobotMap.L_Encoder_B);
	private Encoder rightEncoder = new Encoder(RobotMap.R_Encoder_A, RobotMap.R_Encoder_B);

	// Initialize your subsystem here
	public DriveBaseNotPID() {

	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoysticks(Robot.driveBaseNotPid)); // default
																			// is
																			// Joystick
		// Driving
	}

	// protected double returnPIDInput() {
	// return sonar.getVoltage(); // PID input comes from sonar voltage
	// }

	// protected void usePIDOutput(double output) {
	// tankDrive(output, output);
	// }

	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}

	@Override
	public boolean doesSupportEncoder() {
		return true;
	}

	@Override
	public EncoderAdjustment determineAdjusments() {

		double adjustment = 0;
		
		int left = Math.abs(this.leftEncoder.get());
		int right = Math.abs(this.rightEncoder.get());

		// TODO: MAybe this needs to be proportional (i.e. PID)?
		if (left > right) {
			adjustment = .01;
		} else if (left < right) {
			adjustment = -.01;
		}
		
		return new EncoderAdjustment(EncoderAdjustment.SIDE_RIGHT, adjustment);
	}

	@Override
	public void resetEncoders() {
		this.leftEncoder.reset();
		this.rightEncoder.reset();
	}

	// public double getEncoderAverage() {
	// return (leftEncoder.get() + rightEncoder.get()) / 2.0;
	// }
	//
	// public double getEncoderDistance() {
	// return getEncoderAverage() * Math.PI * 4.0 / 1440.0; // 1440 Pulses per
	// // Revolution
	// // for E4T;
	// // PI * wheel diameter (4.0 inches) per Revolution
	// }
}
