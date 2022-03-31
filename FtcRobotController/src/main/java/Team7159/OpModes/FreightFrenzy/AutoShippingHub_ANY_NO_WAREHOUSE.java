package Team7159.OpModes.FreightFrenzy;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Team7159.ComplexRobots.Arnold;
import Team7159.Enums.Direction;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "NO WAREHOUSE - Shipping Hub Auto")
public class AutoShippingHub_ANY_NO_WAREHOUSE extends LinearOpMode {

    public Arnold robot = new Arnold();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        waitForStart();
        drive(-0.7, 1.2);
        armRotate(.7, .8);
        sleep(500);
        armRotate(-.65, 1);
        drive(0.7,1.2);
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
