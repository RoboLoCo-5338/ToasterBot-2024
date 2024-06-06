package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoCommands {
    public static Command demoAuto() {
		return new SequentialCommandGroup(
			new DriveTime(2000),
            new TurnTime(3000, 1)
		);
	}   
}
