
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class DriveTime extends Command {
  double target;
  double targetTime;
  public DriveTime(int targetTime) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.targetTime = targetTime;
    addRequirements(RobotContainer.driveSystem);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    target = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    RobotContainer.driveSystem.tankPercent(1, 1);
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveSystem.tankPercent(0, 0);
  }


  // Called once after isFinished returns true
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() - target > targetTime;
  }
}
