// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveSubsystem extends SubsystemBase {

  public TalonSRX rightFront;
  public TalonSRX leftFront;
  public TalonSRX rightBack;
  public TalonSRX leftBack;

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    rightFront = new TalonSRX(DriveConstants.rightFrontID);
    leftFront = new TalonSRX(DriveConstants.leftFrontID);
    leftBack = new TalonSRX(DriveConstants.leftBackID);
    rightBack = new TalonSRX(DriveConstants.rightBackID);

    
    rightFront.setInverted(InvertType.InvertMotorOutput);
    rightBack.setInverted(InvertType.InvertMotorOutput);
    leftBack.set(ControlMode.Follower, 3);
    rightBack.set(ControlMode.Follower, 1);
    
    rightFront.setNeutralMode(NeutralMode.Brake);
    rightBack.setNeutralMode(NeutralMode.Brake);
    leftFront.setNeutralMode(NeutralMode.Brake);
    leftBack.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {

  }



  public void drive(double leftX, double leftY, double rotation){ //rotation = rightX on joystick
    
    rightFront.set(ControlMode.PercentOutput, leftX + leftY);
    leftFront.set(ControlMode.PercentOutput, -leftX + leftY);

    if(rotation > 0){
      leftFront.set(ControlMode.PercentOutput, Math.abs(rotation));
      leftBack.set(ControlMode.PercentOutput, Math.abs(rotation));
    }
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
