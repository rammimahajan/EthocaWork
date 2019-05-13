package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class ExcelReading {
	
	public XSSFWorkbook wb;
	public XSSFSheet Exsheet;
	public XSSFRow row;
	public XSSFCell cell;
	public Properties property;
	public FileInputStream fs;
	public WebDriver driver;
	
	public WebDriver PropReading() throws IOException{
		property = new Properties(); 
		fs = new FileInputStream("C://Users//TeeBiz//Desktop//Selenium//WORKSPACE//Ethoca_Assign//src//main//java//utilities//prop.properties");
		property.load(fs);
		
       String browsername =	property.getProperty("browser");
       
       if(browsername.equals("chrome"))
       {
       	 System.setProperty("webdriver.chrome.driver", "C://Users//TeeBiz//Desktop//Selenium//Browser Driver//chromedriver_win32//chromedriver.exe");
       	 driver= new ChromeDriver();
       }

       else if (browsername.equals("firefox"))
       {
       	 System.setProperty("webdriver.firefox.marionette","C://Users//TeeBiz//Desktop//Selenium//Browser Driver//geckodriver-v0.23.0-win64//geckodriver.exe");
       	 driver= new FirefoxDriver();
       	}
       
         driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
       
       return driver;
	    
	
	}
	
	/*public XSSFCell excelreading(String SheetName) throws IOException
{
	String FilePath = "C://Users//TeeBiz//Desktop//Selenium//WORKSPACE//Ethoca_Assign//src//test//resources//TestData.xlsx";
	fs = new FileInputStream(FilePath);
	
	wb = new XSSFWorkbook(fs);
	
    String Sheet =	SheetName;
	
	Exsheet = wb.getSheet(Sheet);
	
    XSSFRow row =	Exsheet.getRow(0);
    XSSFCell cell = row.getCell(0);
    
    System.out.println(cell);
    
    return cell;
	
}*/

}