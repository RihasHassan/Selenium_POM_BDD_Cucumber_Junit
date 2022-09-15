package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import actiondriver.Action;




public class HomePage extends BaseClass{
	
Action action=new Action();
	//WebgetDriver() getDriver();
	
	
	@FindBy(xpath="//a[.='Women']")
	 WebElement WomenTab;
	
	
	
	public HomePage()
	{
		
		PageFactory.initElements(getDriver(),this);	
		
		
	
	}
	
	public void clickOnWomenLink()
	
	
	{
		action.switchToFrameById(getDriver(), "iframe");
		action.explicitWait(getDriver(), WomenTab, 10);
		//action.click(getDriver(), WomenTab);
		action.highLight(getDriver(), WomenTab);
		action.JSClick(getDriver(), WomenTab);
		
	
	}

}
