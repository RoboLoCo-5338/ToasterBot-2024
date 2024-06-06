package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
   private static WPI_TalonFX shootMotor;


   public Shooter(){

      shootMotor = new WPI_TalonFX(5); //PLACEHOLDER
     shootMotor.setNeutralMode(NeutralMode.Brake);
   }
   public void forward(){//shoot
      shootMotor.set(ControlMode.PercentOutput, -0.20);
   }
   public void reverse(){//retract ball
      shootMotor.set(ControlMode.PercentOutput, 0.17);
   }

   public void stop() {
    shootMotor.set(ControlMode.PercentOutput, 0);
   }


}