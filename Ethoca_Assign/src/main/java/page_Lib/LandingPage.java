package page_Lib;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LandingPage {
	
	public WebDriver driver;
	public Actions action;
	public WebDriverWait wait;

	
	@FindBy(xpath="//a[contains(@title,'Women')]")
	WebElement Women ; 
	
	@FindBy(xpath="//a[contains(text(),'Summer Dresses')]")
	WebElement SummerDress ;
	
	
	public LandingPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	public String validateLandingPageTitle()
	 {
		 return driver.getTitle();
	 }
	
      
	 public SummerDresses Lnk_SummDress()
	 { 
		    action= new Actions(driver);
		    action.moveToElement(Women).perform();
		    wait = new WebDriverWait(driver,10);
		    wait.until(ExpectedConditions.visibilityOf(SummerDress)).click();
		     return new SummerDresses(driver);
	 }
	 
	 
	
	 
	 
	 
	
	 
	 
	

		 

	
	
}
