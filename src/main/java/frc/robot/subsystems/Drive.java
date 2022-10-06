package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.lib.geometry.Twist2d;
import frc.robot.Constants;
import frc.robot.Kinematics;
import frc.robot.Robot;
import frc.lib.util.DriveSignal;
import frc.lib.util.Util;

public class Drive extends Subsystem {
    private static Drive mInstance;

    public static Drive getInstance() {
        if (mInstance == null) {
            mInstance = new Drive();
        }

        return mInstance;
    }

    public static class PeriodicIO {
        public double right_demand;
        public double left_demand;
    }

    private PeriodicIO mPeriodicIO = new PeriodicIO();

    private final WPI_TalonSRX mRightMaster;
    private final WPI_TalonSRX mRightSlave;
    private final WPI_TalonSRX mLeftMaster;
    private final WPI_TalonSRX mLeftSlave;

    private DifferentialDrive differentialDrive;

    private Drive() {
        
        mRightMaster = new WPI_TalonSRX(Constants.kDriveRightMasterId);
        mRightSlave = new WPI_TalonSRX(Constants.kDriveRightSlaveId);
        mLeftMaster = new WPI_TalonSRX(Constants.kDriveLeftMasterId);
        mLeftSlave = new WPI_TalonSRX(Constants.kDriveLeftSlaveId);

        mRightSlave.follow(mRightMaster);
        mLeftSlave.follow(mLeftMaster);

        mLeftMaster.setInverted(true);
        mLeftSlave.setInverted(true);

        differentialDrive = new DifferentialDrive(mLeftMaster, mRightMaster);

    }

    public void tankDrive(double moveSpeed, double rotationSpeed) {

        differentialDrive.tankDrive(moveSpeed, rotationSpeed);

    }

    public void setOpenLoop(DriveSignal signal) {
        mPeriodicIO.right_demand = signal.getRight();
        mPeriodicIO.left_demand = signal.getLeft();
    }

    @Override
    public void stop() {
        mRightMaster.set(ControlMode.PercentOutput, 0.0);
        mLeftMaster.set(ControlMode.PercentOutput, 0.0);
    }

    @Override
    public boolean checkSystem() {
        return true;
    }

    @Override
    public void outputTelemetry() {}
}