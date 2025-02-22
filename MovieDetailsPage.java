package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
public class MovieDetailsPage {
    By homebtnlocator = By.linkText("Home");
    By mvoieposter = By.cssSelector("#root > div > div.home-bottom-container > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > a");
    By movietitlelocator = By.cssSelector("div.title-details-container>h1.movie-title");
    By moviedurationlocator = By.className("watch-time");
    By sensorratinglocator = By.className("sensor-rating");
    By moviereviewlocator = By.className("movie-overview");
    By playbtnlocator = By.className("play-button");
    By ratingcountlocator = By.cssSelector("div.rating-category>:nth-child(2)");
    By budgetlocator = By.cssSelector("div.budget-category>:nth-child(2)");
    By releasedatelocator = By.cssSelector("div.budget-category>:last-child");
    By genereslocator = By.className("genres-heading");
    By audioslist = By.className("audio-heading");
    By popularpagelinklocator = By.linkText("Popular");
    By popularpagemovie = By.cssSelector("#root > div > div.search-movies-container > li:nth-child(16) > a");
    By popularmovietitle = By.cssSelector("div.title-details-container>h1.movie-title");
    By popularmoviedurationlocator = By.className("watch-time");
    By popularsensorratinglocator = By.className("sensor-rating");
    By popularmoviereviewlocator = By.className("movie-overview");
    By popularplaybtnlocator = By.className("play-button");
    By popularratingcountlocator = By.cssSelector("div.rating-category>:nth-child(2)");
    By popularbudgetlocator = By.cssSelector("div.budget-category>:nth-child(2)");
    By popularreleasedatelocator = By.cssSelector("div.budget-category>:last-child");
    By populargenereslocator = By.className("genres-heading");
    By popularaudioslist = By.className("audio-heading");
    public WebDriver driver;
    public MovieDetailsPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickonhomeelement(){

        driver.findElement(homebtnlocator).click();
    }
    public void clcikonmovie()
    {
        driver.findElement(mvoieposter).click();
    }
    public WebElement findmovietitle(){
        return driver.findElement(movietitlelocator);
    }
    public WebElement findmovieduration(){
        return driver.findElement(moviedurationlocator);
    }
    public WebElement findsensorrating(){
        return driver.findElement(sensorratinglocator);
    }
    public WebElement findmoviereview(){
        return driver.findElement(moviereviewlocator);
    }
    public WebElement findplaybtn(){
        return driver.findElement(playbtnlocator);
    }
    public WebElement findcountofratings(){
        return driver.findElement(ratingcountlocator);
    }
    public WebElement findbudget(){
        return driver.findElement(budgetlocator);
    }
    public WebElement findmoviereleasedate(){
        return driver.findElement(releasedatelocator);
    }
    public WebElement findgenere(){
        return driver.findElement(genereslocator);
    }
    public WebElement findaudios(){
        return driver.findElement(audioslist);
    }
    public void clickonpopularpage(){
        driver.findElement(popularpagelinklocator).click();
    }
    public void clickonpopularmovie(){
        driver.findElement(popularpagemovie).click();
    }
    public WebElement findpopularmovietitle(){
        return driver.findElement(popularmovietitle);
    }
    public WebElement findpopularmovieduration(){
        return driver.findElement(popularmoviedurationlocator);
    }
    public WebElement findpopularsensorrating(){
        return driver.findElement(popularsensorratinglocator);
    }
    public WebElement findpopularmoviereview(){
        return driver.findElement(popularmoviereviewlocator);
    }
    public WebElement findpopularplaybtn(){
        return driver.findElement(popularplaybtnlocator);
    }
    public WebElement findpopularcountofratings(){
        return driver.findElement(popularratingcountlocator);
    }
    public WebElement findpopularbudget(){
        return driver.findElement(popularbudgetlocator);
    }
    public WebElement findpopularmoviereleasedate(){
        return driver.findElement(popularreleasedatelocator);
    }
    public WebElement findpopulargenere(){
        return driver.findElement(populargenereslocator);
    }
    public WebElement findpopularaudios(){
        return driver.findElement(popularaudioslist);
    }
}
