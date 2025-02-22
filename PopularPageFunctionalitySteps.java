package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
public class PopularPageFunctionalitySteps {
    public WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @When("I click on popular button it should navigate to popular page")
    public void ClickingOnPopularbutton(){
        driver.findElement(By.linkText("Popular")).click();
    }
    @Then("available movies should display")
    public void ListofavailableMovies(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-movies-container")));
        String expecturl = "https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(expecturl));
        String currenturl = driver.getCurrentUrl();
        if(currenturl.equals(expecturl)){
            System.out.println("Movies are displayed");
        }
    }
    @After
    public void Teardown(){
        driver.quit();
    }
}
