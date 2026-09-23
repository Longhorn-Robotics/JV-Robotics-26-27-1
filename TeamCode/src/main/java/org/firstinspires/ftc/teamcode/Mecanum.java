package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="WheelDriveTest", group="LinearOpMode")
public class Mecanum extends OpMode {
    DcMotor rightForward;
    DcMotor leftForward;
    DcMotor rightBack;
    DcMotor leftBack;

    public void init() {
        rightForward = hardwareMap.get(DcMotor.class, "rightForward");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftForward = hardwareMap.get(DcMotor.class, "leftForward");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");

        leftForward.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        rightForward.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftForward.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void loop() {
        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;
        double rotation = gamepad1.right_stick_x;

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
