package page_Lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContnShopWin {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	
	@FindBy(xpath="//span[@class='continue btn btn-default button exclusive-medium']/span[1]")
	WebElement contnshopnbttn;
	
	public ContnShopWin(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public SummerDresses clickcontinueshopwin(){
		
		 wait = new WebDriverWait(driver,30);
		 String newWin= driver.getWindowHandle();
		 driver.switchTo().window(newWin);
		 
	
		 wait.until(ExpectedConditions.visibilityOf(contnshopnbttn));
		 
		 
		action = new Actions(driver);
		action.moveToElement(contnshopnbttn).click().perform();
		 
		 //contnshopnbttn.click();
		 
		 return new SummerDresses(driver);
	}

}
