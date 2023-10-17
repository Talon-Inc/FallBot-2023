// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** change device numbers later */
  
  private final WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(0);
  private final WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(0);
  private final WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(0);;
  private final WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(0);;
  
  private final MotorControllerGroup m_left_drive = new MotorControllerGroup(leftBackMotor, leftFrontMotor);
  private final MotorControllerGroup m_right_drive = new MotorControllerGroup(rightBackMotor, rightFrontMotor)
;
  /** Creates a new DriveTrain. */
  public DriveTrain() {


  
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
