package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import pagefactory.CheckOutPOM;
import pagefactory.LaptopPOM;
import pagefactory.RegisterPOM;
import pagefactory.LoginPOM;
import dummydata.*;

public class StepDefintion
{

    WebDriver driver;
    RegisterPOM reg;
    LoginPOM login;
    LaptopPOM nav;
    CheckOutPOM con;
    UserData registered;

    @Before
    public void userHasABrowserRunning()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/alex/Dev/codeSpace/softDev/ide/javaIDE/intelliJ/testing/components/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        reg = new RegisterPOM(driver);
        nav = new LaptopPOM(driver);
        con = new CheckOutPOM(driver);
        registered = EmailStorage.getUser("testUser");
    }

    @After
    public void quit() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.quit();
    }

    @Given("user is on the homepage")
    public void userIsOnTheHomepage() { driver.get("https://demowebshop.tricentis.com/"); }

    @And("user clicks on the register link")
    public void userClicksOnTheRegisterLink() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.get("https://demowebshop.tricentis.com/register");
    }

    @When("user fills out the registration form with valid credentials using randomly generated email address")
    public void userFillsOutTheRegistrationFormWithValidCredentialsUsingRandomlyGeneratedEmailAddress() throws InterruptedException
    {
        UserData user = new UserData();
        Thread.sleep(2000);
        user.setFirstName(GenerateData.getFirstNames());
        user.setLastName((GenerateData.getLastNames()));
        user.setEmail(GenerateData.genEmail(user.getFirstName(), user.getLastName()));
        user.setPassword(GenerateData.genPassword());

        EmailStorage.saveUser("testUser3", user);

        System.out.println("Name of user: " + user.getFirstName() + " " + user.getLastName() + ".");
        System.out.println("User's Email: " + user.getEmail());
        System.out.println("User's password: " + user.getPassword());

        reg.clickBtnMale();
        reg.sendFirstName(user.getFirstName());
        reg.sendLastName(user.getLastName());
        reg.sendEmail(user.getEmail());
        reg.sendPassword(user.getPassword());
        reg.sendConfirmPassword(user.getPassword());
    }

    @And("user submits the form")
    public void userSubmitsTheForm() throws InterruptedException
    {
        Thread.sleep(2000);
        reg.clickRegister();
    }

    @Then("user should be led to the account confirmation page")
    public void userShouldBeLedToTheAccountConfirmationPage() throws InterruptedException
    {
        Thread.sleep(2000);
        reg.clickConBtn();
    }

    @And("user must log out")
    public void userMustLogOut() throws InterruptedException
    {
        Thread.sleep(2000);
        reg.clickLogout();
        Thread.sleep(2000);
    }

    @Given("user logs back in with previous credentials")
    public void userLogsBackInWithPreviousCredentials() throws InterruptedException
    {
        driver.get("https://demowebshop.tricentis.com/login");
        UserData registered = EmailStorage.getUser("testUser");
        login = new LoginPOM(driver);

        login.sendUserName(registered.getEmail());
        login.sendPassword(registered.getPassword());
        login.clickLogin();

        Thread.sleep(1000);
    }

    @When("user successfully logs in")
    public void userSuccessfullyLogsIn() throws InterruptedException
    {
        Thread.sleep(2000);
    }

    @Then("user's account is registered and user must log off.")
    public void userSAccountIsRegisteredAndUserMustLogOff() throws InterruptedException
    {
        login.clickLogout();
        Thread.sleep(2000);
    }

    @Given("user has registered and successfully logged in")
    public void userHasRegisteredAndSuccessfullyLoggedIn() throws InterruptedException
    {
        driver.get("https://demowebshop.tricentis.com/login");
        login = new LoginPOM(driver);

        login.sendUserName(registered.getEmail());
        login.sendPassword(registered.getPassword());
        login.clickLogin();

        Thread.sleep(1000);
    }


    @When("user searches for any item")
    public void userSearchesForAnyItem() throws InterruptedException
    {
        nav.searchUp("laptop");
        nav.clickSubmit();
        nav.clickLaptop();

        Thread.sleep(1000);
    }

    @And("adds the selected item to the cart")
    public void addsTheSelectedItemToTheCart() throws InterruptedException
    {
        Actions action = new Actions(driver);

        nav.changeQuantity("2");
        nav.clickAddCart();
        action.moveToElement(nav.shoppingCart);

        Thread.sleep(1000);
    }

    @Then("user must be able to successfully purchase the item at checkout.")
    public void userMustBeAbleToSuccessfullyPurchaseTheItemAtCheckout() throws InterruptedException
    {
        nav.clickShoppingCart();
        con.clickTerms();
        con.clickCheckOut();
        Thread.sleep(1000);

        for (int i = 0; i < 5; i++)
        {
            Thread.sleep(1000);
            con.clickConBtn(i);
        }

        Thread.sleep(800);
        con.clickConfirm();
    }

    @When("user searches for any item and adds item to the cart")
    public void userSearchesForAnyItemAndAddsItemToTheCart() throws InterruptedException
    {
        nav.searchUp("laptop");
        nav.clickSubmit();
        nav.clickLaptop();

        Thread.sleep(1000);

        Actions action = new Actions(driver);

        nav.changeQuantity("2");
        nav.clickAddCart();
        action.moveToElement(nav.shoppingCart);

        Thread.sleep(1000);

        nav.clickShoppingCart();
        con.clickTerms();
        con.clickCheckOut();
        Thread.sleep(1000);
    }

    @And("user hasn't filled out address credentials")
    public void userHasnTFilledOutAddressCredentials() throws InterruptedException
    {
        System.out.println(con.firstName.isDisplayed());
        Thread.sleep(500);
    }

    @Then("user must fill out credentials and complete purchase at checkout.")
    public void userMustFillOutCredentialsAndCompletePurchaseAtCheckout() throws InterruptedException
    {
        if(con.firstName.isDisplayed()) {
            con.selectCountry("United States");
            Thread.sleep(500);
            con.selectStaeProvince("Arkansas");
            con.sendCity("Little Rock");
            con.sendFirstAddress("1234 Sesame Street");
            con.sendZip("123456");
            con.sendPhone("5555555555");
            for (int i = 0; i < 5; i++)
            {
                Thread.sleep(1000);
                con.clickConBtn(i);
            }
            Thread.sleep(800);
            con.clickConfirm();
        }
    }
}