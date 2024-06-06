
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class TurnTime extends Command {
  double target;
  double targetTime;
  double direction;
  public TurnTime(int targetTime, int direction) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.targetTime = targetTime;
    this.direction = direction;
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
    RobotContainer.driveSystem.tankPercent(direction*1, direction*-1);
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
