package org.usfirst.frc.team5493.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team5493.robot.commands.*;
import org.usfirst.frc.team5493.robot.commands.ClawOpen;
import org.usfirst.frc.team5493.robot.commands.ClawClose;

public class OI {
	Joystick stick = new Joystick(RobotMap.DRIVE_JOYSTICK); // Instantiate Joystick
	Button b1 = new JoystickButton(stick, RobotMap.JOYB_X); // Instantiate Joystick Buttons 
	Button b2 = new JoystickButton(stick, RobotMap.JOYB_B);
	Button b3 = new JoystickButton(stick, RobotMap.JOYB_Y);
	Button b4 = new JoystickButton(stick, RobotMap.JOYB_A);
	Button b5 = new JoystickButton(stick, RobotMap.JOYB_LB);
	Button b6 = new JoystickButton(stick, RobotMap.JOYB_RB);
		
	public double getLeftSpeed()  {
		return stick.getRawAxis(RobotMap.JOYA_LY);
	}
	public double getRightSpeed()  {
		return stick.getRawAxis(RobotMap.JOYA_RY);
	}
	public OI() {
		b1.whenPressed(new ClawOpen());  // Button 'X' Opens Claw for timed period (0.8s)
		b2.whenPressed(new ClawClose()); // Button 'B' Closes Claw for timed period (0.8s)
		b3.whileHeld(new ElevatorUp());  // Button 'Y' raises Elevator while button pressed
		b4.whileHeld(new ElevatorDown());  // Button 'A' lowers Elevator while button pressed
		b5.whileHeld(new WristUp());  // Button 'LB' rotates wrist UP while pressed
		b6.whileHeld(new WristDown());  // Button 'LT' rotates wrist DOWN while pressed
	}
	
}
