package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Team7159.ComplexRobots.Arnold;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Noam - Freight Frenzy TeleOp")

public class Noam_TerminatorTeleOp extends LinearOpMode {

    public Arnold robot = new Arnold();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        //Stuff to do
        //TODO: Add More Strafe Speeds

        //Stuff Done but not tested
        //TODO: Ducking Motor
        //TODO: Pivot Turn
        //TODO: Octostrafe
        //TODO: Intake Toggles
        //TODO: Rotate Output

        //Stuff Done
        //TODO: Everything.

        //y - Lower Intake(toggle)
        //a - bucket drop
        //b - Carousel motor
        //rb/lb  - change robot heading
        //right stick L/R/F/B - Strafe
        //trigger left - rotate output out
        //trigger right - rotate output in
        //Drive and Steer - F/B/L/R left stick

        //drive controls
        double accel;
        double rotate;
        double powR;
        double powL;
        double maxPower = 1;
        //intake
        boolean intakeActive = false;
        //MAGIC NUMBER
//        final int intakeLowered = -300;
        int intakeTarget = 0;
        double intakeDrivePower = -1;
        double carouselMotorPower = -1;
        //robot.linearSlidesDrive.resetEncoder();

        boolean intakeToggle = false;


        while (opModeIsActive()) {
            int intakeMotorRotationCurrentPos = robot.intakeMotorRotation.getCurrentPosition();
            //int LinSlidesDriveCurrentPos = robot.linearSlidesDrive.getCurrentPosition();

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

            // Carousel(Duck) Motor
            if (gamepad1.b) {
                robot.carouselMotor.set(carouselMotorPower);
            } else {
                robot.carouselMotor.set(0);
            }


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

            //TODO: Output

            if(gamepad1.left_trigger > 0.05) {
                robot.linearSlidesDrive.set(maxPower * gamepad1.left_trigger);
            }

            if(gamepad1.right_trigger > 0.05) {
                robot.linearSlidesDrive.set(-maxPower * gamepad1.right_trigger);
            }


            accel = -gamepad1.left_stick_y;

            //Left Stick--Rotation
            rotate = gamepad1.left_stick_x;

            if (gamepad1.left_bumper) {
                rotate += 0.2;
            } else {
                rotate -= 0.2;
            }

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

            boolean forward = false;
            boolean backward = false;
            boolean rightward = false;
            boolean leftward = false;

            if (gamepad1.right_stick_y > 0.5) {
                forward = true;
            } else if (gamepad1.right_stick_y < -0.5) {
                backward = true;
            }

            if (gamepad1.right_stick_x > 0.5) {
                rightward = true;
            } else if (gamepad1.right_stick_x < -0.5) {
                leftward = true;
            }

            // pivot turn
            robot.pivotTurn(1, gamepad1.right_bumper, gamepad1.left_bumper);

            //Strafing controls (thanks Nick)
            robot.octoStrafe(forward, backward, leftward, rightward);
            telemetry.update();
        }
    }
}