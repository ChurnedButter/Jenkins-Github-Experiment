package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopPOM
{
    WebDriver driver;

    @FindBy(xpath = "//input[@value='Search store']")
    WebElement search;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;

    @FindBy(xpath = "//h2/a[@href='/141-inch-laptop']")
    WebElement laptop;

    @FindBy(id="addtocart_31_EnteredQuantity")
    WebElement laptopQuantity;

    @FindBy(id = "add-to-cart-button-31")
    WebElement addCart;

    @FindBy(xpath = "//span[text()='Shopping cart']")
    public WebElement shoppingCart;

    public LaptopPOM(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchUp(String words)
    {
        search.click();
        search.sendKeys(words);
    }

    public void clickSubmit() {submit.click();}

    public void clickLaptop(){laptop.click();}

    public void changeQuantity(String quant)
    {
        laptopQuantity.click();
        laptopQuantity.clear();
        laptopQuantity.sendKeys(quant);
    }

    public void clickAddCart() {addCart.click();}

    public void clickShoppingCart() {shoppingCart.click();}
}

