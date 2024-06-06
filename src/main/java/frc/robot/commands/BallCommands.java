package frc.robot.commands;
//imports all the necessary classes
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class BallCommands {
    public static Command intakeForward() {//creates the forward index command
      return new InstantCommand(
        () -> RobotContainer.intake.forward(),
        RobotContainer.intake
      );
    } 

    
    public static Command intakeReverse() {//creates the  reverse index command
        return new InstantCommand(
			    () -> RobotContainer.intake.reverse(),
			  RobotContainer.intake
		    );
    }

    public static Command intakeStop() {//creates the  reverse index command
      return new InstantCommand(
        () -> RobotContainer.intake.stop(),
      RobotContainer.intake
      );
    }

    public static Command shoot() {//creates the  reverse index command
      return new InstantCommand(
        () -> RobotContainer.shooter.forward(),
      RobotContainer.shooter
      );
    }

    public static Command shootRev() {//creates the  reverse index command
      return new InstantCommand(
        () -> RobotContainer.shooter.forward(),
      RobotContainer.shooter
      );
    }

    public static Command shootStop() {//creates the  reverse index command
      return new InstantCommand(
        () -> RobotContainer.shooter.stop(),
      RobotContainer.shooter
      );
    }

   
}