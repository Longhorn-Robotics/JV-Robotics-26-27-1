package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

// The robot has to go 1.83 forward, rotate 90, left 1.52 after the balls are loaded in.

@SuppressWarnings("unused")
@Autonomous(name="Auto drive", group="Linear Opmode")
public class Auto extends LinearOpMode {
    Mecanum mecanum = new Mecanum();

    @Override
    public void runOpMode() {
        mecanum.setup(hardwareMap);

        waitForStart();

        if (opModeIsActive()) {
            mecanum.drive(0, 1, 0);
            sleep(870);
            mecanum.drive(0, 0, 90 /* not actually sure if this is 90 degrees... */);
            sleep(500);
            mecanum.drive(0, 1, 0);
            sleep(724);
            mecanum.drive(0, 0, 0);
        }
    }
}
