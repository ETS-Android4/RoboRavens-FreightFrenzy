package Team7159.ComplexRobots;

/**
 * Created by Joshua Charat-Collins, 2020-2021
 * Robot used in Ultimate Goal.
 * This season sucked.
 */

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;

import Team7159.BasicRobots.BasicMecanum;

public class FlywheelBot2 extends BasicMecanum {

    public MotorEx flywheelMotor;
    public MotorEx platformMotor;

    public MotorEx intakeMotor;

    public ServoEx flywheelServo;
    public ServoEx intakeServo;
    public ServoEx clawServo;

    public void init(HardwareMap Map) {

        super.init(Map);

        flywheelMotor = new MotorEx(Map, "flywheelMotor");
        platformMotor = new MotorEx(Map, "platformMotor");

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

        flywheelMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        platformMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        flywheelMotor.set(0);
        intakeMotor.set(0);
        platformMotor.set(0);

        flywheelServo.setRange(0.21, 0.65);
        intakeServo.setPosition(0.0);

        //:crab: william is gone :crab:
    }
}
