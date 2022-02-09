package Team7159.LegacyRobots;

/**
 * Created by Joshua Charat-Collins, 2020-2021
 * Testing robot used in Ultimate Goal.
 * This season sucked.
 */

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import Team7159.BasicRobots.BasicMecanum;
import Team7159.Enums.Direction;
import Team7159.Enums.Version;
import Team7159.LegacyRobots.MecanumV2;
import Team7159.Utils.MotorGroup;
import Team7159.Utils.RobotComp;
import Team7159.Utils.RobotMath;

public class EncoderRead extends BasicMecanum {

    public DcMotorEx flywheelMotor;

    public DcMotor platformMotor;
    public DcMotor intakeMotor;
    public DcMotor clawMotor;

    public Servo flywheelServo;
    public Servo intakeServo;
    public Servo clawServo;

    public void init(HardwareMap Map) {

        super.init(Map);

        flywheelMotor = Map.get(DcMotorEx.class, "flywheelMotor");

        intakeMotor = Map.dcMotor.get("intakeMotor");
        platformMotor = Map.dcMotor.get("platformMotor");
        clawMotor = Map.dcMotor.get("clawMotor");

        flywheelServo = Map.servo.get("flywheelServo");
        clawServo = Map.servo.get("clawServo");
        intakeServo = Map.servo.get("intakeServo");

        flywheelMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        platformMotor.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
        clawMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        flywheelMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        platformMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        clawMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        flywheelMotor.setPower(0);
        intakeMotor.setPower(0);
        platformMotor.setPower(0);
        clawMotor.setPower(0);

        //:crab: william is gone :crab:


    }
}
