package page_Lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegPage {
	
	WebDriver driver;
	public Select select; 
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement text;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement LastName;
	
	@FindBy(id="passwd")
	WebElement Pwd;
	
	@FindBy(id="address1")
	WebElement Address;
	
	@FindBy(id="city")
	WebElement City;
	
	@FindBy(id="id_state")
	WebElement State;
	
	@FindBy(id="postcode")
	WebElement Pin;
	
	@FindBy(id="phone_mobile")
	WebElement MobilePhone;
	
	@FindBy(id="alias")
	WebElement Alias_Address;
	
	@FindBy(xpath="//span[contains(text(),'Register')]")
	WebElement Button_Reg;
	
		
	public RegPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateAccountPage(){
		
	return text.getText();
			
	}
	
	public void RegFormFill(String fname,String lname,String pwd,String add1,String city,String state,String pin,String mobno,String add2){
		
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		Pwd.sendKeys(pwd);
		Address.sendKeys(add1);
		City.sendKeys(city);
		
		select = new Select(State);
		select.selectByVisibleText(state);
		
		Pin.sendKeys(pin);
		MobilePhone.sendKeys(mobno);
		Alias_Address.clear();
		Alias_Address.sendKeys(add2);
		
		Button_Reg.click();
		
		
	}
	
	
	
	
}
