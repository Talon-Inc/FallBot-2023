// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private static final double FACTOR = 0;
  private final WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(1);
  private final WPI_TalonSRX leftBackmotor = new WPI_TalonSRX(2);
  private final WPI_TalonSRX rightFrontmotor = new WPI_TalonSRX(3);
  private final WPI_TalonSRX rightBackmotor = new WPI_TalonSRX(4);
  private DifferentialDrive Drive = null;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    TalonSRXConfiguration config = new TalonSRXConfiguration();
    config.peakCurrentLimit = 40; 
    config.peakCurrentDuration = 1500; 
    config.continuousCurrentLimit = 30; 
    leftFrontMotor.configAllSettings(config); 
    leftBackmotor.configAllSettings(config); 
    rightFrontmotor.configAllSettings(config); 
    rightBackmotor.configAllSettings(config); 

    leftFrontMotor.set(TalonSRXControlMode.PercentOutput, FACTOR); 
    leftBackmotor.set(TalonSRXControlMode.PercentOutput, FACTOR); 
    rightFrontmotor.set(TalonSRXControlMode.PercentOutput, FACTOR);
    rightBackmotor.set(TalonSRXControlMode.PercentOutput, FACTOR);
    leftFrontMotor.configFactoryDefault();
    leftBackmotor.configFactoryDefault();
    rightFrontmotor.configFactoryDefault();
    rightBackmotor.configFactoryDefault();

  
    leftBackmotor.follow(leftFrontMotor);
    rightBackmotor.follow(rightFrontmotor);

   
    boolean leftInverted = false; 
    leftFrontMotor.setInverted(leftInverted);
    rightFrontmotor.setInverted(!leftInverted);

   
    leftBackmotor.setInverted(InvertType.FollowMaster);
    rightBackmotor.setInverted(InvertType.FollowMaster);
    
   
    leftFrontMotor.setSensorPhase(true);
    rightFrontmotor.setSensorPhase(true);

    
    
   Drive = new DifferentialDrive(leftFrontMotor, rightFrontmotor);
  
  }

  @Override
  public void periodic() {
    
  }
}
