package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

@SuppressWarnings("unused")

public class Intake {
    DcMotor intakeMotor;
    boolean previousA = false;
    boolean previousB = false;

    boolean run_motor_back = false;
    boolean run_motor_straight = false;

    public void setup(HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
    }

    public void run(Gamepad gamepad) {
        boolean currentA = gamepad.a;
        boolean currentB = gamepad.b;

        if (currentA && !previousA) {
            run_motor_straight = !run_motor_straight;
        }

        if (currentB && !previousB) {
            run_motor_back = !run_motor_back;
        }

        previousA = currentA;
        previousB = currentB;

        if (run_motor_straight) {
            intakeMotor.setPower(1.0);
        } else if (run_motor_back) {
            intakeMotor.setPower(-1.0);
        } else {
            intakeMotor.setPower(0);
        }
    }
}
