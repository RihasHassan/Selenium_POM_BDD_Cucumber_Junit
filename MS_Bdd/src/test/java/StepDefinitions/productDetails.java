package StepDefinitions;

import org.junit.Assert;

import BaseClass.BaseClass;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.ProductListingPage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class productDetails extends BaseClass {

	String productName;
	String productPrice;
	String productNameInDetailPage;

	String productPriceInDetailPage;
	//String Quantity=prop.getProperty("productQuantity");
      
	String Quantity = "2";

	HomePage homePage;
	ProductListingPage productListingPage;
	ProductDetailPage productDetailPage;
	CartPage cartPage;

	
	  @After public void tearDown() {
	  
	  getDriver().close(); getDriver().quit(); }
	  
	 

	@Given("user is alreday on homePage")
	public void user_is_alreday_on_home_page() {

		launchApp("Chrome");

	}

	@When("user clicks on WomensTab")
	public void user_clicks_on_womens_tab() {

		homePage = new HomePage();
		homePage.clickOnWomenLink();

	}

	@Then("user sorts products based on average rating")
	public void user_sorts_products_based_on_average_rating() {

		productListingPage = new ProductListingPage();
		productListingPage.clickOnSort("Sort by average rating");

	}

	@Then("user is on womens product listing page")
	public void user_is_on_womens_product_listing_page() {

		productName = productListingPage.FirstProductName();
		productPrice = productListingPage.FirstProductPrice();

	}

	@Then("user clicks on first product on listing")
	public void user_clicks_on_first_product_on_listing() {

		productListingPage.clickOnFirstProduct();

	}

	@Then("user is on product detail page and then verifying the product details")
	public void user_is_on_product_detail_page_and_then_verifying_the_product_details() {

		productDetailPage = new ProductDetailPage();

		String productNameInDetailPage = productDetailPage.ProductNameInProductDetailPage();

		String productPriceInDetailPage = productDetailPage.ProductPriceInProductDetailPage();

		Assert.assertEquals(productName, productNameInDetailPage);
		Assert.assertEquals(productPrice, productPriceInDetailPage);

	}

	// second scenario

	@Then("user increase the quantity of the product")
	public void user_increase_the_quantity_of_the_product()

	{   			//String name=prop.getProperty("productQuantity");

		productDetailPage = new ProductDetailPage();

		productDetailPage.addingQuantity(prop.getProperty("productQuantity"));

	}

	@Then("user clicks on add to cart")
	public void user_clicks_on_add_to_cart() {

		productDetailPage = new ProductDetailPage();
		productDetailPage.clickingOnAddToCart();
	}

	@When("user clicks on view cart")
	public void user_clicks_on_view_cart() {
		productDetailPage = new ProductDetailPage();
		productDetailPage.clickingOnViewCart();

	}

	@Then("user is on cart page and then verifying the product details")
	public void user_is_on_cart_page_and_then_verifying_the_product_details() {

		productDetailPage = new ProductDetailPage();
		cartPage = new CartPage();

		String ProductNameInProductCartPage = cartPage.ProductNameInProductCartPage();
		String ProductPriceInProductCartPage = cartPage.ProductPriceInProductCartPage();
		String ProductQuantityInProductCartPage = cartPage.ProductQuantityInProductCartPage();

		Double actualSubTotalPrice = cartPage.productSubTotalPriceInCartPage();
		Double expectedSubTotal = cartPage.verifySubTotalPrice();

		Assert.assertEquals(productName, ProductNameInProductCartPage);
		
		Assert.assertEquals(productPrice, ProductPriceInProductCartPage);
		Assert.assertEquals(ProductQuantityInProductCartPage, prop.getProperty("productQuantity"));

		// Product SubTotal Check in cart

		Assert.assertEquals(expectedSubTotal, actualSubTotalPrice);

		// Product Total Check in cart

		Double actualTotalPrice = cartPage.productTotalPriceInCartPage();
		Double expectedTotal = cartPage.verifyTotalPrice();

		Assert.assertEquals(expectedTotal, actualTotalPrice);

	}

	@Then("user clicks on change adress")
	public void user_clicks_on_change_adress() 
	
	{
		cartPage = new CartPage();

		cartPage.clickOnaddress();
	}

	@Then("user enters address details and then clicks on update")
	public void user_enters_address_details_and_then_clicks_on_update() 
	
	{
		
		cartPage = new CartPage();

		  cartPage.selectingCountry(); cartPage.selectingState();
		  cartPage.enteringCity(); cartPage.enteringPostalCode();
		  
		  
		  cartPage.clickOnUpdate();
		 

	}

	@Then("user clicks on proceed to check out button")
	public void user_clicks_on_proceed_to_check_out_button() {
		cartPage = new CartPage();

		cartPage.clickOnProceedTocheckOut();

	}

}
