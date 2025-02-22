package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    By logolocator = By.className("login-website-logo");
    By loginheadinglocator = By.className("sign-in-heading");
    By labletextlocator = By.className("input-label");
    By loginbtnlocator = By.className("login-button");
    By usernamelocator = By.id("usernameInput");
    By pinlocator = By.id("passwordInput");
    By errormsglocator = By.className("error-message");
    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebElement findlogoimg(){
        return driver.findElement(logolocator);
    }
    public String findheadingtext(){
        return driver.findElement(loginheadinglocator).getText();
    }
    public String findlabletextAt(int index){
        return driver.findElements(labletextlocator).get(index).getText();
    }
    public void clickonloginbtn(){
        driver.findElement(loginbtnlocator).click();
    }
    public void finduserInput(String username){
        driver.findElement(usernamelocator).sendKeys(username);
    }
    public void findpinInput(String password){
        driver.findElement(pinlocator).sendKeys(password);
    }
    public void loginappication(String username, String password){
        finduserInput(username);
        findpinInput(password);
        clickonloginbtn();
    }
    public String finderrortext(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errormsglocator)).getText();
    }

}
