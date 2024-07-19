package Rahul_Khadtare.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Rahul_Khadtare.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='sc-item-content-group'] //span[@class='a-truncate-cut']")
	WebElement cartProduct;

	@FindBy(css = "input[data-action='delete']")
	WebElement deleteProduct;

	@FindBy(css = "h1[class='a-spacing-mini a-spacing-top-base']")
	WebElement cartMessage;

	public void verifyCartProduct(String product) {
		String cartProductText = cartProduct.getText();
		Assert.assertTrue(cartProductText.contains(product));
	}

	public void deleteFromCart() {
		deleteProduct.click();
		String formattedMessage = cartMessage.getText().trim();
		Assert.assertEquals(formattedMessage, "Your Amazon Cart is empty.");

	}

}
