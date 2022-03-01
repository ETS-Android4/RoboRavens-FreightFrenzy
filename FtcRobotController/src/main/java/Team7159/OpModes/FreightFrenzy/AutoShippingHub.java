package Team7159.OpModes.FreightFrenzy;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Team7159.ComplexRobots.Arnold;
import Team7159.Enums.Direction;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Shipping Hub Auto")
public class AutoShippingHub extends LinearOpMode {

    public Arnold robot = new Arnold();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        waitForStart();

        drive(-1, .7);
        armRotate(.65, 1);
        sleep(1000);
        armRotate(-.65, 1);
        drive(1,.7);
        // go to parking
        robot.octoStrafe(false, false, true, false);
        sleep(3000);
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

}
