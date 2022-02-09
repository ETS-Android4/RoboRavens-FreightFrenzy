package Team7159.ComplexRobots;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import Team7159.BasicRobots.BasicMecanum;

public class TestBot extends BasicMecanum {

    public Motor liftMotor;

    public void init(HardwareMap Map) {

        super.init(Map);

        liftMotor = new Motor(Map, "liftMotor");

        liftMotor.setInverted(false);
        liftMotor.setRunMode(Motor.RunMode.RawPower);
        liftMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        liftMotor.set(0.0);

    }

}
