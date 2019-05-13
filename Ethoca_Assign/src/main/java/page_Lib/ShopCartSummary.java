package page_Lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopCartSummary {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']/span[contains(text(),'Proceed to checkout')]")
    WebElement proceedtoChkout;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement email;
	
	@FindBy(xpath="//*[@id='SubmitCreate']")
	WebElement Btn_CreateAccount;
	
	@FindBy(id="cgv")
	WebElement Chkbx_Terms;
	
	@FindBy(xpath="//*[contains(text(),'Printed Chiffon Dress')]")
	WebElement ValidateProduct;
	
	@FindBy(id="total_product")
	WebElement ValidatePrice;
	
	@FindBy(id="total_price")
	WebElement ValidateTotalPrice;
	
	
	
	public ShopCartSummary(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Summary(){
		proceedtoChkout.click();
	}
	
	
	public void TermsChkbx(){
		Chkbx_Terms.click();
	}
	
	public String ProductdVerify(){
		return ValidateProduct.getText();
	}
	
	public String ProductdPriceVerify(){
		return ValidatePrice.getText();
	}
	
	public String ProductdTotalPriceVerify(){
		return ValidateTotalPrice.getText();
	}

	
	public RegPage Auth(String sndkeys){
	    email.sendKeys(sndkeys);
	    Btn_CreateAccount.click();
	    return new RegPage(driver);
	    
	}
	
	
	
	
	
}
