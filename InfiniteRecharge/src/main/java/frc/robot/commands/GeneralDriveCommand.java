/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class GeneralDriveCommand extends CommandBase {
  private final DriveSubsystem m_driveSubsystem;
  private final DoubleSupplier m_drivePower;
  private final DoubleSupplier m_steerPower;

  /**
   * Creates a new GeneralDriveCommand.
   */
  public GeneralDriveCommand(DriveSubsystem driveSubsystem, DoubleSupplier drivePower, DoubleSupplier steerPower) {
    m_driveSubsystem = driveSubsystem;
    m_drivePower     = drivePower;
    m_steerPower     = steerPower;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveSubsystem.steerDrive(m_drivePower.getAsDouble(), m_steerPower.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
