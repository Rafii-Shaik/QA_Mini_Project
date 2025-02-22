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
import pages.MovieDetailsPage;
import java.time.Duration;
public class MovieDetailsPageTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public  HomePage homePage;
    public MovieDetailsPage movieDetailsPage;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        movieDetailsPage = new MovieDetailsPage(driver);
        loginPage.loginappication("rahul", "rahul@2021");
        String expecturl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        Assert.assertEquals(expecturl, currenturl, "not match");
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
    @Test(priority = 1)
    public void TestHomePageMovieElement(){
        movieDetailsPage.clickonhomeelement();
        movieDetailsPage.clcikonmovie();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.title-details-container>h1.movie-title")));
        Assert.assertTrue(movieDetailsPage.findmovietitle().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findmovieduration().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findsensorrating().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findmoviereview().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findplaybtn().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findcountofratings().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findbudget().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findmoviereleasedate().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findgenere().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findaudios().isDisplayed(), "Not found");
        String simillarmoviesheading = driver.findElement(By.className("similar-movies-heading")).getText();
        String expectsimilarmovies = "More like this";
        if(simillarmoviesheading.equals(expectsimilarmovies)){
            System.out.println("Similar Movies Displayed");
        }
    }
    @Test(priority = 2)
    public void TestPopularPageMovie(){
        movieDetailsPage.clickonpopularpage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-movies-container")));
        movieDetailsPage.clickonpopularmovie();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.title-details-container>h1.movie-title")));
        Assert.assertTrue(movieDetailsPage.findpopularmovietitle().isDisplayed(), "Not Found");
        Assert.assertTrue(movieDetailsPage.findpopularmovieduration().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findpopularsensorrating().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findpopularmoviereview().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findpopularplaybtn().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findpopularcountofratings().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findpopularbudget().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findpopularmoviereleasedate().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findpopulargenere().isDisplayed(), "Not found");
        Assert.assertTrue(movieDetailsPage.findpopularaudios().isDisplayed(), "Not found");
        String simillarmoviesheading = driver.findElement(By.className("similar-movies-heading")).getText();
        String expectsimilarmovies = "More like this";
        if(simillarmoviesheading.equals(expectsimilarmovies)){
            System.out.println("Similar Movies Displayed");
        }

    }
}
