// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.DriveConstants.*;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(LeftFrontMotor);
  WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(LeftBackMotor);
  WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(RightFrontMotor);
  WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(RightBackMotor);


  /** Creates a new DriveTrain. */
  public DriveTrain() {
  MotorControllerGroup leftMotors = new MotorControllerGroup(leftBackMotor,leftFrontMotor);
  MotorControllerGroup rightMotors = new MotorControllerGroup(rightBackMotor,rightFrontMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void 
}