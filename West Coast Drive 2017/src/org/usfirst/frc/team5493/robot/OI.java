package org.usfirst.frc.team5493.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5493.robot.commands.*;
import org.usfirst.frc.team5493.robot.subsystems.*;
import org.usfirst.frc.team5493.robot.commands.ClawOpen;
import org.usfirst.frc.team5493.robot.commands.ClawClose;

public class OI {
	Joystick stick = new Joystick(RobotMap.DRIVE_JOYSTICK); // Instantiate Joystick
	Button b1 = new JoystickButton(stick, RobotMap.JOYB_X); // Instantiate Joystick Buttons 
	Button b2 = new JoystickButton(stick, RobotMap.JOYB_B);
	Button b3 = new JoystickButton(stick, RobotMap.JOYB_Y);
	Button b4 = new JoystickButton(stick, RobotMap.JOYB_A);
	public double getLeftSpeed()  {
		return stick.getRawAxis(RobotMap.JOYA_LY);
	}
	public double getRightSpeed()  {
		return stick.getRawAxis(RobotMap.JOYA_RY);
	}
	public OI() {
		b1.whenPressed(new ClawOpen());  // Button 'X' Opens Claw
		b2.whenPressed(new ClawClose()); // Button 'B' Closes Claw
		b3.whenPressed(new DriveDistanceFrom(12.0));  // Button 'Y' Executes DriveDistanceFrom
		b4.whenPressed(new SetWristSetpoint(Robot.wrist.PICKUP)); // Button 'A' move Wrist to PICKUP
		// can change assignment of buttons b1 -> b4 to do different things to test 
		// functionality of programming
	}
	
}
