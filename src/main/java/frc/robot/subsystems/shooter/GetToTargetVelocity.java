package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.limelight.LimelightSubsystem;

public class GetToTargetVelocity extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private ShooterSubsystem shooterSubsystem;
  private LimelightSubsystem limelight;
  
  private double kF;

  private double targetRPM;

  public GetToTargetVelocity(ShooterSubsystem shooter, LimelightSubsystem limelight, double targetRPM) {
    this.shooterSubsystem = shooterSubsystem;
    this.limelight = limelight;
    this.targetRPM = targetRPM;
  }

  @Override
  public void initialize() {

      SmartDashboard.putString("shooter", "ramping up");
      shooterSubsystem.setkF(shooterSubsystem.lookUpkF(targetRPM));
      
      double kP = 0;
      double kI = 0;
      double kD = 0;
      // double[] gains = dashboard.getRampingGains();
      shooterSubsystem.setPIDF(kP, kI, kD, shooterSubsystem.getkF());
      shooterSubsystem.setTargetRawSpeed(targetRPM);
      // shooter.setControlMethod(ControlMethod.SPIN_UP);
  }

  @Override
  public void execute() {
    shooterSubsystem.getShooterTalon().set(ControlMode.Velocity, targetRPM);
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.off();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
