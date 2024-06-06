package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
   private static WPI_TalonSRX motor1;
   private static WPI_TalonSRX motor2;


   public Intake(){

      motor1 = new WPI_TalonSRX(7); //PLACEHOLDERS
      motor2 = new WPI_TalonSRX(8);
   }
   public void forward(){//moves the index forward
      motor1.set(ControlMode.PercentOutput, 0.3);
      motor2.set(ControlMode.PercentOutput, -0.3);
   }
   public void reverse(){//moves the index reverse
      motor1.set(ControlMode.PercentOutput, -0.3);
      motor2.set(ControlMode.PercentOutput, 0.3);
   }

   public void stop(){//moves the index reverse
    motor1.set(ControlMode.PercentOutput, 0);
    motor2.set(ControlMode.PercentOutput, 0);
 }


}