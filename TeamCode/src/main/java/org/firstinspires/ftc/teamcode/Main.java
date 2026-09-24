package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="driveMode", group="LinearOp")
@SuppressWarnings("unused")

public class Main extends LinearOpMode {
    Mecanum mecanum = new Mecanum();
    Intake intake = new Intake();

    @Override
    public void runOpMode() {
        mecanum.setup(hardwareMap);
        intake.setup(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {
            mecanum.drive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
            intake.run(gamepad1);
        }
    }
}

