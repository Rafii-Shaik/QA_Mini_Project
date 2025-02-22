package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class HomePage {
    By trendingheadinglocator = By.cssSelector("div.home-bottom-container>div:first-child>h1.movies-list-heading");
    By originalheadinglocator = By.cssSelector("div.home-bottom-container>div:nth-child(2)>h1.movies-list-heading");
    By playbtnlocator = By.className("home-movie-play-button");
    By trendingsectionlocator = By.cssSelector("div.home-bottom-container>div:first-child>div>div>div:nth-child(2)");
    By originalsectionlocator = By.cssSelector("div.home-bottom-container>div:nth-child(2)>div>div>:nth-child(2)");
    By googleiconlocator = By.cssSelector("div.footer-icons-container>:first-child");
    By twittericonlocator = By.cssSelector("div.footer-icons-container>:nth-child(2)");
    By instaiconlocator = By.cssSelector("div.footer-icons-container>:nth-child(3)");
    By youtubeiconlocator = By.cssSelector("div.footer-icons-container>:last-child");
    By contactuslocator = By.className("contact-us-paragraph");
    public WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public String findtrendingheading(){
        return driver.findElement(trendingheadinglocator).getText();
    }
    public String findorigionalheading(){
        return driver.findElement(originalheadinglocator).getText();
    }
    public WebElement findpalybtn(){
        return driver.findElement(playbtnlocator);
    }
    public boolean findtrendingmovies(){
       List<WebElement> trendingsection = driver.findElements(trendingsectionlocator);
       return !trendingsection.isEmpty();
    }
    public boolean findoriginalsection(){
        List<WebElement> originalsection = driver.findElements(originalsectionlocator);
        return !originalsection.isEmpty();
    }
    public WebElement findgoogleicon(){
        return driver.findElement(googleiconlocator);
    }
    public WebElement findtwittericon(){
        return driver.findElement(twittericonlocator);
    }
    public WebElement findinstaicon(){
        return driver.findElement(instaiconlocator);
    }
    public WebElement findyoutubeicon(){
        return driver.findElement(youtubeiconlocator);
    }
    public String contacttext(){
        return driver.findElement(contactuslocator).getText();
    }
}
