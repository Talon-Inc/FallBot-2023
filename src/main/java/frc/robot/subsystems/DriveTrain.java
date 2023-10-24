// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.DriveConstants.*;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(kFrontLeftCanId);
  private final WPI_TalonSRX m_backLeft = new WPI_TalonSRX(kBackLeftCanId);
  private final WPI_TalonSRX m_frontRight = new WPI_TalonSRX(kFrontRightCanId);
  private final WPI_TalonSRX m_backRight = new WPI_TalonSRX(kBackRightCanId);
  MotorControllerGroup m_leftMotors = new MotorControllerGroup(m_frontLeft, m_backLeft);
  MotorControllerGroup m_rightMotors = new MotorControllerGroup(m_frontRight, m_backRight);
  DifferentialDrive m_differentialDrive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    TalonSRXConfiguration config = new TalonSRXConfiguration();
    config.peakCurrentLimit = 40; // the peak current, in amps
    config.peakCurrentDuration = 1500; // the time at the peak current before the limit triggers, in ms
    config.continuousCurrentLimit = 30; // the current to maintain if the peak limit is triggered
    m_frontLeft.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    m_backLeft.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    m_frontRight.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    m_backRight.configAllSettings(config); // apply the config settings; this selects the quadrature encoder

    m_frontLeft.set(TalonSRXControlMode.PercentOutput, kFactor); // runs the motor at kFactor% power
    m_backLeft.set(TalonSRXControlMode.PercentOutput, kFactor); // runs the motor at kFactor% power
    m_frontRight.set(TalonSRXControlMode.PercentOutput, kFactor); // runs the motor at kFactor% power
    m_backRight.set(TalonSRXControlMode.PercentOutput, kFactor); // runs the motor at kFactor% power

    m_leftMotors.setInverted(false);
    m_rightMotors.setInverted(true);
  
  }

  
  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    m_differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  public void setLeftMotors(double speed) {
    m_leftMotors.set(speed);
  }

  public void setRightMotors(double speed) {
    m_rightMotors.set(speed);
  }

  public void stop() {
    setLeftMotors(0);
    setRightMotors(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
