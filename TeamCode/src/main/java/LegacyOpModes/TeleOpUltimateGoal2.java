//package LegacyOpModes;
//
//import com.arcrobotics.ftclib.hardware.motors.Motor;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//
//import Team7159.ComplexRobots.FlywheelBot2;
//
//@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Ultimate Goal TeleOp 2")
//public class TeleOpUltimateGoal2 extends LinearOpMode {
//
//    final int PLATFORM_BASE = 0;
//    final int PLATFORM_RAISED = 166;
//    final double PLATFORM_MOTOR_POWER = 0.15;
//
//    final double MAX_POWER = 0.52;
//
//    private FlywheelBot2 robot = new FlywheelBot2();
//
//    @Override
//    public void runOpMode() {
//
//        robot.init(hardwareMap);
//
//        waitForStart();
//
//        robot.intakeServo.setRange(0.34, 0.80);
//        robot.intakeServo.setPosition(0.0);
//
//        robot.flywheelServo.setPosition(1.0);
//
//        robot.platformMotor.resetEncoder();
//
//        int platformPos = PLATFORM_BASE;
//        boolean previousB = false;
//        boolean clawToggle = false;
//
//        double accel;
//        double rotate;
//        double powR;
//        double powL;
//
//        while(opModeIsActive()) {
//            //TODO: Use scaleRange to fix intake servo, rotate intake servo on servo mount to actually make it usable
//            //telemetry.addData("Servo Position: ", robot.flywheelServo.getPosition());
//            telemetry.addData("Platform Position: ", robot.platformMotor.getCurrentPosition());
//            telemetry.addData("Velocity: ", robot.flywheelMotor.getVelocity());
//            telemetry.addData("RF Motor Power: ", robot.RFMotor.get());
//            telemetry.addData("LF Motor Power: ", robot.LFMotor.get());
//            telemetry.addData("RB Motor Power: ", robot.RBMotor.get());
//            telemetry.addData("LB Motor Power: ", robot.LBMotor.get());
//
//            // robot.flywheelServo.setPosition(flywheelServoPos);
//
//            if (gamepad1.x) {
//                platformPos = PLATFORM_RAISED;
//                robot.flywheelMotor.set(MAX_POWER);
//            } else {
//                platformPos = PLATFORM_BASE;
//                robot.flywheelMotor.set(0.0);
//            }
//            robot.platformMotor.setTargetPosition(platformPos);
//            robot.platformMotor.set(PLATFORM_MOTOR_POWER);
//            robot.platformMotor.setRunMode(Motor.RunMode.PositionControl);
//
//            if (gamepad1.b && !previousB) {
//                clawToggle = !clawToggle;
//            }
//            previousB = gamepad1.b;
//
//            if (clawToggle) {
//                robot.clawServo.setPosition(0.5);
//            } else {
//                robot.clawServo.setPosition(0.0);
//            }
//
//            robot.flywheelServo.setPosition(1.0-gamepad1.right_trigger);
//
//            if (gamepad1.left_trigger > 0.5) {
//                robot.intakeServo.setPosition(1.0);
//                robot.intakeMotor.set(1.0);
//            } else {
//                robot.intakeServo.setPosition(0.0);
//                robot.intakeMotor.set(0.0);
//            }
//
//            accel = -gamepad1.left_stick_y;
//
//            //Right Stick--Rotation
//            rotate = -gamepad1.right_stick_x;
//
//            //Determines ratio of motor powers (by sides) using the right stick
//            double rightRatio = 0.5 - (0.5 * rotate);
//            double leftRatio = 0.5 + (0.5 * rotate);
//            //Declares the maximum power any side can have
//            double maxRatio = 1;
//
//            //If we're turning left, the right motor should be at maximum power, so it decides the maxRatio. If we're turning right, vice versa.
//            if (rotate < 0) {
//                maxRatio = 1 / rightRatio;
//            } else {
//                maxRatio = 1 / leftRatio;
//            }
//
//            //Uses maxRatio to max out the motor ratio so that one side is always at full power.
//            powR = rightRatio * maxRatio;
//            powL = leftRatio * maxRatio;
//            //Uses left trigger to determine slowdown.
//            robot.RFMotor.set(powR * accel);
//            robot.RBMotor.set(powR * accel);
//            robot.LFMotor.set(powL * accel);
//            robot.LBMotor.set(powL * accel);
//
//            if(gamepad1.right_bumper && gamepad1.left_bumper) {
//                robot.RFMotor.set(0);
//                robot.LFMotor.set(0);
//                robot.RBMotor.set(0);
//                robot.LBMotor.set(0);
//            } else if(gamepad1.left_bumper) {
//                robot.RFMotor.set(-1);
//                robot.LFMotor.set(1);
//                robot.RBMotor.set(-1);
//                robot.LBMotor.set(1);
//            } else if(gamepad1.right_bumper) {
//                robot.RFMotor.set(1);
//                robot.LFMotor.set(-1);
//                robot.RBMotor.set(1);
//                robot.LBMotor.set(-1);
//            }
//            //Strafing controls (thanks Nick)
//            robot.octoStrafe(gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
//            telemetry.update();
//        }
//    }
//}
