package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopularPage {
    By popularlinklocator = By.linkText("Popular");

    public WebDriver driver;
    public PopularPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickonpopularlink(){
        driver.findElement(popularlinklocator).click();
    }

}
