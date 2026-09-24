package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name="IntakeTest", group="LinearOpMode")
@SuppressWarnings("unused")

public class Intake {
    DcMotor intakeMotor;
    boolean run_motor_straight = false;
    boolean run_motor_back = false;
    public void setup(HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
    }

    public void run(Gamepad gamepad) {
        if (gamepad.a) {
            run_motor_straight = !run_motor_straight;
        } else if (gamepad.b) {
            run_motor_back = !run_motor_back;
        }

        if (run_motor_straight) {
            intakeMotor.setPower(1.0);
        } else if (run_motor_back) {
            intakeMotor.setPower(-1.0);
        } else {
            intakeMotor.setPower(0);
        }
    }
}
