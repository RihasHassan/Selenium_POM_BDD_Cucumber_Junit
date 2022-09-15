package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import actiondriver.Action;




public class ProductListingPage extends BaseClass{
	
	
	
	//WebgetDriver() getDriver();
	Action action=new Action();


	@FindBy(xpath = "//select[@name='orderby']")
	WebElement sorting;


	@FindBy(xpath = "//ul[contains(@class,'products')]//li[1]//a//h2")
	WebElement firstProductName;

	@FindBy(xpath = "//ul[contains(@class,'products')]//li[1]//span[@class='price']//ins")
	WebElement firstProductPrice;

	public ProductListingPage()

	{  

		PageFactory.initElements(getDriver(),this);	



	}

	public void clickOnSort(String sortBy)    

	{
		action.highLight(getDriver(), sorting);

		action.selectByVisibleText(sortBy, sorting);
	}


	public String FirstProductName()

	{
		action.highLight(getDriver(), firstProductName);

		return action.getText(getDriver(), firstProductName);
	}

	public String FirstProductPrice()

	{

		action.highLight(getDriver(), firstProductPrice);

		String price=action.getText(getDriver(), firstProductPrice);

		String Price = price.replace("$","");
		//System.out.println(Price);

		return Price;
	}


	public void clickOnFirstProduct()

	{
		action.highLight(getDriver(), firstProductName);
		action.click(getDriver(), firstProductName);

	

	}

}



