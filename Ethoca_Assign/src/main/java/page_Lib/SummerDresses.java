package page_Lib;


import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SummerDresses {
	
	public WebDriver driver;
	public Actions action;
	public WebDriverWait wait;
	
	@FindBy(xpath="//img[@title='Printed Chiffon Dress']")
	WebElement PrintedShiffonDress ; 
	
	@FindBy(xpath="//*[contains(text(),'Cart')]")
	WebElement Lnk_Cart ; 
	
	@FindBy(xpath="//*[contains(text(),'Check out')]")
	WebElement Lnk_Chkout ; 
	
	public SummerDresses(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validateSummerDressesPageTitle(){
		 return driver.getTitle();
	 }
	
	public PrintedShiffonDress_Frame MovetoLnknClick_PrntdShiffon(){
		 action = new Actions(driver);
		 action.moveToElement(PrintedShiffonDress).click().perform();
		 return new PrintedShiffonDress_Frame(driver);
	 }
	
	public ShopCartSummary MovetoCartnChkout(){
		wait = new WebDriverWait(driver,30);
				
		 action = new Actions(driver);
		 action.moveToElement(Lnk_Cart).perform();
		 wait.until(ExpectedConditions.visibilityOf(Lnk_Chkout)).click();
		 
		 
		 return new ShopCartSummary(driver);
	 }
	
	

	
	

}
