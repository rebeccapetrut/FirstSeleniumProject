import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishlistTest {

    private WebDriver driver;

    @Before
    public  void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void addToWishlist(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector("li.level0.nav-5.parent a.level0.has-children")).click();
        driver.findElement(By.cssSelector("a.link-wishlist")).click();

        WebElement addSuccessfulElement = driver.findElement(By.cssSelector("li.success-msg ul li span"));
        String addSuccessful = addSuccessfulElement.getText();
        Assert.assertTrue(addSuccessfulElement.isDisplayed());
    }


    @After
    public void close(){
        driver.quit();
    }
}
