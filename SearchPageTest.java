import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import pages.LoginPage;
import pages.HomePage;
import pages.SearchPage;
import java.time.Duration;
public class SearchPageTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public  HomePage homePage;
    public SearchPage searchPage;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        loginPage.loginappication("rahul", "rahul@2021");
        String expecturl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        Assert.assertEquals(expecturl, currenturl, "not match");
    }
    @DataProvider
    public Object[][] movies(){
        return new Object[][]{
                {"Clifford", 1},
                {"Luca", 1},
                {"Dragon Fury", 1},
        };
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test(priority = 1, dataProvider = "movies")
    public void successfulsearch(String movie, int expectcount){
        searchPage.clickonsearlinkbtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-account-container")));
        String expecturl = "https://qamoviesapp.ccbp.tech/search";
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        Assert.assertEquals(expecturl, currenturl, "not match");
        searchPage.search(movie);
        int actualcount = searchPage.getthecountofallmoviesdisplayed();
        Assert.assertEquals(actualcount, expectcount, "Not matching");
    }
    @Test(priority = 2)
    public void unsuccessfulsearch(){
        searchPage.clickonsearlinkbtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-account-container")));
        searchPage.search("Netflix");
        Assert.assertTrue(searchPage.findsearchnotfoundimg().isDisplayed(), "Not found");
        Assert.assertEquals(searchPage.findsearchnotfoundtext(), "Your search for Netflix did not find any matches.", "Not matching");
    }
}
