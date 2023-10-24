// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain;
import static frc.robot.Constants.DriveConstants.*;

public class Drive extends CommandBase {
  CommandXboxController controller;
  DriveTrain driveTrain;
  double moveSpeed;
  double rotateSpeed;
  /** Creates a new Drive. */
  public Drive(DriveTrain driveTrain, CommandXboxController controller) {
    this.controller = controller;
    this.driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  public void update(double moveSpeed, double rotateSpeed) {
    this.moveSpeed = kFactor * -moveSpeed;
    this.rotateSpeed = kTurnFactor * -rotateSpeed;
  }

  public CommandBase updateDrive() {
    return Commands.run(update(moveSpeed, rotateSpeed), driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    double moveSpeed = kFactor * -controller.getLeftY(); //might need to change depending on robot
    double rotateSpeed = kTurnFactor * -controller.getLeftX(); //might need to change depending on robot
    driveTrain.arcadeDrive(moveSpeed, rotateSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
