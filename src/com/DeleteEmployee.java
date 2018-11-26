package com;

import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DeleteEmployee {

	Statement  Stm;
	
	        String Employee1 = "delete from  dbo.mstr_Employee where EmpId='MAL1'";
			String Employee2 = "delete from  dbo.mstr_Employee where EmpId='MAL2'";
			String Employee3 = "delete from  dbo.mstr_Employee where EmpId='MAL3'";
			String Employee4 = "delete from  dbo.mstr_Employee where EmpId='MAL4'";
			String Employee5 = "delete from  dbo.mstr_Employee where EmpId='MAL5'";
			String Employee6 = "delete from  dbo.mstr_Employee where EmpId='MAL6'";
			String Employee7 = "delete from  dbo.mstr_Employee where EmpId='MAL7'";
			String Employee8 = "delete from  dbo.mstr_Employee where EmpId='MAL8'";
			String Employee9 = "delete from  dbo.mstr_Employee where EmpId='MAL9'";
			String Employee10 = "delete from  dbo.mstr_Employee where EmpId='MAL10'";
			String Employee11 = "delete from  dbo.mstr_Employee where EmpId='MAL11'";
			String Employee12 = "delete from  dbo.mstr_Employee where EmpId='MAL12'";
			String Employee13 = "delete from  dbo.mstr_Employee where EmpId='MAL13'";
			String Employee14 = "delete from  dbo.mstr_Employee where EmpId='MAL14'";
			String Employee15 = "delete from  dbo.mstr_Employee where EmpId='MAL15'";

			
		   String Hosptialname="delete from Mstr_MultipleHospital where Hospital_Name='MALARHOSPITAL'";
	       String Healthpostname="delete from Mstr_MultipleHospital where Hospital_Name='MALARHEALTHPOST'";
	       String Dispensaryname="delete from Mstr_MultipleHospital where Hospital_Name='MALARDISPENSARY'";
	       String HosptialAdmin ="delete from mstr_Employee where Name='RINNUKUMAR'";
	       String HealthpostAdmin="delete from mstr_Employee where Name='ROCKY'";
	       String DispensaryAdmin="delete from mstr_Employee where Name='MINNUKUMAR'";
	       String HealthpostReg ="delete from Mstr_HealthpostReg where HealthpostName='MALARHEALTHPOST'";
	       String DispensaryReg ="delete from Mstr_DispensaryReg where Dispensaryname='MALARDISPENSARY'";
					
	
	
    WebDriver	driver;   
  @Test
public void deletehospital() throws SQLException
	
	{
	 // driver=new FirefoxDriver();
		SQLServerDataSource del=new SQLServerDataSource();
		del.setUser("sa");
		del.setPassword("Disp123");
		del.setServerName("192.168.137.1");
		del.setDatabaseName("Multihospital_Testing2017");
		del.getConnection();
		Stm=del.getConnection().createStatement();
	
		try {
			Stm.executeQuery(Employee1+Employee2+Employee3+Employee4+Employee5+Employee6+Employee7+Employee8+Employee9+Employee10+Employee11+Employee12+Employee13+Employee14+Employee15+Hosptialname+Healthpostname+Dispensaryname+HealthpostAdmin+HosptialAdmin+DispensaryAdmin+HealthpostReg+DispensaryReg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		  //driver.close();
	}

	   
}



