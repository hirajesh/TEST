package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class EChallan {

	
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
public void deletehospital() throws SQLException, IOException

{
// driver=new FirefoxDriver();
SQLServerDataSource del=new SQLServerDataSource();
del.setUser("sa");
del.setPassword("Disp123");
del.setServerName("192.168.137.1");
del.setDatabaseName("Multihospital_Testing2017");
del.getConnection();
Stm=del.getConnection().createStatement();

File Src=new File("C:\\Users\\Quality Analyst\\Desktop\\Latest Sections & Fines Amount.xls");
FileInputStream inputkudupom=new FileInputStream(Src);
XSSFWorkbook data=new  XSSFWorkbook(inputkudupom);
XSSFSheet sheetsolupa=data.getSheetAt(1);
int rowcount=sheetsolupa.getLastRowNum();

for(int r=0;r<=rowcount;r++)
{
	String data0=sheetsolupa.getRow(r).getCell(0).getStringCellValue();
	String data1=sheetsolupa.getRow(r).getCell(1).getStringCellValue();
	String data2=sheetsolupa.getRow(r).getCell(2).getStringCellValue();
	String data3=sheetsolupa.getRow(r).getCell(3).getStringCellValue();
	String data4=sheetsolupa.getRow(r).getCell(4).getStringCellValue();
	String data5=sheetsolupa.getRow(r).getCell(5).getStringCellValue();
	String data6=sheetsolupa.getRow(r).getCell(6).getStringCellValue();
	String data7=sheetsolupa.getRow(r).getCell(7).getStringCellValue();
	String data8=sheetsolupa.getRow(r).getCell(8).getStringCellValue();
	String data9=sheetsolupa.getRow(r).getCell(9).getStringCellValue();
	String data10=sheetsolupa.getRow(r).getCell(10).getStringCellValue();
	String data11=sheetsolupa.getRow(r).getCell(11).getStringCellValue();
	String data12=sheetsolupa.getRow(r).getCell(12).getStringCellValue();
	String data13=sheetsolupa.getRow(r).getCell(13).getStringCellValue();
	String data14=sheetsolupa.getRow(r).getCell(14).getStringCellValue();
	String data15=sheetsolupa.getRow(r).getCell(15).getStringCellValue();
	String data16=sheetsolupa.getRow(r).getCell(16).getStringCellValue();
	String data17=sheetsolupa.getRow(r).getCell(17).getStringCellValue();
	String data18=sheetsolupa.getRow(r).getCell(28).getStringCellValue();
	







try {
	Stm.executeQuery(data1+data2+data3+data4+data5+data6+data7+data8+data9+data10+data11+data12+data13+data14+data15+data16+data17+data18);
} catch (Exception e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
}
  //driver.close();
}
}


}
