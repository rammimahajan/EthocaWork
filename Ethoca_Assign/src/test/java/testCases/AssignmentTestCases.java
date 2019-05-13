package testCases;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_Lib.ContnShopWin;
import page_Lib.LandingPage;
import page_Lib.PrintedShiffonDress_Frame;
import page_Lib.RegPage;
import page_Lib.ShopCartSummary;
import page_Lib.SummerDresses;
import utilities.ExcelReading;

public class AssignmentTestCases extends ExcelReading{
	
	   public LandingPage lpage;
	   public SummerDresses summdress;
	   public PrintedShiffonDress_Frame Shiffondressframe;
	   public ContnShopWin ContinueShoppingWin;
	   public ShopCartSummary shopcartsumm;
	   public RegPage regpage;
	   
	
   @BeforeTest
	public void setup() throws IOException
	{ 
	   driver = PropReading();
	     driver.get(property.getProperty("URL"));
		 lpage = new LandingPage(driver);
	}
	
	
	@Test(priority=0)
	public void LandingPageTitleTest() 
	{		
		String LPtitle = lpage.validateLandingPageTitle();
	    Assert.assertEquals(LPtitle, "My Store");
	    
	    summdress = lpage.Lnk_SummDress();
	    
	    summdress = new SummerDresses(driver);
	}
	
	
	@Test(priority=1)
	public void SummerDressesTitleTest() throws InterruptedException  
	{
		String title = summdress.validateSummerDressesPageTitle();
		//Thread.sleep(20000);
		Assert.assertEquals("Summer Dresses - My Store" , title );
	}
	
	@Test(priority=2)
	public void MovetoLnknClickPrntdShiffonTest() 
	{
		Shiffondressframe = summdress.MovetoLnknClick_PrntdShiffon();
		
		Shiffondressframe = new PrintedShiffonDress_Frame(driver);
	}
	
		
	@Test(priority=3)
	public void SelectsizenAddtoCart()
	{
		ContinueShoppingWin = Shiffondressframe.SelectSizenAddCart();
		
		ContinueShoppingWin = new ContnShopWin(driver);
	}
	
	@Test(priority=4)
	public void ClickContnShopButton() throws InterruptedException
	{
		summdress = ContinueShoppingWin.clickcontinueshopwin();
		
		String title = summdress.validateSummerDressesPageTitle();
		//Thread.sleep(30000);
		Assert.assertEquals("Summer Dresses - My Store", title);
		
		summdress = new SummerDresses(driver);
	}
	
	@Test(priority=5)
	public void clickchkoutTest()
	{
		shopcartsumm = summdress.MovetoCartnChkout();
		
		shopcartsumm = new ShopCartSummary(driver);
	}
	
	@Test(priority=6)
	public void ShopCartSummary()
	{
		
		shopcartsumm.Summary();
		shopcartsumm.Auth("abc1234567xyz@yahoo.com");
	
		regpage = new RegPage(driver);
	}
	
	@Test(priority=7)
	public ShopCartSummary CreateAccount() 
	{
		String textverify = regpage.validateAccountPage();
		Assert.assertEquals("CREATE AN ACCOUNT", textverify);
		
		regpage.RegFormFill("abc", "xyz", "pwd@12345zyx" , "Mevis Rd", "Arizona", "Arizona" , "67349", "9899456372", "downtown");
		
		return new ShopCartSummary(driver);
		
	}
	
	@Test(priority=8)
	public void Add_Proceed() 
	{
		shopcartsumm.Summary();
		shopcartsumm.TermsChkbx();
		shopcartsumm.Summary();	
		
	String Product=	shopcartsumm.ProductdVerify();
	String Price=	shopcartsumm.ProductdPriceVerify();
	String TotalPrice = shopcartsumm.ProductdTotalPriceVerify();
		
		Assert.assertEquals("Printed Chiffon Dress", Product);
		Assert.assertEquals("$16.40", Price);
		Assert.assertEquals("$18.40", TotalPrice);
	}
	
			
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	}



}
