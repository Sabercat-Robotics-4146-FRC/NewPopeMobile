// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.autonomous.Taxi;
import frc.robot.commands.CheezyDrive;
import frc.robot.commands.ShiftGears;
import frc.robot.subsystems.DriveTrain;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

  private static final Command InstantCommand = null;

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {

  }

  public Command getAutonomousCommand() {
    return InstantCommand;
  }
}
