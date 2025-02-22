import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
public class LoginPageTest {
    public WebDriver driver;
    public LoginPage loginPage;
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }
    @AfterMethod
    public void Teardown(){
        driver.quit();
    }
    @Test(priority = 1)
    public void LoginPageUI(){
        Assert.assertTrue(loginPage.findlogoimg().isDisplayed(), "Logo image is not displayed");
        Assert.assertEquals(loginPage.findheadingtext(),"Login", "Not matching");
        Assert.assertEquals(loginPage.findlabletextAt(0), "USERNAME", "Not matching");
        Assert.assertEquals(loginPage.findlabletextAt(1), "PASSWORD", "Not matching");
        loginPage.clickonloginbtn();
    }
    @Test(priority = 2)
    public void LoginWithEmptyFields(){
        loginPage.clickonloginbtn();
        Assert.assertEquals(loginPage.finderrortext(), "*Username or password is invalid", "not matching");
    }
    @Test(priority = 3)
    public void LoginWithEmptyUsername(){
        loginPage.loginappication("", "rahul@2021");
        Assert.assertEquals(loginPage.finderrortext(), "*Username or password is invalid", "not matching");
    }
    @Test(priority = 3)
    public void LoginWithEmptyPin(){
        loginPage.loginappication("rahul", "");
        Assert.assertEquals(loginPage.finderrortext(), "*Username or password is invalid", "not matching");
    }
    @Test(priority = 4)
    public void LoginWithWrongPin(){
        loginPage.loginappication("rahul", "rahul");
        Assert.assertEquals(loginPage.finderrortext(), "*username and password didn't match", "not matching");
    }
    @Test(priority = 5)
    public void SuccessfulLogin(){
        loginPage.loginappication("rahul", "rahul@2021");
        String expecturl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        Assert.assertEquals(expecturl, currenturl, "not match");
    }
}
