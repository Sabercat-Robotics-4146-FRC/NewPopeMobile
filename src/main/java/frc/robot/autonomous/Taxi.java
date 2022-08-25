package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.CheezyDrive;
import frc.robot.subsystems.DriveTrain;

public class Taxi extends SequentialCommandGroup {
    public Taxi(DriveTrain driveTrain) {
        addCommands(
            new InstantCommand()
        );
    }
}