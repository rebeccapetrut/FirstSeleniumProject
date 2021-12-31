import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

    private WebDriver driver;

    @Before
    public  void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void searchIcon(){
        WebElement accountLink = driver.findElement(By.cssSelector("button.button.search-button"));
        accountLink.click();
        driver.findElement(By.cssSelector("button.button.search-button")).click();
        driver.close();
    }

    @Test
    public void sortByButton(){
        WebElement accountLink = driver.findElement(By.cssSelector("li.level0.nav-5.parent a.level0.has-children"));
        accountLink.click();
        driver.findElement(By.cssSelector("div.category-products>div.toolbar>div.sorter>div.sort-by>select")).click();
    }

    @Test
    public void searchItem(){
        driver.findElement(By.id("search")).sendKeys("A TALE OF TWO CITIES");
        driver.findElement(By.cssSelector("button.button.search-button")).click();
        driver.findElement(By.cssSelector("li.item.last:nth-child(11) div.actions a.button")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons")).click();
    }




    @After
    public void close(){
        driver.quit();
    }

}
