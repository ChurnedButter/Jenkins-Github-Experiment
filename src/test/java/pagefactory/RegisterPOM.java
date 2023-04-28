package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPOM
{
    WebDriver driver;
    Select select;

    @FindBy(id = "gender-male")
    WebElement Male;

    @FindBy(id = "gender-female")
    WebElement Female;

    @FindBy(id = "FirstName")
    WebElement firstname;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement emailInput;

    @FindBy(id = "Password")
    WebElement passwordInput;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement regBtn;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement conBtn;

    @FindBy(className = "ico-logout")
    WebElement logout;

    //address credentials
    @FindBy(id = "Address_FirstName")
    WebElement firstName;

    @FindBy(id = "Address_LastName")
    WebElement credLastName;

    @FindBy(id = "Address_Email")
    WebElement email;

    @FindBy(id = "Address_CountryId")
    WebElement country;

    @FindBy(id = "Address_StateProvinceId")
    WebElement stateProvince;

    @FindBy(id = "Address_City")
    WebElement city;

    @FindBy(id = "Adress_Address1")
    WebElement address1;

    @FindBy(id = "Address_Address2")
    WebElement address2;

    @FindBy(id = "Address_ZipPostalCode")
    WebElement zipcode;

    @FindBy(id = "Address_PhoneNumber")
    WebElement phoneNumber;

    @FindBy(id = "Address_FaxNumber")
    WebElement fax;

    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveInfo;

    public RegisterPOM(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBtnMale(){ Male.click(); }

    public void clickBtnFemale() { Female.click(); }

    public void sendFirstName(String name) { firstname.sendKeys(name); }

    public void sendLastName(String name) { lastName.sendKeys(name); }

    public void sendEmail(String email) { emailInput.sendKeys(email); }

    public void sendPassword(String password) { passwordInput.sendKeys(password); }

    public void sendConfirmPassword(String password) {confirmPassword.sendKeys(password); }

    public void clickRegister() { regBtn.click(); }

    public void clickConBtn() { conBtn.click(); }

    public void clickLogout() {logout.click();}
}