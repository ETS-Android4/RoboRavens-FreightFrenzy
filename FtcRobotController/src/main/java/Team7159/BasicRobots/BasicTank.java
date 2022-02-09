package Team7159.BasicRobots;

import com.arcrobotics.ftclib.hardware.motors.*;

import com.qualcomm.robotcore.hardware.HardwareMap;

import Team7159.Enums.Direction;
import Team7159.Enums.Version;
import Team7159.Utils.MotorGroup;
import Team7159.Utils.RobotComp;
import Team7159.Utils.RobotMath;

public class BasicTank {

    public RobotComp Comp = new RobotComp();

    public MotorGroup Right;
    public MotorGroup Left;


    /*!!NOTE!!
    // Either only the four motors with forward and back or the two motors with just sides will be initialized for each robot
    // This is because we can either do a four wheel drive or a two wheel drive
    //
    */
    public Motor RFMotor;
    public Motor RBMotor;
    public Motor LFMotor;
    public Motor LBMotor;

    public Motor LMotor;
    public Motor RMotor;

    int drive;

    public void init4Drive(HardwareMap Map){

        drive = 4;

        LFMotor = new Motor(Map, "FLDrive");
        LBMotor = new Motor(Map, "BLDrive");
        RFMotor = new Motor(Map, "FRDrive");
        RBMotor = new Motor(Map, "BRDrive");

        LFMotor.setRunMode(Motor.RunMode.RawPower);
        RFMotor.setRunMode(Motor.RunMode.RawPower);
        LBMotor.setRunMode(Motor.RunMode.RawPower);
        RBMotor.setRunMode(Motor.RunMode.RawPower);

        RFMotor.set(0.0);
        RBMotor.set(0.0);
        LFMotor.set(0.0);
        LBMotor.set(0.0);

        LFMotor.setInverted(true);
        LBMotor.setInverted(true);

    }

    public void init2Drive(HardwareMap Map){

        drive = 2;

        LMotor = new Motor(Map, "LDrive");
        RMotor = new Motor(Map, "RDrive");

        LMotor.setRunMode(Motor.RunMode.RawPower);
        RMotor.setRunMode(Motor.RunMode.RawPower);

        LMotor.set(0);
        RMotor.set(0);

        RMotor.setInverted(true);

    }

//    This stuff is all deprecated by the FTCLib update, not sure if we're ever gonna refactor this
//    public void moveStraight(double power){
//        Left.setPowers(power);
//        Right.setPowers(power);
//    }
//
//    public void stop(){
//        Left.stop();
//        Right.stop();
//    }
//
//    public void turn(Direction direction, int degrees){
//        Right.resetEncoders();
//        Left.resetEncoders();
//        int LeftDistance = Comp.computeTurningPos(direction, degrees, Direction.LEFT, 26.5, Version.TWO);
//        int RightDistance = Comp.computeTurningPos(direction, degrees, Direction.RIGHT, 26.5, Version.TWO);
//        Left.setTargetPosition(LeftDistance);
//        Right.setTargetPosition(RightDistance);
//        Left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        Right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        moveStraight(0.5);
//        while(Left.isBusy()&&Right.isBusy()){}
//        stop();
//        Left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        Right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//    }
//
//    public void driveDir(Direction direction, double distance){
//        Right.resetEncoders();
//        Left.resetEncoders();
//        Right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        Left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        switch(direction){
//            case FORWARDS:
//                int pos = -Comp.computePositionD(RobotMath.toMeters(distance), Version.TWO);
//                Right.setTargetPosition(pos);
//                Left.setTargetPosition(pos);
//                break;
//            case BACKWARDS:
//                pos = Comp.computePositionD(RobotMath.toMeters(distance), Version.TWO);
//                Right.setTargetPosition(pos);
//                Left.setTargetPosition(pos);
//                break;
//        }
//        moveStraight(0.5);
//        while(Right.isBusy()&&Left.isBusy()){}
//        stop();
//        Right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        Left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//    }

}
