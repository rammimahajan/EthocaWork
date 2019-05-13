package page_Lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintedShiffonDress_Frame {

	public WebDriver driver;
	public Actions action;
	public Select select;
	public WebDriverWait wait;
	
	@FindBy(id="group_1")
	WebElement Sizedd ;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement AddtoCart ;
	
	@FindBy(tagName="iframe")
	WebElement dFrame;
	
	
	public PrintedShiffonDress_Frame(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ContnShopWin SelectSizenAddCart(){
		driver.switchTo().frame(dFrame);
		
		select = new Select(Sizedd);
		
		select.selectByVisibleText("M");
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(AddtoCart)).click();
		
		return new ContnShopWin(driver);
	}
	
	
	
	
}
