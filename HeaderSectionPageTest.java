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
import pages.HeaderSectionPage;
import java.time.Duration;
public class HeaderSectionPageTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public  HomePage homePage;
    public HeaderSectionPage headerSectionPage;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        headerSectionPage = new HeaderSectionPage(driver);
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
    @Test(priority = 1)
    public void FindingLogoimage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        Assert.assertTrue(headerSectionPage.findlogoimg().isDisplayed(), "Not Found");
    }
    @Test(priority = 2)
    public void NavigationToHomePage(){
        headerSectionPage.clickonhomeelement();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-bottom-container")));
        String expecturl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        if(currenturl.equals(expecturl)){
            System.out.println("Navigated to Home Page Successfully");
        }
        else{
            System.out.println("Navigated to Home Page failed");
        }
    }
    @Test(priority = 3)
    public void NavigationToPopularPage(){
        headerSectionPage.clickonpopularelement();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-movies-container")));
        String expecturl = "https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        if(currenturl.equals(expecturl)){
            System.out.println("Navigated to Popular Page Successfully");
        }
        else{
            System.out.println("Navigated to Popular Page failed");
        }
    }
    @Test(priority = 4)
    public void NavigationToSearchPage(){
        headerSectionPage.clickonsearchelemnt();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-account-container")));
        String expecturl = "https://qamoviesapp.ccbp.tech/search";
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        if(currenturl.equals(expecturl)){
            System.out.println("Navigated to Search Page Successfully");
        }
        else{
            System.out.println("Navigated to Search Page failed");
        }
    }
    @Test(priority = 5)
    public void NavigationToAccountPage(){
        headerSectionPage.clickonaccountavatar();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account-information-container")));
        String expecturl = "https://qamoviesapp.ccbp.tech/account";
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        if(currenturl.equals(expecturl)){
            System.out.println("Navigated to Account Page Successfully");
        }
        else{
            System.out.println("Navigated to Account Page failed");
        }
    }
}
