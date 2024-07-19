package Rahul_Khadtare.PageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Rahul_Khadtare.AbstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent {
	WebDriver driver;
	public CartPage cartPage;
	public ProductPage productPage;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-global-location-popover-link")
	WebElement deliveryCountry;

	@FindBy(css = "input[data-action-type='DISMISS']")
	WebElement popup;

	@FindBy(css = "input[placeholder='Search Amazon']")
	WebElement searchInput;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchButton;


	public ProductPage searchProduct(String product) 
	{
		waitForTheElementToAppear(popup);
		popup.click();
		searchInput.sendKeys(product);
		searchButton.click();
		productPage = new ProductPage(driver);
		return productPage;
	}


}
