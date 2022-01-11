// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.gyro;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {

  private AHRS gyro;
  /** Creates a new ExampleSubsystem. */
  public GyroSubsystem() {
    this.gyro = new AHRS(SerialPort.Port.kUSB);
  }

  public double getGyroAngle() {
    return this.gyro.getAngle();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("gyro", this.getGyroAngle());
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
