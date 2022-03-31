package Team7159.OpModes.FreightFrenzy;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Team7159.ComplexRobots.Arnold;
import Team7159.Enums.Direction;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "BLUE CAROUSEL DEPO Parking")
public class AutoShippingHub_CAROUSELDEPO_BLUE extends LinearOpMode {

    public Arnold robot = new Arnold();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        waitForStart();
//        drive(-1, .75);
//        armRotate(.7, .65);
//        sleep(500);
//        armRotate(-.7, .65);
//        drive(1,.8);
//        robot.LFMotor.set(-1);
//        robot.LBMotor.set(-1);
//        sleep(1200);
//        drive(1, 2);
//        sleep(1000);
//        strafe2(Direction.RIGHT,1,.9);
//        sleep(500);
//        carouselSpin(1, 3);
//        sleep(500);
        strafe2(Direction.LEFT, 1, 1.8);
        sleep(500);
        drive(1,1);
        sleep(500);
        strafe2(Direction.RIGHT, 1, 1);
        sleep(500);
        carouselSpin(.5,5);
        sleep(500);
        strafe2(Direction.LEFT, 1, 1);

    }

    private void drive(double pow, double time) {
        double t = time*1000;
        int t1 = (int)t;
        robot.LFMotor.set(pow);
        robot.RFMotor.set(pow);
        robot.LBMotor.set(pow);
        robot.RBMotor.set(pow);
        sleep(t1);
        stopMotors();
    }

    private void armRotate(double power, double time){
        robot.armRotation.set(-power);
        sleep((int)(time*1000));
        robot.armRotation.set(0);

        if(robot.armRotation.getCurrentPosition() >= 650){
            robot.armRotation.set(0);
        }
    }

    private void stopMotors(){
        robot.stop();
    }

    public void strafe2(Direction direction, double power, double t) {
        if(direction == Direction.LEFT) {
            robot.LFMotor.set(-power);
            robot.RFMotor.set(power);
            robot.LBMotor.set(power);
            robot.RBMotor.set(-power);
        } else if(direction == Direction.RIGHT) {
            robot.LFMotor.set(power);
            robot.RFMotor.set(-power);
            robot.LBMotor.set(-power);
            robot.RBMotor.set(power);
        }
        sleep((int)t*1000);
        stopMotors();
    }

    public void carouselSpin(double power, double time){
        robot.carouselMotor.set(-power);
        sleep((int)time*1000);
    }

}
