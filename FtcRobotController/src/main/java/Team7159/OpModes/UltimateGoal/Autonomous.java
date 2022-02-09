//TODO: Refactor

//package Team7159.OpModes.UltimateGoal;
//
//import com.arcrobotics.ftclib.hardware.motors.Motor;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//
//import Team7159.ComplexRobots.FlywheelBot;
//import Team7159.Enums.Direction;
//
//@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Autonomous")
//public class Autonomous extends LinearOpMode {
//
//    private FlywheelBot robot = new FlywheelBot();
//
//    @Override
//    public void runOpMode() {
//        robot.init(hardwareMap);
//
//        robot.intakeServo.setRange(0.34, 0.80);
//        robot.intakeServo.setPosition(0.0);
//
//        robot.flywheelServo.setPosition(1.0);
//
//        waitForStart();
//
//        robot.platformMotor.resetEncoder();
//
//        robot.platformMotor.setRunMode(Motor.RunMode.PositionControl);
//        robot.platformMotor.setTargetPosition(166);
//        robot.platformMotor.set(0.075);
//
//        drive(0.5, 2);
//
//        //drive up to line
//        sleep(500);
//
//        //fire
//        readyFlywheel();
//
//        robot.LFMotor.set(0.15);
//        robot.LBMotor.set(0.15);
//        robot.RFMotor.set(-0.15);
//        robot.RBMotor.set(-0.15);
//
//        sleep(600);
//        stopMotors();
//
//        fireRing();
//        fireRing();
//        drive(1, 0.1);
//        drive(-1, 0.2);
//        sleep(1000);
//        fireRing();
//        sleep(2000);
//        unreadyFlywheel();
//
//        //drive onto line
//        drive(0.5, 0.75);
//    }
//
//    private void drive(double pow, double time) {
//        double t = time*1000;
//        int t1 = (int)t;
//        robot.LFMotor.set(pow);
//        robot.RFMotor.set(pow);
//        robot.LBMotor.set(pow);
//        robot.RBMotor.set(pow);
//        sleep(t1);
//        stopMotors();
//    }
//
//    private void stopMotors(){
//        robot.stop();
//    }
//
//    public void strafe2(Direction direction, double power, int t) {
//        if(direction == Direction.LEFT) {
//            robot.LFMotor.set(-power);
//            robot.RFMotor.set(power);
//            robot.LBMotor.set(power);
//            robot.RBMotor.set(-power);
//        } else if(direction == Direction.RIGHT) {
//            robot.LFMotor.set(power);
//            robot.RFMotor.set(-power);
//            robot.LBMotor.set(-power);
//            robot.RBMotor.set(power);
//        }
//        sleep(t*1000);
//        stopMotors();
//    }
//
//    public void readyFlywheel() {
//        robot.flywheelMotor.set(0.49);
//        sleep(3000);
//    }
//    public void unreadyFlywheel() {
//        robot.platformMotor.setTargetPosition(0);
//        robot.platformMotor.set(0.075);
//        robot.flywheelMotor.set(0.0);
//        sleep(2000);
//    }
//    public void fireRing() {
//        robot.flywheelServo.setPosition(0.0);
//        sleep(500);
//        robot.flywheelServo.setPosition(1.0);
//        sleep(750);
//    }
//}
