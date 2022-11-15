// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class ArcadeDrive extends CommandBase {
  private final DriveSubsystem _DriveSubsystem; //specific subsystem reference

  double _lefty;
  double _rotation;

  public ArcadeDrive(DriveSubsystem subsystem, double lefty, double rotation) {
    _DriveSubsystem = subsystem;

    _lefty = lefty;
    _rotation = rotation;

    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    _DriveSubsystem.drive(_lefty, _rotation);
  }

  @Override
  public void end(boolean interrupted) {
    _DriveSubsystem.drive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
