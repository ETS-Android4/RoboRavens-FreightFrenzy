package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Team7159.ComplexRobots.Arnold;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Noam - Freight Frenzy Teleop")

public class Noam_TerminatorTeleOp extends LinearOpMode {

    public Arnold robot = new Arnold();
    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        //y - Lower Intake(toggle)
        //a - bucket drop
        //b - Carousel motor
        //x - make intake spin out(FailSafe of Linear Slide)
        //lt - rev drive linear slides Variable
        //rt - extend drive linear slides Variable
        //rb/lb  - change robot heading
        //left stick L/R/F/B - Strafe

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
//        final int intakeLowered = -300;
        int intakeTarget = 0;
        double intakeDrivePower = -1;
        double carouselMotorPower = -1;
        robot.linearSlidesDrive.resetEncoder();

        boolean previousA = false;
        boolean bucketToggle = false;
        boolean intakeToggle = false;
        //Carousel Motor
//        boolean carouselActive = false;



        while (opModeIsActive()) {
            int intakeMotorRotationCurrentPos = robot.intakeMotorRotation.getCurrentPosition();
            int LinSlidesDriveCurrentPos = robot.linearSlidesDrive.getCurrentPosition();

            telemetry.addData("intakePos: ", robot.intakeMotorRotation.getCurrentPosition());
            telemetry.addData("targetPos: ", intakeTarget);
            telemetry.addData("intakeVelocity: ", robot.intakeMotorRotation.getVelocity());

            //intake
            /**
             * int get posistion
             *if intakeToggle is false and gamepad1.y is pressed:
             * intakeToggle = true
             *if intakeToggle is true and gamepad1.y is pressed:
             * intakeToggle = false
             *
             *if intakeToggle is true and intakeMotorRotation's position is not -300
             * intakeMotorRotation.set(0.3)
             *if intakeToggle is true and intakeMotorRotation's position is -300
             * intakeMotorRotation.set(0)
             *if intakeToggle is false and intakeMotorRotation's position is not 0
             * intakeMotorRotation.set(-0.5)
             *if intakeToggle is true and intakeMotorRotation's position is 0
             * intakeMotorRotation.set(0)
             *
             *
             */
            // Intake
            // TODO: FIX the intake toggle
            if (!intakeToggle && gamepad1.y) {
                intakeToggle = true;
                intakeActive = true;

            }
            if (intakeToggle && gamepad1.y && intakeMotorRotationCurrentPos <= -300) {
                intakeToggle = false;
                intakeActive = false;
            }


            if (intakeToggle && intakeMotorRotationCurrentPos != -300) {
                robot.intakeMotorRotation.set(-0.3);
            }
            if (intakeMotorRotationCurrentPos >= -300 && intakeToggle) {
                robot.intakeMotorRotation.set(0);
            }
            if (!intakeToggle && intakeMotorRotationCurrentPos != 0) {
                robot.intakeMotorRotation.set(-0.5);
            }
            if (intakeToggle && intakeMotorRotationCurrentPos <= 0) {
                robot.intakeMotorRotation.set(0);
            }

//            // Josh intake
//            if (gamepad1.y) {
//                intakeActive = true;
//            } else {
//                intakeActive = false;
//            }
//            if (intakeActive) {
//                intakeTarget = intakeLowered;
//            } else {
//                //MAGIC NUMBER
//                intakeTarget = 0;
//            }

            // Carousel(Duck) Motor
            if (gamepad1.b) {
                robot.carouselMotor.set(carouselMotorPower);
            } else {
                robot.carouselMotor.set(0);
            }
//            if (carouselActive) {
//                robot.carouselMotor.set(carouselMotorPower);
//            } else {
//                robot.carouselMotor.set(0);


//            if (intakeTarget != intakeLowered && gamepad1.y) {
//                intakeActive = true;
//                intakeTarget = intakeLowered;
//            } else if (intakeTarget != 0 && gamepad1.y) {
//                intakeActive = false;
//                intakeTarget = 0;
            }
//            intakeActive = false;
//                }
//                intakeTarget = intakeLowered;
//            } else {
//                //MAGIC NUMBER
//                intakeTarget = 0;

            if (intakeActive) {
                robot.intakeMotorPower.set(intakeDrivePower);
            } else {
                robot.intakeMotorPower.set(0);
            }
            if (intakeActive && Math.abs(robot.intakeMotorRotation.getCurrentPosition() - intakeTarget) > 25) {
                robot.intakeMotorRotation.set(-0.3);
            }
            if (!intakeActive && Math.abs(robot.intakeMotorRotation.getCurrentPosition() - intakeTarget) > 25) {
                robot.intakeMotorRotation.set(0.4);
            }
            if (Math.abs(robot.intakeMotorRotation.getCurrentPosition() - intakeTarget) < 25) {
                robot.intakeMotorRotation.set(0);
            }
            if (gamepad1.x) {
                robot.intakeMotorPower.set(-intakeDrivePower);
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
            // TODO: get rid of linearSlidesRotate in the whole code
            //TODO: fix Noam Teleop to work

            //if (gamepad1.left_trigger > 0.5) {
               // robot.linearSlidesDrive.set(linSlideDrivePower);
                //if robot encoder value is a certain number stop turning motor to prevent damage
//                if(LinSlidesDriveCurrentPos = EncoderValue){
//                    robot.linearSlidesDrive.stopMotor();



            telemetry.addData("Lin Encdr ", robot.linearSlidesDrive.getCurrentPosition());

            //if robot encoder value is a certain number stop turning motor to prevent damage
            //TODO: Grab Encoder values for linear slide drive motor
            /*if(LinSlidesDriveCurrentPos = extend 5780 || LinSlidesDriveCurrentPos = retract EncoderValue)){
             //                    robot.linearSlidesDrive.stopMotor();
             }
             * double linsldpwr = gamepad1.right_trigger;
             *
             */
            // Extend Linear Slide
            if (gamepad1.right_trigger > 0.1) {
                robot.linearSlidesDrive.set(-0.15);
            } else {
                robot.linearSlidesDrive.set(0);
            }
            // Retract Linear Slide b
            if (gamepad1.left_trigger > 0.1) {
                robot.linearSlidesDrive.set(.15);
            } else {
                robot.linearSlidesDrive.set(0);
            }
//
//            if(robot.linearSlidesDrive.getCurrentPosition()>5779 || robot.linearSlidesDrive.getCurrentPosition()<-309){
//                robot.linearSlidesDrive.set(0);
//            }


//            //robot.linearSlidesRotate.set(0);
//            robot.linearSlidesDrive.set(0);
//            if (gamepad1.left_trigger > 0.5) {
//                if (gamepad1.y) {
//                    //robot.linearSlidesRotate.set(0);
//                    //robot.linearSlidesRotate.set(linSlideRotatePower);
//                } else if (gamepad1.a) {
//                    //robot.linearSlidesRotate.set(0);
//                    //robot.linearSlidesRotate.set(-linSlideRotatePower);
//                } else {
//                    //robot.linearSlidesRotate.set(0);
//                    robot.linearSlidesDrive.set(linSlideDrivePower);
//                }
//            } else if (gamepad1.right_trigger > 0.5) {
//                if (gamepad1.a) {
//                    //robot.linearSlidesRotate.set(0);
//                    //robot.linearSlidesRotate.set(linSlideRotatePower);
////                } else if (gamepad1.a) {
////                    robot.linearSlidesRotate.set(0);
////                    robot.linearSlidesRotate.set(-linSlideRotatePower);
//                } else {
//                    //robot.linearSlidesRotate.set(0);
//                    robot.linearSlidesDrive.set(-linSlideDrivePower);
//                }
//            }
            telemetry.addData("Linear Slide Power: ", robot.linearSlidesDrive.getVelocity());
//        telemetry.addData("LTrigger: ", gamepad1.left_trigger);
//        telemetry.addData("RTrigger: ", gamepad1.right_trigger);


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

            robot.pivotTurnLeft(gamepad1.left_bumper);
            robot.pivotTurnRight(gamepad1.right_bumper);

            //Strafing controls (thanks Nick)
            robot.octoStrafe(gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
            telemetry.update();
        }
    }