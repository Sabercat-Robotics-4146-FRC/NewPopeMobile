/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.loops.Looper;
import frc.robot.subsystems.Drive;

public class Robot extends TimedRobot {

	private static Joystick mDriveStick = new Joystick(Constants.kDriveStickPort);
	private static Joystick mTurnStick = new Joystick(Constants.kTurnStickPort);

	Looper mEnabledLooper = new Looper();
	Looper mDisabledLooper = new Looper();
	
	private final SubsystemManager mSubsystemManager = SubsystemManager.getInstance();

	public static Drive mDrive;

	@Override
	public void robotInit() {

		mDrive = Drive.getInstance();
		mSubsystemManager.setSubsystems(mDrive);

		mDriveStick = new Joystick(Constants.kDriveStickPort);
		mTurnStick = new Joystick(Constants.kTurnStickPort);

		mSubsystemManager.registerEnabledLoops(mEnabledLooper);
		mSubsystemManager.registerDisabledLoops(mDisabledLooper);
		
	}

	@Override
	public void autonomousInit() {
		mDisabledLooper.stop();
		mEnabledLooper.start();
	}

	@Override
	public void disabledInit() {
		mEnabledLooper.stop();
		mDisabledLooper.start();
	}

	@Override
	public void teleopInit() {
		mDisabledLooper.stop();
		mEnabledLooper.start();
	}

	@Override
	public void teleopPeriodic() {

        mDrive.tankDrive(-mDriveStick.getY(), mTurnStick.getX());

	}
}
