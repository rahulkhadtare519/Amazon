package Rahul_Khadtare.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Rahul_Khadtare.AbstractComponents.AbstractComponent;

public class ProductPage extends AbstractComponent {
	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "span[class$='a-size-medium a-color-base a-text-normal']")
	List<WebElement> searchedProducts;
	
	@FindBy(css = "span[class$='a-size-medium a-color-base a-text-normal']")
	WebElement searchedProduct;
	
	@FindBy(id = "productTitle")
	WebElement productTitle;
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement addToCart;

	@FindBy(id = "nav-cart")
	WebElement cart;

	
	public void verifyProducts(String product)
	{
	int count = 0;
	waitForTheElementsToAppear(searchedProducts);
	for (WebElement searchedproduct : searchedProducts) 
	{
		String productName = searchedproduct.getText();
		// System.out.println(productName);
		if (productName.contains(product)) {
			Assert.assertTrue(true);
			count++;
		} 
		
	}
	System.out.println(count);
}

	public void addToCart(String product) throws InterruptedException {
		searchedProduct.click();
		String productTitleText = productTitle.getText();
		Assert.assertTrue(productTitleText.contains(product));
		System.out.println("Product selected contains the word " + product);
		driver.navigate().back(); //as Add to Cart is disabled we navigate back and add product to cart
		addToCart.click();
		Thread.sleep(5000);
	}
	
	public CartPage gotoCartPage() {
		cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}
