// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoCommands;
import frc.robot.commands.BallCommands;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final static DriveSystem driveSystem = new DriveSystem();
  public final static Intake intake = new Intake();
  public final static Shooter shooter = new Shooter();

  private static Joystick controller1 = new Joystick(0);
  private static Joystick controller2 = new Joystick(1);

  // true = on for 1, false = on for 2
  public static boolean toggleDriver = true;

  public Command defaultDrive = new RunCommand(
      () -> {
      if (toggleDriver) {
        driveSystem.tankPercent(
        controller1.getRawAxis(1),
        controller1.getRawAxis(5)
        );
      }
      else {
        driveSystem.tankPercent(
          controller2.getRawAxis(1),
          controller2.getRawAxis(5)
        );
      }
    },
      driveSystem
    );

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    configureDefaultCommands();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //shoot

    // disabled this, duplicate binding
    // Trigger shoot = new Trigger(() ->controller2.getRawAxis(3)>0.2);
    // //JoystickButton shootButton = new JoystickButton(controller2, Constants.BBUTTON);
    // shoot.whileTrue(BallCommands.shoot());
    // shoot.onFalse(BallCommands.shootStop());

    JoystickButton shootRevButton1 = new JoystickButton(controller1, Constants.XBUTTON);
    shootRevButton1.whileTrue(BallCommands.shootRev());
    shootRevButton1.onFalse(BallCommands.shootStop());

    JoystickButton shootRevButton2 = new JoystickButton(controller2, Constants.XBUTTON);
    shootRevButton2.whileTrue(BallCommands.shootRev());
    shootRevButton2.onFalse(BallCommands.shootStop());

    JoystickButton shootButton1 = new JoystickButton(controller1, Constants.BBUTTON);
    shootButton1.whileTrue(BallCommands.shoot());
    shootButton1.onFalse(BallCommands.shootStop());

    // JoystickButton shootButton2 = new JoystickButton(controller2, Constants.BBUTTON);
    // shootButton2.whileTrue(BallCommands.shoot());
    // shootButton2.onFalse(BallCommands.shootStop());

    //intake
    JoystickButton intakeForward1 = new JoystickButton(controller1, Constants.RBBUTTON);
    intakeForward1.whileTrue(BallCommands.intakeForward());
    intakeForward1.onFalse(BallCommands.intakeStop());

    // JoystickButton intakeForward2 = new JoystickButton(controller2, Constants.RBBUTTON);
    // intakeForward2.whileTrue(BallCommands.intakeForward());
    // intakeForward2.onFalse(BallCommands.intakeStop());

    JoystickButton intakeRev1 = new JoystickButton(controller1, Constants.LBBUTTON);
    intakeRev1.whileTrue(BallCommands.intakeReverse());
    intakeRev1.onFalse(BallCommands.intakeStop());

    // JoystickButton intakeRev2 = new JoystickButton(controller2, Constants.LBBUTTON);
    // intakeRev2.whileTrue(BallCommands.intakeReverse());
    // intakeRev2.onFalse(BallCommands.intakeStop());
    DriveSystem.speedmod = 0.5;
    // toggle driver
    Trigger driverControl = new Trigger(() ->controller1.getRawAxis(2)>0.2);
    driverControl.onTrue(toggleToDriver());
    Trigger operatorControl = new Trigger(() ->controller1.getRawAxis(3)>0.2);
    operatorControl.onTrue(toggleToOperator());

    // toggle speed
    // JoystickButton highSpeed = new JoystickButton(controller1, Constants.YBUTTON);
    // highSpeed.whileTrue(toggleHighSpeed());
    // toggleHighSpeed();
    // JoystickButton lowSpeed = new JoystickButton(controller1, Constants.ABUTTON);
    // lowSpeed.whileTrue(toggleLowSpeed());
  }

  private void configureDefaultCommands() {
    CommandScheduler scheduler1 = CommandScheduler.getInstance();
    scheduler1.setDefaultCommand(driveSystem, defaultDrive);
  }

  private Command toggleToDriver() {
    return new InstantCommand(
      () -> toggleDriver = true
    );
  }
  private Command toggleToOperator() {
    return new InstantCommand(
      () -> toggleDriver = false
    );
  }
  private Command toggleHighSpeed() {
    return new InstantCommand(
      () -> DriveSystem.speedmod = 0.5
    );
  }
  private Command toggleLowSpeed() {
    return new InstantCommand(
      () -> DriveSystem.speedmod = 0.15
    );
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return AutoCommands.demoAuto();
  }
}
