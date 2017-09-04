package org.usfirst.frc.team5493.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team5493.robot.commands.ClawOpen;
import org.usfirst.frc.team5493.robot.commands.ElevatorDoNothing;
import org.usfirst.frc.team5493.robot.commands.ElevatorDown;
import org.usfirst.frc.team5493.robot.commands.ElevatorUp;
import org.usfirst.frc.team5493.robot.commands.WristDoNothing;
import org.usfirst.frc.team5493.robot.commands.WristDown;
import org.usfirst.frc.team5493.robot.commands.WristUp;
import org.usfirst.frc.team5493.robot.commands.ClawClose;

public class OI {
	Joystick stick = new Joystick(RobotMap.DRIVE_JOYSTICK); // Instantiate Joystick
	Button b1 = new JoystickButton(stick, RobotMap.JOYB_X); // Instantiate Joystick Buttons....
	Button b2 = new JoystickButton(stick, RobotMap.JOYB_B);
	Button b3 = new JoystickButton(stick, RobotMap.JOYB_Y);
	Button b4 = new JoystickButton(stick, RobotMap.JOYB_A);
	Button b5 = new JoystickButton(stick, RobotMap.JOYB_LB);
	Button b6 = new JoystickButton(stick, RobotMap.JOYB_RB);
	Button b7 = new JoystickButton(stick, RobotMap.JOYB_BACK);
	Button b8 = new JoystickButton(stick, RobotMap.JOYB_START);
	Trigger t1 = new JoystickButton(stick, RobotMap.JOYB_LT);
	Trigger t2 = new JoystickButton(stick, RobotMap.JOYB_RT);
		
	public double getLeftSpeed()  {
		return stick.getRawAxis(RobotMap.JOYA_LY);
	}
	public double getRightSpeed()  {
		return stick.getRawAxis(RobotMap.JOYA_RY);
	}
	public OI() {
		b5.whenPressed(new ClawOpen());  // Button 'LB' Opens Claw for timed period (0.8s)
		b6.whenPressed(new ClawClose()); // Button 'RB' Closes Claw for timed period (0.8s)
		b3.whenPressed(new ElevatorUp());  // Button 'Y' Elevator UP
		b4.whenPressed(new ElevatorDown());  // Button 'A' Elevator DOWN
		//b6.whenPressed(new ElevatorDoNothing());  // Button '' STOPS Elevator motion
		b1.whenPressed(new WristUp());  // Button 'X' Wrist UP
		b2.whenPressed(new WristDown());  // Button 'B' Wrist DOWN
		//b5.whenPressed(new WristDoNothing());  //  Button 'RB' STOPS Wrist motion
	
	}
	
}
