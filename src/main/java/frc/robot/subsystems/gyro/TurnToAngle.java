// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.gyro;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive.DriveBaseSub;

public class TurnToAngle extends CommandBase {
  
  private DriveBaseSub driveBaseSub;
  private GyroSubsystem gyroSub;
  private double startAngle;
  private double power;
  private double angle;
  
  /** Creates a new TurnToAngle. */
  public TurnToAngle(DriveBaseSub driveBaseSub, GyroSubsystem gyroSub, double angle, double power) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveBaseSub = driveBaseSub;
    this.gyroSub = gyroSub;
    this.power = power;
    this.angle = angle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.startAngle = gyroSub.getGyroAngle();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int directionalCoefficient = 1;
    if (this.angle > 0) {
      directionalCoefficient = -1;
    }

    driveBaseSub.setLeftPower(directionalCoefficient * power);
    driveBaseSub.setRightPower(directionalCoefficient * power);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBaseSub.setAll(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return gyroSub.getGyroAngle() >= this.angle + this.startAngle;
  }
}
