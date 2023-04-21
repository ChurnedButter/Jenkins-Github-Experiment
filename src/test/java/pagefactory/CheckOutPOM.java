package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class CheckOutPOM
{
    WebDriver driver;

    @FindBy(id = "termsofservice")
    WebElement terms;

    @FindBy(id = "checkout")
    WebElement checkoutLink;

    @FindAll(@FindBy(xpath="//input[@value='Continue']"))
    List<WebElement> conBtn;

    @FindBy(xpath = "//input[@value='Confirm']")
    WebElement confirm;

    /***** Checkout Credential information *****/
    @FindBy(id = "BillingNewAddress_FirstName")
    public WebElement firstName;

    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastName;

    @FindBy(id = "BillingNewAddress_Email")
    WebElement email;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement stateProvince;

    @FindBy(id = "BillingNewAddress_City")
    WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address1;

    @FindBy(id = "BillingNewAddress_Address2")
    WebElement address2;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipcode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumber;

    @FindBy(id = "BillingNewAddress_FaxNumber")
    WebElement fax;

    public CheckOutPOM(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickConBtn(int num) {conBtn.get(num).click();}

    public void clickConfirm(){confirm.click();}

    public void clickTerms() {terms.click();}

    public void clickCheckOut() {checkoutLink.click();}

    /***** Checkout Credential information *****/

    public void sendFirstName(String name) {firstName.sendKeys(name);}

    public void sendLastName(String name) {lastName.sendKeys(name);}

    public void sendEmail(String newEmail) {email.sendKeys(newEmail);}

    public void selectCountry(String text)
    {
        Select select = new Select(country);
        select.selectByVisibleText(text);
    }

    public void selectStaeProvince(String text) {
        Select select = new Select(stateProvince);
        select.selectByVisibleText(text);
    }

    public void sendCity(String address) {city.sendKeys(address);}

    public void sendFirstAddress(String address) {address1.sendKeys(address);}

    public void sendSecondAddress(String address) {address2.sendKeys(address);}

    public void sendZip(String address){zipcode.sendKeys(address);}

    public void sendPhone(String address){phoneNumber.sendKeys(address);}

    public void sendFax(String address){fax.sendKeys(address);}
}