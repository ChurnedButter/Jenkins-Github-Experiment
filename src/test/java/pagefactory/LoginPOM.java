package pagefactory;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPOM
{
    WebDriver driver;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(name="Password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement loginBtn;

    @FindBy(className = "ico-logout")
    WebElement logout;

    public LoginPOM(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendUserName(String UN)
    {
        email.sendKeys(UN);
    }

    public void sendPassword(String PWD)
    {
        password.sendKeys(PWD);
    }

    public void clickLogin() { loginBtn.click(); }

    public void clickLogout() { logout.click(); }
}