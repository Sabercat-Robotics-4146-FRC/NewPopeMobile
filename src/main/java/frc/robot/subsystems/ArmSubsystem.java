// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class ArmSubsystem extends SubsystemBase {

  public TalonSRX armPivot;
  public TalonSRX armUpper;

  public ArmSubsystem() {
    armPivot = new TalonSRX(ArmConstants.armPivotID);
    armUpper = new TalonSRX(ArmConstants.armUpperID);
    
    armPivot.setNeutralMode(NeutralMode.Brake);
    armUpper.setNeutralMode(NeutralMode.Brake);

  }

  @Override
  public void periodic() {

  }

  public void toggleIntake(Boolean intakeState){ //rotation = rightX on joystick

    if(intakeState){
      armPivot.set(ControlMode.PercentOutput, 10);
      armUpper.set(ControlMode.PercentOutput, 100);
    }
    else if (!intakeState){
      armPivot.set(ControlMode.PercentOutput, 0);
      armUpper.set(ControlMode.PercentOutput, 0);
    }
    
  }


  @Override
  public void simulationPeriodic() {
  }
}
