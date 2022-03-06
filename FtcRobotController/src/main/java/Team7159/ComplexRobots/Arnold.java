package Team7159.ComplexRobots;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import Team7159.BasicRobots.BasicMecanum;

public class Arnold extends BasicMecanum {

    public MotorEx armRotation;
    public MotorEx carouselMotor;
    public MotorEx intakeMotorPower;
    public MotorEx intakeMotorRotation;

    public ServoEx bucketTiltServo;

    public void init(HardwareMap Map) {

        super.init(Map);

        armRotation = new MotorEx(Map, "armRotation");
        carouselMotor = new MotorEx(Map, "carouselMotor");

        intakeMotorPower = new MotorEx(Map, "intakeMotorPower");
        intakeMotorRotation = new MotorEx(Map, "intakeMotorRotation");

        bucketTiltServo = new SimpleServo(Map, "bucketTiltServo", 0, 180);

        armRotation.setRunMode(Motor.RunMode.RawPower);
        //linearSlidesDrive.setVeloCoefficients(0.8, 0, 0);
        carouselMotor.setRunMode(Motor.RunMode.RawPower);
        //carouselMotor.setVeloCoefficients(0.8, 0, 0);
        intakeMotorPower.setRunMode(Motor.RunMode.RawPower);

        intakeMotorRotation.setRunMode(MotorEx.RunMode.VelocityControl);
        intakeMotorRotation.setVeloCoefficients(0.80, 0, 0);

        armRotation.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        carouselMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        intakeMotorPower.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        intakeMotorRotation.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        armRotation.set(0);
        armRotation.resetEncoder();

        carouselMotor.set(0);
        carouselMotor.resetEncoder();

        intakeMotorPower.set(0);

        intakeMotorRotation.set(0);
        intakeMotorRotation.resetEncoder();

        bucketTiltServo.setRange(0, 0.7);
        bucketTiltServo.setPosition(0);

    }
}
