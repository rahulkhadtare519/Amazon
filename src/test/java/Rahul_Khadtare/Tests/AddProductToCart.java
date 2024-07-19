package Rahul_Khadtare.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Rahul_Khadtare.PageObject.CartPage;
import Rahul_Khadtare.PageObject.ProductPage;
import Rahul_Khadtare.TestComponents.BaseTest;

public class AddProductToCart extends BaseTest {
	String product = "Laptop";

	@Test
	public void addProductToCart() throws IOException, InterruptedException {
		// Scenario 1
		ProductPage productPage=homePage.searchProduct(product);// product initial should be capital
		productPage.verifyProducts(product);
		// scenario 2
		productPage.addToCart(product);
		CartPage cartPage = productPage.gotoCartPage();
		cartPage.verifyCartProduct(product);
		// scenario 3
		cartPage.deleteFromCart();
	}
	
}
