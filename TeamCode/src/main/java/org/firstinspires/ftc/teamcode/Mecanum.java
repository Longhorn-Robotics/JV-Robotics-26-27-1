package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@SuppressWarnings("unused")
public class Mecanum {
    DcMotor rightForward;
    DcMotor leftForward;
    DcMotor rightBack;
    DcMotor leftBack;

    public void setup(HardwareMap hardwareMap) {
        rightForward = hardwareMap.get(DcMotor.class, "rightForward");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftForward = hardwareMap.get(DcMotor.class, "leftForward");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");

        leftForward.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void drive(double x, double y, double rotation) {

        double frontLeftPwr = y + x + rotation;
        double frontRightPwr = y - x - rotation;
        double backLeftPwr = y - x + rotation;
        double backRightPwr = y + x - rotation;

        double maxPower = 1.0;
        double maxSpeed = 1.0;

        maxPower = Math.max(maxPower, Math.abs(frontLeftPwr));
        maxPower = Math.max(maxPower, Math.abs(frontRightPwr));
        maxPower = Math.max(maxPower, Math.abs(backRightPwr));
        maxPower = Math.max(maxPower, Math.abs(backLeftPwr));

        rightForward.setPower(maxSpeed * frontRightPwr/maxPower);
        rightBack.setPower(maxSpeed * backRightPwr/maxPower);
        leftForward.setPower(maxSpeed * frontLeftPwr/maxPower);
        leftBack.setPower(maxSpeed * backLeftPwr/maxPower);
    }
}
