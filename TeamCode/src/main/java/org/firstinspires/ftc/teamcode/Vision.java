package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import java.util.List;

public class Vision {
    private AprilTagProcessor aprilTag;
    private VisionPortal visionPortal;

    public void setup(HardwareMap hardwareMap) {
        aprilTag = AprilTagProcessor.easyCreateWithDefaults();
        visionPortal = VisionPortal.easyCreateWithDefaults(
                hardwareMap.get(WebcamName.class, "cam1"), aprilTag
        );
    }
    public List<AprilTagDetection> getDetection() {
        return aprilTag.getDetections();
    }
    public void close() {
        if (visionPortal != null) {
            visionPortal.close();
        }
    }
}
