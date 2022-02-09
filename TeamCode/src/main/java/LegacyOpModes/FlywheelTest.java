//package LegacyOpModes;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import Team7159.ComplexRobots.FlywheelBot2;
//
//@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Flywheel Testing")
//public class FlywheelTest extends LinearOpMode {
//
//    private FlywheelBot2 robot = new FlywheelBot2();
//
//    double flywheelSpeed = 0.0;
//
//    @Override
//    public void runOpMode() {
//
//        robot.init(hardwareMap);
//
//        waitForStart();
//
//        while (opModeIsActive()) {
//            telemetry.addData("Flywheel Velocity: ", robot.flywheelMotor.get());
//            if (gamepad1.right_trigger > 0) {
//                robot.flywheelMotor.set(flywheelSpeed);
//            } else {
//                robot.flywheelMotor.set(0.0);
//            }
//            if (gamepad1.a && flywheelSpeed > 0.0) {
//                flywheelSpeed -= 0.01;
//            }
//            if (gamepad1.y) {
//                flywheelSpeed += 0.01;
//            }
//            telemetry.update();
//        }
//    }
//}
