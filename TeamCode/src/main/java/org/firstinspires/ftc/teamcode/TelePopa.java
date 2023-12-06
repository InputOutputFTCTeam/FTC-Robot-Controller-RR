package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TelePopaZadrota", group = "Actual")
@Disabled
public class TelePopa extends LinearOpMode {
    double k = 0.4;
    double servoPos;
    public Servo intakeL, intakeR;
    public Servo ssl, ssr;
    public DcMotor TL, TR, BL, BR;
    public DcMotor lift;

    @Override
    public void runOpMode() {
        Methods methods = new Methods(hardwareMap);



        ssl = hardwareMap.servo.get("ssl");
        ssr = hardwareMap.servo.get("ssr");


        telemetry.addLine("Ready to start");

        waitForStart();
        while (opModeIsActive()){



            if(gamepad1.left_bumper){
                k = 0.4;
            }

            if(gamepad1.right_bumper){
                k = 0.5;
            }

            methods.move(
                    -gamepad1.right_stick_x,
                    gamepad1.right_trigger - gamepad1.left_trigger + gamepad1.right_stick_y,
                    -gamepad1.left_stick_x,
                    k
            );


            if (gamepad2.dpad_up) {
                ssl.setPosition(0.6);
                ssr.setPosition(1-0.6);
            }

            if (gamepad2.dpad_down) {
                ssl.setPosition(0.725);
                ssr.setPosition(1-0.725);
            }


        }
    }
}
