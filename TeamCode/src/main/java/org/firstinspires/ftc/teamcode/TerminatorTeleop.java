package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Team7159.ComplexRobots.Arnold;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Freight Frenzy Teleop")
public class TerminatorTeleop extends LinearOpMode {

    public Arnold robot = new Arnold();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        //y - raise linear slides
        //a - lower linear slides
        //b - lower + drive intake
        //x - dump bucket
        //lt - rev drive linear slides
        //rt - forward drive linear slides

        //drive controls
        double accel;
        double rotate;
        double powR;
        double powL;

        //linear slide rotation
        double linSlideDrivePower = 0.5;
//        double linSlideRotatePower = 0.3;

        //intake
        boolean intakeActive = false;
        //MAGIC NUMBER
        final int intakeLowered = -300;
        int intakeTarget = 0;
        double intakeDrivePower = -1;

//        boolean previousA = false;
//        boolean bucketToggle = false;

        robot.intakeMotorRotation.resetEncoder();

        while(opModeIsActive()) {

            telemetry.addData("intakePos: ", robot.intakeMotorRotation.getCurrentPosition());
            telemetry.addData("targetPos: ", intakeTarget);
            telemetry.addData("intakeVelocity: ", robot.intakeMotorRotation.getVelocity());

            //intake
            if (gamepad1.b) {
                intakeActive = true;
            } else {
                intakeActive = false;
            }
            if (intakeActive) {
                intakeTarget = intakeLowered;
            } else {
                //MAGIC NUMBER
                intakeTarget = 0;
            }
            if (intakeActive) {
                if (gamepad1.x) {
                    robot.intakeMotorPower.set(-intakeDrivePower);
                } else {
                    robot.intakeMotorPower.set(intakeDrivePower);
                }
            } else {
                robot.intakeMotorPower.set(0);
            }
            if (intakeActive && Math.abs(robot.intakeMotorRotation.getCurrentPosition()-intakeTarget) > 25) {
                robot.intakeMotorRotation.set(-0.3);
            }
            if (!intakeActive && Math.abs(robot.intakeMotorRotation.getCurrentPosition()-intakeTarget) > 25) {
                robot.intakeMotorRotation.set(0.4);
            }
            if (Math.abs(robot.intakeMotorRotation.getCurrentPosition()-intakeTarget) < 25) {
                robot.intakeMotorRotation.set(0);
            }

            robot.carouselMotor.set(0);
            if (gamepad1.y) {
                robot.carouselMotor.set(1);
            }
            if (gamepad1.x) {
                robot.carouselMotor.set(-1);
            }

            //bucket
//            if (gamepad1.a && !previousA) {
//                bucketToggle = !bucketToggle;
//            }
//            previousA = gamepad1.a;
//
//            if (bucketToggle) {
//                robot.bucketTiltServo.setPosition(0.55);
//            } else {
//                robot.bucketTiltServo.setPosition(0);
//            }

            //linear slides drive
            //TODO: add encoder value max and min to prevent failure
//            robot.linearSlidesRotate.set(0);
//            robot.linearSlidesDrive.set(0);
            robot.armRotation.set(0);
            if (gamepad1.left_trigger > 0.5) {
//                if (gamepad1.y) {
//                    robot.linearSlidesRotate.set(0);
//                    robot.linearSlidesRotate.set(linSlideRotatePower);
//                } else if (gamepad1.a) {
//                    robot.linearSlidesRotate.set(0);
//                    robot.linearSlidesRotate.set(-linSlideRotatePower);
//                } else {
//                    robot.linearSlidesRotate.set(0);
//                    robot.linearSlidesDrive.set(linSlideDrivePower);
//                }
//                if (robot.linearSlidesDrive.getCurrentPosition() > 100) {
//                    robot.linearSlidesDrive.set(linSlideDrivePower);
//                }
                robot.armRotation.set(0.15);
            } else if (gamepad1.right_trigger > 0.5) {
//                if (gamepad1.y) {
//                    robot.linearSlidesRotate.set(0);
//                    robot.linearSlidesRotate.set(linSlideRotatePower);
//                } else if (gamepad1.a) {
//                    robot.linearSlidesRotate.set(0);
//                    robot.linearSlidesRotate.set(-linSlideRotatePower);
//                } else {
//                    robot.linearSlidesRotate.set(0);
//                    robot.linearSlidesDrive.set(-linSlideDrivePower);
//                }
//                robot.linearSlidesDrive.set(-linSlideDrivePower);
                robot.armRotation.set(-0.15);
            }
            telemetry.addData("Linear Slide Power: ", robot.armRotation.getVelocity());
            telemetry.addData("LTrigger: ", gamepad1.left_trigger);
            telemetry.addData("RTrigger: ", gamepad1.right_trigger);


            accel = -gamepad1.left_stick_y;

            //Right Stick--Rotation
            rotate = gamepad1.right_stick_x;

            //Determines ratio of motor powers (by sides) using the right stick
            double rightRatio = 0.5 - (0.5 * rotate);
            double leftRatio = 0.5 + (0.5 * rotate);
            //Declares the maximum power any side can have
            double maxRatio = 1;

            //If we're turning left, the right motor should be at maximum power, so it decides the maxRatio. If we're turning right, vice versa.
            if (rotate < 0) {
                maxRatio = 1 / rightRatio;
            } else {
                maxRatio = 1 / leftRatio;
            }

            //Uses maxRatio to max out the motor ratio so that one side is always at full power.
            powR = rightRatio * maxRatio;
            powL = leftRatio * maxRatio;
            //Uses left trigger to determine slowdown.
            robot.RFMotor.set(powR * accel);
            robot.RBMotor.set(powR * accel);
            robot.LFMotor.set(powL * accel);
            robot.LBMotor.set(powL * accel);

            robot.pivotTurn(1, gamepad1.right_bumper, gamepad1.left_bumper);
            //Strafing controls (thanks Nick)
            robot.octoStrafe(gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
            telemetry.update();
        }
    }
}