// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class IntakeToggle extends CommandBase {
  
  private final ArmSubsystem _ArmSubsystem; //specific subsystem reference

  BooleanSupplier _intakeState;

  public IntakeToggle(ArmSubsystem subsystem, BooleanSupplier intakeState) {
    _ArmSubsystem = subsystem;

    _intakeState = intakeState;

    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    _ArmSubsystem.toggleIntake(_intakeState.getAsBoolean());
  }

  @Override
  public void end(boolean interrupted) {
    _ArmSubsystem.toggleIntake(false);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
