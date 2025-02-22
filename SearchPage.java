package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import java.util.List;
public class SearchPage {
    @FindBy(css = "div.search-account-container>button.search-empty-button")
    WebElement serachbtnlinklocator;
    @FindBy(css = "div.search-container>input#search")
    WebElement searchfiledlocator;
    @FindBy(how = How.CLASS_NAME, using = "search-button")
    WebElement searchbtnlocator;
    @FindBy(css = "ul.search-movies-container>li.movie-icon-item>a")
    List<WebElement> listofmovies;
    @FindBy(css = "div.not-found-search-container>:first-child")
    WebElement searchnotfoundimglocator;
    @FindBy(how = How.CLASS_NAME, using = "not-found-search-paragraph")
    WebElement searchnotfoundparalocator;
    public WebDriver driver;
    public WebDriverWait wait;
    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void clickonsearlinkbtn(){

        serachbtnlinklocator.click();
    }
    public void searchmovieAt(String SearchText)
    {
        searchfiledlocator.sendKeys(SearchText);
    }
    public void clickonsearchbtn(){
        searchbtnlocator.click();
    }
    public void search(String SearchText){
        searchmovieAt(SearchText);
        clickonsearchbtn();
    }
    public int getthecountofallmoviesdisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.search-movies-container>li.movie-icon-item")));
        return listofmovies.size();
    }
    public WebElement findsearchnotfoundimg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.not-found-search-container>:first-child")));
        return searchnotfoundimglocator;
    }
    public String findsearchnotfoundtext(){
        return searchnotfoundparalocator.getText();
    }
}
