package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import java.util.List;

// The robot has to go 1.83 forward, rotate 90, left 1.52 after the balls are loaded in.

@SuppressWarnings("unused")
@Autonomous(name="Auto drive", group="Linear Opmode")
public class Auto extends LinearOpMode {
    Mecanum mecanum = new Mecanum();
    Vision vision = new Vision();

    @Override
    public void runOpMode() {
        mecanum.setup(hardwareMap);
        vision.setup(hardwareMap);

        waitForStart();

        List<AprilTagDetection> tags = vision.getDetection();
        telemetry.addData("tags", tags);
        // TO-DO:
        // finish shooting and how much power to use based on distance
        // Add that to the auto after it lines up with the April tag
        // Get the other balls and shoot them
    }
}
