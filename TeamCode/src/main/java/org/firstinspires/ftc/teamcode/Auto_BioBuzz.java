package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Auto_BioBuzz", group = "Autonomous")
public class Auto_BioBuzz extends LinearOpMode {

    DcMotor driveFL, driveFR, driveRL, driveRR;
    DcMotor intake, shooter;
    DcMotor gecko, sushi;

    @Override
    public void runOpMode() {
        driveFL = hardwareMap.get(DcMotor.class, "driveFL");
        driveFR = hardwareMap.get(DcMotor.class, "driveFR");
        driveRL = hardwareMap.get(DcMotor.class, "driveRL");
        driveRR = hardwareMap.get(DcMotor.class, "driveRR");

        intake = hardwareMap.get(DcMotor.class, "intake");
        shooter = hardwareMap.get(DcMotor.class, "shooter");
        gecko = hardwareMap.get(DcMotor.class, "gecko");
        sushi = hardwareMap.get(DcMotor.class, "sushi");

        driveFR.setDirection(DcMotorSimple.Direction.REVERSE);
        driveRR.setDirection(DcMotorSimple.Direction.REVERSE);
        gecko.setDirection(DcMotorSimple.Direction.REVERSE);
        sushi.setDirection(DcMotorSimple.Direction.REVERSE);

        driveFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveRL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveRR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        if (opModeIsActive()) {
            setDrive(0.4, 0.4, 0.4, 0.4);
            sleep(1200);
            stopDrive();

            shooter.setPower(1.0);
            sleep(1500);

            gecko.setPower(1.0);
            sushi.setPower(1.0);
            sleep(1500);

            shooter.setPower(0);
            gecko.setPower(0);
            sushi.setPower(0);

            setDrive(0.5, -0.5, -0.5, 0.5);
            sleep(1000);
            stopDrive();
        }
    }

    void setDrive(double fl, double fr, double rl, double rr) {
        driveFL.setPower(fl);
        driveFR.setPower(fr);
        driveRL.setPower(rl);
        driveRR.setPower(rr);
    }

    void stopDrive() {
        setDrive(0, 0, 0, 0);
    }
}
