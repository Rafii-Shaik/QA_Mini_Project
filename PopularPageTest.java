import org.openqa.selenium.By;
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
import java.time.Duration;
import pages.PopularPage;
public class PopularPageTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public  HomePage homePage;
    public PopularPage popularPage;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        popularPage = new PopularPage(driver);
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
    public void PopularPageTesting(){
        popularPage.clickonpopularlink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-movies-container")));
        String expecturl = "https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        if(currenturl.equals(expecturl)){
            System.out.println("Movies are displayed");
        }
    }
}
