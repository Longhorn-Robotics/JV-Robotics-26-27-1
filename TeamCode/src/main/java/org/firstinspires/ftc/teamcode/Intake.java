package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name="IntakeTest", group="LinearOpMode")
@SuppressWarnings("unused")

public class Intake {
    DcMotor intakeMotor;
    boolean run_motor = false;
    public void setup(HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
    }

    public void run(Gamepad gamepad) {
        if (gamepad.a) {
            run_motor = !run_motor;
        }
        if (run_motor) {
            intakeMotor.setPower(1.0);
        }
    }
}
