//TODO: Refactor

//package Team7159.OpModes.UltimateGoal;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//
//import Team7159.ComplexRobots.FlywheelBot;
//
//@Autonomous(name = "Motor Test")
//public class MotorTest extends LinearOpMode {
//
//    private FlywheelBot robot = new FlywheelBot();
//
//    @Override
//    public void runOpMode() {
//        robot.init(hardwareMap);
//
//        waitForStart();
//
//        telemetry.addData("Running: ", "RF Motor");
//        telemetry.update();
//        robot.RFMotor.setPower(0.5);
//        sleep(2000);
//
//        telemetry.addData("Running: ", "LF Motor");
//        telemetry.update();
//        robot.LFMotor.setPower(0.5);
//        sleep(2000);
//
//        telemetry.addData("Running: ", "RB Motor");
//        telemetry.update();
//        robot.RBMotor.setPower(0.5);
//        sleep(2000);
//
//        telemetry.addData("Running: ", "LB Motor");
//        telemetry.update();
//        robot.LBMotor.setPower(0.5);
//        sleep(2000);
//    }
//}
