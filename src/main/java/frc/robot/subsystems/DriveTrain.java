// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  TalonSRX leftFrontMotor;
  TalonSRX leftBackMotor;
  TalonSRX rightFrontMotor;
  TalonSRX rightBackMotor;
  /** Creates a new DriveTrain. */
  public DriveTrain() {
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}    config.peakCurrentLimit = 40; 
config.peakCurrentDuration = 1500; 
config.continuousCurrentLimit = 30; 
leftFrontMotor.configAllSettings(config); 
leftBackMotor.configAllSettings(config);
rightFrontMotor.configAllSettings(config); /
rightBackMotor.configAllSettings(config);