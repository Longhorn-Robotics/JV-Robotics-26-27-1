package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@SuppressWarnings("unused")

public class Gun {
    DcMotor gunMotor;

    double power = 0.0;

    public void setup(HardwareMap hardwareMap, Telemetry telemetry) {
        telemetry.addData("Gun status", "Initialized");
        telemetry.update();
        gunMotor = hardwareMap.get(DcMotor.class, "gunMotor");
        gunMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        gunMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void run(Gamepad gamepad, Telemetry telemetry) {
        boolean increase = gamepad.right_bumper;
        boolean decrease = gamepad.left_bumper;

        if (increase && power < 1) {
            power += 0.0000001;
            telemetry.addData("Motor power is now at ", power);
            telemetry.update();
        }
        if (decrease && power > 0) {
            power -= 0.0000001;
            telemetry.addData("Motor power now at ", power);
            telemetry.update();
        }

        gunMotor.setPower(power);
    }
}
