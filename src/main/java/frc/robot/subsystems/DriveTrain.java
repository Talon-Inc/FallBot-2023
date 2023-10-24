// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.OperatorConstants.*;
public class DriveTrain extends SubsystemBase {
  /** change device numbers later */
  
  private final WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(leftFrontMotor_port);
  private final WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(leftBackMotor_port);
  private final WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(rightFrontMotor_port);
  private final WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(rightBackMotor_port);
  private final MotorControllerGroup m_left_drive = new MotorControllerGroup(leftBackMotor, leftFrontMotor);
  private final MotorControllerGroup m_right_drive = new MotorControllerGroup(rightBackMotor, rightFrontMotor);
  
  private DifferentialDrive robot_drive = new DifferentialDrive(m_left_drive, m_right_drive);

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftBackMotor.configFactoryDefault();
    leftFrontMotor.configFactoryDefault();
    rightBackMotor.configFactoryDefault();
    rightFrontMotor.configFactoryDefault();
    
    TalonSRXConfiguration config = new TalonSRXConfiguration();
    config.peakCurrentLimit = 40;
    config.peakCurrentDuration = 1500;
    config.continuousCurrentLimit = 30;
    leftBackMotor.configAllSettings(config);
    leftFrontMotor.configAllSettings(config);
    rightBackMotor.configAllSettings(config);
    rightFrontMotor.configAllSettings(config);

    m_left_drive.setInverted(true);
    m_right_drive.setInverted(false);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void moveleftmotors(double speed){
  m_left_drive.set(speed);
}

public void moverightmotors(double speed){
  m_right_drive.set(speed);
}

public void stop(){
  moverightmotors(0);
  moveleftmotors(0);
}
}
