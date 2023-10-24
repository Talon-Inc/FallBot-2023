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
  private final WPI_TalonSRX m_leftFrontMotor = new WPI_TalonSRX(k_LeftFrontMotorCanID);
  private final WPI_TalonSRX m_leftBackMotor = new WPI_TalonSRX(k_LeftBackMotorCanID);
  private final WPI_TalonSRX m_rightFrontMotor = new WPI_TalonSRX(k_RightFrontMotorCanID);
  private final WPI_TalonSRX m_rightBackMotor = new WPI_TalonSRX(k_RightBackMotorCanID);

  private final MotorControllerGroup m_leftMotorControllerGroup = new MotorControllerGroup(m_leftBackMotor, m_leftFrontMotor);
  private final MotorControllerGroup m_rightMotorControllerGroup = new MotorControllerGroup(m_rightBackMotor, m_rightFrontMotor);

  private DifferentialDrive m_differentialDrive = new DifferentialDrive(m_leftMotorControllerGroup, m_rightMotorControllerGroup);
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    TalonSRXConfiguration config = new TalonSRXConfiguration();
    config.peakCurrentLimit = 40; // the peak current, in amps
    config.peakCurrentDuration = 1500; // the time at the peak current before the limit triggers, in ms
    config.continuousCurrentLimit = 30; // the current to maintain if the peak limit is triggered
    m_leftFrontMotor.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    m_leftBackMotor.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    m_rightFrontMotor.configAllSettings(config); // apply the config settings; this selects the quadrature encoder
    m_rightBackMotor.configAllSettings(config); // apply the config settings; this selects the quadrature encoder

    m_leftFrontMotor.set(TalonSRXControlMode.PercentOutput, FACTOR); // runs the motor at FACTOR% power
    m_leftBackMotor.set(TalonSRXControlMode.PercentOutput, FACTOR); // runs the motor at FACTOR% power
    m_rightFrontMotor.set(TalonSRXControlMode.PercentOutput, FACTOR); // runs the motor at FACTOR% power
    m_rightBackMotor.set(TalonSRXControlMode.PercentOutput, FACTOR); // runs the motor at FACTOR% power

    m_leftFrontMotor.configFactoryDefault();
    m_leftBackMotor.configFactoryDefault();
    m_rightFrontMotor.configFactoryDefault();
    m_rightBackMotor.configFactoryDefault();

  }

  public WPI_TalonSRX getleftFrontMotor() {
    return m_leftFrontMotor;
  }

  public WPI_TalonSRX getM_rightFrontMotor() {
    return m_rightFrontMotor;
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    m_differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  public void setLeftMotors(double speed){
    m_leftMotorControllerGroup.set(speed);
  }

  public void setRightMotors(double speed){
    m_rightMotorControllerGroup.set(speed);
  }

  public void stop(){
    setLeftMotors(0);
    setRightMotors(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
