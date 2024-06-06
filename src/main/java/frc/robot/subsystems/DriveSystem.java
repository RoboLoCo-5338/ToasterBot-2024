// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix6.Utils;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix.*;
// import com.ctre.phoenix
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSystem extends SubsystemBase {
  private static TalonSRX rightFront;
  private static TalonSRX rightRear;
  private static TalonSRX leftFront;
  private static TalonSRX leftRear;
  public static double speedmod = 0.2;

  /** Creates a new DriveSystem. */
  public DriveSystem() {
    rightFront = new TalonSRX(2);
    rightRear = new TalonSRX(14);
    leftFront = new TalonSRX(3);
    leftRear = new TalonSRX(1);
  
    leftFront.setInverted(true);
    leftRear.setInverted(true);
    rightRear.follow(rightFront);
    leftRear.follow(leftFront);
  }

  public void tankPercent(double left, double right) {
    right*=1.2;
    if(Math.signum(left)!=Math.signum(right)){
      left*=1.3;
      right*=1.3;
    }
    leftFront.set(ControlMode.PercentOutput, left * speedmod);
    rightFront.set(ControlMode.PercentOutput, right * speedmod);
    SmartDashboard.putNumber("speedmod", speedmod);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
