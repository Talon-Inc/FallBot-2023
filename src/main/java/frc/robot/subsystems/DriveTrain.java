// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  WPI_TalonSRX leftFrontMotor;
  WPI_TalonSRX leftBackMotor ;
  WPI_TalonSRX rightFrontMotor;
  WPI_TalonSRX rightBackMotor;
}

  /** Creates a new DriveTrain. */
  public DriveTrain() {
  WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(0);
  WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(0);
  WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(0);
  WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(0);
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }