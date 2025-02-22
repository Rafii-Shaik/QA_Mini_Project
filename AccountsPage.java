package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
public class AccountsPage {
    By avtarimglocator = By.className("avatar-img");
    By accountheadinglocator = By.className("account-heading");
    By membershipheadinglocator = By.cssSelector("div.membership-container>p.membership-heading");
    By usernamelocator = By.className("membership-username");
    By psswordlocator = By.className("membership-password");
    By planheadinglocator = By.cssSelector("div.plan-container>p:first-child");
    By planparalocator = By.className("plan-paragraph");
    By plandetailocator = By.cssSelector("div.plan-details-container>p:last-child");
    By logoutbtnlocator = By.className("logout-button");
    public WebDriver driver;
    public WebDriverWait wait;
    public AccountsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void ClickonAvtarimg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-img")));
        driver.findElement(avtarimglocator).click();
    }
    public String findaccountheading(){
        return driver.findElement(accountheadinglocator).getText();
    }
    public String findmembershipheading(){
        return driver.findElement(membershipheadinglocator).getText();
    }
    public String findusername(){
        return driver.findElement(usernamelocator).getText();
    }
    public String findpassword(){
        return driver.findElement(psswordlocator).getText();
    }
    public String findplanheading(){
        return driver.findElement(planheadinglocator).getText();
    }
    public String findplanparagraph(){
        return driver.findElement(planparalocator).getText();
    }
    public String findplandetails(){
        return driver.findElement(plandetailocator).getText();
    }
    public void clickonlogoutbtn(){
        driver.findElement(logoutbtnlocator).click();
    }
}
