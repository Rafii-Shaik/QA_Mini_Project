package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.time.Duration;
public class MovieDetailsPageFunctionalitySteps {
    public WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @When("I click on Home link button")
    public void ClickingOnHomeLinkbutton(){
        driver.findElement(By.linkText("Home")).click();
    }
    @And("I click on any movie in home page")
    public void ClickOnAnyMovie(){
        driver.findElement(By.cssSelector("#root > div > div.home-bottom-container > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > a")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.title-details-container>h1.movie-title")));
    }
    @Then("i should check all UI elements are presented")
    public void CheckingAllUIElements(){
        Assert.assertTrue(driver.findElement(By.className("watch-time")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("sensor-rating")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("movie-overview")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("play-button")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.rating-category>:nth-child(2)")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.budget-category>:nth-child(2)")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.budget-category>:last-child")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("genres-heading")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("audio-heading")).isDisplayed());
    }
    @When("I click on popular link button")
    public void ClcikOnPopularLinkElement(){
        driver.findElement(By.linkText("Popular")).click();
    }
    @And("I click on any movie in popular page")
    public void ClickOnAnyPopularPageMovie(){
        driver.findElement(By.cssSelector("#root > div > div.search-movies-container > li:nth-child(16) > a")).click();
    }
    @Then("i should check all UI elements are presented in popular movie")
    public void CheckingPopularMovieUIElements(){
        Assert.assertTrue(driver.findElement(By.className("watch-time")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("sensor-rating")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("movie-overview")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("play-button")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.rating-category>:nth-child(2)")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.budget-category>:nth-child(2)")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.budget-category>:last-child")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("genres-heading")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("audio-heading")).isDisplayed());
    }
    @After
    public void Teardown(){
        driver.quit();
    }
}
