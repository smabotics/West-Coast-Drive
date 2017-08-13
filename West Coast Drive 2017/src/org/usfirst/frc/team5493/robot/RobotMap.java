package org.usfirst.frc.team5493.robot;

public class RobotMap {
	// Setting up XBOX 360 Controller (port 0 on Drive Station USB connections)
	// See Driver Station w/controller connected to identify numbers
	public final static int DRIVE_JOYSTICK = 0,
		JOYB_A = 1,
		JOYB_B = 2,
		JOYB_X = 3,
		JOYB_Y = 4,
		JOYB_LB = 5,
		JOYB_RB = 6,
		JOYA_LX = 0,
		JOYA_LY = 1,
		JOYA_RX = 4,
		JOYA_RY = 5;
	// Setting up Motor Controllers.  Number is PWM port on Roborio
	public static int L_Front = 7,  //Victor 888, Left Front Drive Base
		R_Front = 2,   			//Victor 888, Right Front Drive Base
		L_Rear = 8,  			//Victor SP, Left Rear Drive Base
		R_Rear = 1,   			//Victor SP, Right Rear Drive Base
		Claw = 3,				//Victor SP, Claw Motor (VEX 393)
		Wrist = 4,				//VIctor SP, Wrist Motor (VEX 393)
		Elevator = 5;			//Victor SP, Elevator Motor (VEX 393)
	// Setting up Distance Sensor (MAXSONAR XL-EZ/AE MB1200) & Wrist/Elevator Potentiometers
	// Number is ANALOG Port on Roborio
	public static int Sonar = 1,
		WristPot = 2,
		ElevPot = 3;
	// Setting Up Encoders (AM3132, installed on Tough-Box Mini Drive Shaft)
	// One encoder rotation is one wheel rotation.  Number is DIO Port on Roborio
	public static int R_Encoder_A = 2,
		R_Encoder_B = 1,
		L_Encoder_A = 8,
		L_Encoder_B = 7;	
}
