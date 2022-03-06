package Team7159.OpModes.FreightFrenzy;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Team7159.ComplexRobots.Arnold;
import Team7159.Enums.Direction;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Carousel Auto Blue")
public class AutoCarouselBlue extends LinearOpMode {

    private Arnold robot = new Arnold();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        waitForStart();

        // get to carousel
        drive(-1, .3);
        sleep(500);
        robot.octoStrafe(false, false, true, false);
        sleep(3500);
        drive(1, 2);
        sleep(500);
        // spin carousel
        carouselSpin(-1,5);
        // return to start
//        robot.octoStrafe(false, false, false, true);
//        sleep(3500);
//        drive(1, .3);
//        //return to warehouse
//        strafe2(Direction.RIGHT, 1, 0.75);
//        drive(1, 3);
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
