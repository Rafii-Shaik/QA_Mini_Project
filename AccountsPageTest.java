import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import pages.LoginPage;
import pages.HomePage;
import pages.AccountsPage;
import java.time.Duration;
public class AccountsPageTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public AccountsPage accountsPage;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        loginPage.loginappication("rahul", "rahul@2021");
        String expecturl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        Assert.assertEquals(expecturl, currenturl, "not match");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void AccountPage(){
        accountsPage.ClickonAvtarimg();
        String expecturl = "https://qamoviesapp.ccbp.tech/account";
        String currenturl = driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expecturl));
        Assert.assertEquals(expecturl, currenturl, "Not Matching");
        Assert.assertEquals(accountsPage.findaccountheading(), "Account", "Not Matching");
        Assert.assertEquals(accountsPage.findmembershipheading(), "Member ship", "Not Matching");
        Assert.assertEquals(accountsPage.findusername(), "User name : rahul", "Not matching");
        Assert.assertEquals(accountsPage.findpassword(), "Password : **********", "Not Matching");
        Assert.assertEquals(accountsPage.findplanheading(), "Plan details", "Not Matching");
        Assert.assertEquals(accountsPage.findplanparagraph(), "Premium", "Not matching");
        Assert.assertEquals(accountsPage.findplandetails(), "Ultra HD", "Not Matching");
        accountsPage.clickonlogoutbtn();
    }
}
