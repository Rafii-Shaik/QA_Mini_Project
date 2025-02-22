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

public class AccountFunctionalitySteps {
    public WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @When("I click on Avatar link image")
    public void IclickOnAvatarLinkImg(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-img")));
        driver.findElement(By.className("avatar-img")).click();
    }
    @And("It should navigate to account page")
    public void NavigatingToAccountPage(){
        String expecturl = "https://qamoviesapp.ccbp.tech/account";
        String currenturl = driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expecturl));
        Assert.assertEquals(expecturl, currenturl, "Not match");
    }
    @Then("I want to check account heading is presented")
    public void AccountHeadingIsPresented(){
        Assert.assertTrue(driver.findElement(By.className("account-heading")).isDisplayed());
    }
    @And("I want to check membership and plan details")
    public void CheckingMembershipAndPlanDetails(){
        Assert.assertTrue(driver.findElement(By.cssSelector("div.membership-container>p.membership-heading")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("membership-username")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("membership-password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.plan-container>p:first-child")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("plan-paragraph")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.plan-details-container>p:last-child")).isDisplayed());
    }
    @And("I click on logout button")
    public void ClickingOnLogoutButton(){
        driver.findElement(By.className("logout-button")).click();
    }
    @Then("It should navigate to login page")
    public void NavigatingTOLoginPage(){
        String expecturl = "https://qamoviesapp.ccbp.tech";
        String currenturl = driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expecturl));
        Assert.assertEquals(expecturl, currenturl, "Not match");
    }
    @After
    public void Teardown(){
        driver.quit();
    }
}
