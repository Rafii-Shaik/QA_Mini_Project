package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderSectionPage {
    By websitelogolocator = By.className("website-logo");
    By homelocator = By.linkText("Home");
    By popularlocator = By.linkText("Popular");
    By searchlocator = By.cssSelector("#root > div > div.home-container > nav > div.search-account-container > button.search-empty-button");
    By avtarlocator = By.cssSelector("#root > div > div.home-container > nav > div.search-account-container > button.avatar-button");
    public WebDriver driver;
    public HeaderSectionPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement findlogoimg(){
        return driver.findElement(websitelogolocator);
    }
    public void clickonhomeelement(){
        driver.findElement(homelocator).click();
    }
    public void clickonpopularelement(){
        driver.findElement(popularlocator).click();
    }
    public void clickonsearchelemnt(){
        driver.findElement(searchlocator).click();
    }
    public void clickonaccountavatar(){
        driver.findElement(avtarlocator).click();
    }
}
