// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems.pneumatics;

// import frc.robot.subsystems.pneumatics.SolenoidSubsystem;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// /** An example command that uses an example subsystem. */
// public class RunSolenoid extends CommandBase {
//   @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
//   private final SolenoidSubsystem m_subsystem;

//   /**
//    * Creates a new ExampleCommand.
//    *
//    * @param subsystem The subsystem used by this command.
//    */
//   public RunSolenoid(SolenoidSubsystem subsystem) {
//     m_subsystem = subsystem;
//     // Use addRequirements() here to declare subsystem dependencies.
//     addRequirements(subsystem);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {

//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     if (m_controller.getYButtonPressed()) {
//       m_subsystem.toggleSoleniod();
//    }
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {}

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
