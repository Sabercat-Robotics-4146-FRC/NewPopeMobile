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

	XboxController controller = new XboxController(0);
	Joystick rightJoystick = new Joystick(0);
	Joystick leftJoystick = new Joystick(1);

	Looper mEnabledLooper = new Looper();
	Looper mDisabledLooper = new Looper();
	
	private final SubsystemManager mSubsystemManager = SubsystemManager.getInstance();

	private Drive mDrive;
	
	private Joystick mDriveStick;

	@Override
	public void robotInit() {

		mDrive = Drive.getInstance();
		mSubsystemManager.setSubsystems(mDrive);

		mDriveStick = new Joystick(Constants.kDriveStickPort);

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
		//mDrive.setCheesyishDrive(mThrottleStick.getRawAxis(1), -mTurnStick.getRawAxis(0), mTurnStick.getRawButton(1));
		mDrive.setCheesyishDrive(mDriveStick.getRawAxis(1), -mDriveStick.getRawAxis(4), mDriveStick.getRawButton(1));
	}
}
