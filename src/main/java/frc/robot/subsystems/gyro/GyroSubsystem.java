package frc.robot.subsystems.gyro;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;

public class GyroSubsystem extends SubsystemBase {

  public AHRS ahrs;

  public GyroSubsystem() {

        SmartDashboard.putString("subsystem", "init gyro sub");
        try {
			/* Communicate w/navX-MXP via the MXP SPI Bus (use mini USB to USB A cable)   
			   Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or S     
			   See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
               ahrs = new AHRS(I2C.Port.kMXP); 
		} catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true); 
        }

        SmartDashboard.putNumber("init angle", ahrs.getAngle());
    }

    public double getGyroAngle(){
        return ahrs.getAngle();
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("gyro", this.getGyroAngle());
    }
}