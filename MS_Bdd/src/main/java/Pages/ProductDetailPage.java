package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import actiondriver.Action;



public class ProductDetailPage extends BaseClass {

	Action action=new Action();
	//WebgetDriver() getDriver();


	@FindBy(xpath = "//div[contains(@class,'summary')]//h1")
	WebElement productName;


	@FindBy(xpath = "//div[contains(@class,'summary')]//p[@class='price']//ins")
	WebElement productPrice;
	
	@FindBy(xpath="//input[@name='quantity']")
	WebElement quantiy;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement addToCart;
	
	@FindBy(xpath="//a[contains(@title,'shopping')]")
	WebElement viewCart;
	

	public ProductDetailPage()
	{


		PageFactory.initElements(getDriver(),this);	

	}

	public String ProductNameInProductDetailPage()

	{
        action.highLight(getDriver(), productName);
		return action.getText(getDriver(), productName);
	}

	public String ProductPriceInProductDetailPage()

	{
        action.highLight(getDriver(), productPrice);
		String price=action.getText(getDriver(), productPrice);

		String Price = price.replace("$","");

		return Price;


	}


	
	public void addingQuantity(String Quantity)
	
	{
		//String Quantity="2";
		
		action.scrollByVisibilityOfElement(getDriver(), addToCart);
		action.highLight(getDriver(), quantiy);
		action.clearText(getDriver(), quantiy);
		action.type(quantiy, Quantity);

		
	}
	
public void clickingOnAddToCart()	
	{
		
		action.highLight(getDriver(), addToCart);
		action.click(getDriver(), addToCart);
		
	}


public void clickingOnViewCart()	
{
	

	/*
	 * action.implicitWait(getDriver(), 6); action.switchToFrameById(getDriver(),
	 * "iframe");
	 */
		action.explicitWait(getDriver(), viewCart, 20);
		//action.click(getDriver(), viewCart);
		action.highLight(getDriver(), viewCart);
		action.JSClick(getDriver(), viewCart);
		
	


}
	
	

}
