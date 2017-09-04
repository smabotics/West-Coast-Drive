package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.subsystems.utils.EncoderAdjustment;

public interface IDriveBaseSubsystem {

    public void tankDrive(double left, double right);
    
    public boolean doesSupportEncoder();
    
    public EncoderAdjustment determineAdjusments();
    
    public void resetEncoders();
    
}
