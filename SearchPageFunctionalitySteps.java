package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;
import java.time.Duration;
public class SearchPageFunctionalitySteps {
    public WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @When("I click on search button")
    public void ClickOnSearchLinkButton(){
        driver.findElement(By.cssSelector("div.search-account-container>button.search-empty-button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expecturl = "https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        Assert.assertEquals(currenturl, expecturl, "Not match");
    }
    @Then("I enter movie name in search filed and it should display searched movie")
    public void EnteringMovieNameinSearchFiled(String searchtext){
        driver.findElement(By.cssSelector("div.search-container>input#search")).sendKeys(searchtext);
    }
    @And("it should display searched movie")
    public void FindingSearchedMovie(){
        driver.findElement(By.className("search-button")).click();
    }
    @And("Count of movies displayed")
    public int CountOfMoviesDisplayed(){
        List<WebElement> lisiofmovies = driver.findElements(By.cssSelector("ul.search-movies-container>li.movie-icon-item>a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.search-movies-container>li.movie-icon-item")));
        return lisiofmovies.size();
    }
    @And("I enter invalid movie name it should display image triggered")
    public boolean InvalidMovieNametriggeredimageandmessage(){
       WebElement elements =  driver.findElement(By.cssSelector("div.not-found-search-container>:first-child"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.not-found-search-container>:first-child")));
        return elements.isDisplayed();
    }
    @And("I enter invalid movie name it should display error message")
    public void findingerrormsg(){
        Assert.assertTrue(driver.findElement(By.className("not-found-search-paragraph")).isDisplayed());
    }
    @After
    public void Teardown(){
        driver.quit();
    }
}
