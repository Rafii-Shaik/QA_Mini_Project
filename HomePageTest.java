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

public class HomePageTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public  HomePage homePage;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
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
    public void HomePageTest(){
        String expecturl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movies-list-heading")));
        Assert.assertEquals(expecturl, currenturl, "not match");
        Assert.assertEquals(homePage.findtrendingheading(), "Trending Now", "not matching");
        Assert.assertEquals(homePage.findorigionalheading(), "Originals", "Not Matching");
        Assert.assertTrue(homePage.findpalybtn().isDisplayed(), "Not Found");
        Assert.assertTrue(homePage.findtrendingmovies(), "Is not empty");
        Assert.assertTrue(homePage.findoriginalsection(), "Is not empty");
        Assert.assertTrue(homePage.findgoogleicon().isDisplayed(), "Not Found");
        Assert.assertTrue(homePage.findtwittericon().isDisplayed(), "Not Found");
        Assert.assertTrue(homePage.findinstaicon().isDisplayed(), "Not Found");
        Assert.assertTrue(homePage.findyoutubeicon().isDisplayed(), "Not Found");
        Assert.assertEquals(homePage.contacttext(), "Contact Us", "Not Matching");
    }
}
