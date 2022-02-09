package Team7159.ComplexRobots;

/**
 * Created by Joshua Charat-Collins, 2020-2021
 * Robot used in Ultimate Goal.
 * screw covid lmao.
 */
//TODO: FTCLib MotorGroup integration

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.*;

import com.qualcomm.robotcore.hardware.HardwareMap;

import Team7159.BasicRobots.BasicMecanum;

public class FlywheelBot extends BasicMecanum {

    public MotorEx flywheelMotor;
    public MotorEx platformMotor;

    public MotorEx intakeMotor;
    public MotorEx clawMotor;

    public ServoEx flywheelServo;
    public ServoEx intakeServo;
    public ServoEx clawServo;

    public void init(HardwareMap Map) {

        super.init(Map);

        flywheelMotor = new MotorEx(Map, "flywheelMotor");
        platformMotor = new MotorEx(Map, "platformMotor");
        clawMotor = new MotorEx(Map, "clawMotor");

        intakeMotor = new MotorEx(Map, "intakeMotor");

        flywheelServo = new SimpleServo(Map, "flywheelServo");
        clawServo = new SimpleServo(Map, "clawServo");
        intakeServo = new SimpleServo(Map, "intakeServo");

        flywheelMotor.setInverted(true);

        flywheelMotor.setRunMode(Motor.RunMode.RawPower);
        intakeMotor.setRunMode(Motor.RunMode.RawPower);
        platformMotor.setRunMode(Motor.RunMode.PositionControl);
        platformMotor.setPositionCoefficient(0.05);
        platformMotor.setPositionTolerance(5);
        clawMotor.setRunMode(Motor.RunMode.RawPower);

        flywheelMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        platformMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        clawMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        flywheelMotor.set(0);
        intakeMotor.set(0);
        platformMotor.set(0);
        clawMotor.set(0);

        flywheelServo.setRange(0.21, 0.65);
        intakeServo.setPosition(0.0);

        //:crab: william is gone :crab:
    }
}
