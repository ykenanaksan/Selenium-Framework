package ykenanTest.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ykenanTest.TestComponents.BaseTest;
import ykenanTest.pageobjects.CartPage;
import ykenanTest.pageobjects.CheckoutPage;
import ykenanTest.pageobjects.ConfirmationPage;
import ykenanTest.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{

	
	@Test(groups = {"ErrorHandling"})
	public void LoginErrorValidation() throws InterruptedException, IOException
	{
		String userEmail = "rsaqauser@gmail.com";
		String password = "Tes1234";

		landingPage.loginApplication(userEmail, password);
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	
	@Test
	public void ProductErrorValidation() throws InterruptedException, IOException
	{
		String userEmail = "rahulshetty@gmail.com";
		String password = "Iamking@000";
		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingPage.loginApplication(userEmail, password);
		List <WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}
}

