// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive.DriveBaseSub;
import frc.robot.subsystems.gyro.GyroSubsystem;
import frc.robot.subsystems.gyro.TurnToAngle;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The rob\ot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  // private final ElevatorSubsystem elevator = new ElevatorSubsystem();
  // private final PaddedXbox joystick = new PaddedXbox();

  // private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  // private final ElevatorUp elevatorUp = new  ElevatorUp(elevator, joystick, 0);
  private final DriveBaseSub driveBaseSub = new DriveBaseSub();
  private final GyroSubsystem gyroSub = new GyroSubsystem();
  private final TurnToAngle turnToAngle = new TurnToAngle(driveBaseSub, gyroSub, 30, 0.5);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  //  new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value).whenPressed(new ElevatorUp(elevator, joystick, .1));

  }
  // public Command getDefaultCommand(){
  //   return turnToAngle;
  //   // return elevatorUp;
  // }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
//    *
//    * @return the command to run in autonomous
//    */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return turnToAngle;
  }
  public void scheduleDefaultCommands(){
    // elevatorUp.schedule();
    // calibrate.schedule();
    // intakeDefault.schedule();
  }
}
