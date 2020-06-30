import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegisterFormUsingSeleniumAndExcel {
    public static void main(String s[]) throws IOException {
        System.setProperty("webdriver.chrome.driver","/Users/driveu/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        FileInputStream file = new FileInputStream("/Users/driveu/Downloads/EmpDataSel.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Sheet1");

        int noofrows = sheet.getLastRowNum();
        System.out.println(noofrows);
        for(int row=1;row<=noofrows;row++)
        {
            XSSFRow current_row = sheet.getRow(row);
            String First_Name = current_row.getCell(0).getStringCellValue();
            String Last_Name = current_row.getCell(1).getStringCellValue();
            int Phone = (int)current_row.getCell(2).getNumericCellValue();
            String Email = current_row.getCell(3).getStringCellValue();
            String Address = current_row.getCell(4).getStringCellValue();
            String City = current_row.getCell(5).getStringCellValue();
            String State = current_row.getCell(6).getStringCellValue();
            String Country = current_row.getCell(7).getStringCellValue();
            int Pin_Code = (int)current_row.getCell(8).getNumericCellValue();
            String UserName = current_row.getCell(9).getStringCellValue();
            String Password = current_row.getCell(10).getStringCellValue();

            driver.findElement(By.linkText("REGISTER")).click();
            driver.findElement(By.name("firstname")).sendKeys(First_Name);
            driver.findElement(By.name("lastname")).sendKeys(Last_Name);
            driver.findElement(By.name("phone")).sendKeys(String.valueOf(Phone));
            driver.findElement(By.id("userName")).sendKeys(Email);
            driver.findElement(By.name("REGISTER")).sendKeys(Address);
            driver.findElement(By.name("city")).sendKeys(City);
            driver.findElement(By.name("state")).sendKeys(State);
            driver.findElement(By.name("postalCode")).sendKeys(String.valueOf(Pin_Code));
            Select country1 = new Select(driver.findElement(By.name(Country)));
            country1.selectByVisibleText("INDIA");
            driver.findElement(By.name("email")).sendKeys(UserName);
            driver.findElement(By.name("password")).sendKeys(Password);
            driver.findElement(By.name("confirmPassword")).sendKeys(Password);
            driver.findElement(By.name("register")).click();

            if(driver.getPageSource().contains("Thank you for registering"))
            {
                System.out.println("Registeration Complete"+ row + "record");
            }
            else
            {
                System.out.println("registration Failed");
            }
        }
        System.out.println("Data Driven Test Complete");
        driver.close();
        driver.quit();
        file.close();
    }
}

//Integer.parseInteger(actual_value)==expected_value
//Double.parseDouble(Actual_Value)==expected_value
//String.parseString(Actual_Value)==expected_value
