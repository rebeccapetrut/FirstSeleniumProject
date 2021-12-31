import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {

    private WebDriver driver;

    @Before
    public  void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToCart(){
        driver.findElement(By.cssSelector(".level0.nav-5>a.level0.has-children")).click();
        driver.findElement(By.cssSelector("div.actions>a.button")).click();
        driver.findElement(By.cssSelector("span.swatch-label>img")).click();
        driver.findElement(By.cssSelector(".option-xs")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons")).click();

        WebElement addToCartSuccessfulElement = driver.findElement(By.cssSelector("li.success-msg ul li span"));
        Assert.assertTrue(addToCartSuccessfulElement.isDisplayed());
    }

    @Test
    public void proceedToCheckOut(){
        WebElement accountLink = driver.findElement(By.cssSelector("li.item:nth-child(2)"));
        accountLink.click();
        driver.findElement(By.cssSelector("li#option20.option-black.is-media")).click();
        driver.findElement(By.cssSelector("li#option81.option-xs")).click();
        driver.findElement(By.cssSelector("div .add-to-cart button.button.btn-cart")).click();
        driver.findElement(By.cssSelector("li.method-checkout-cart-methods-onepage-bottom button.button.btn-proceed-checkout.btn-checkout")).click();
    }

    @Test
    public void deleteButton(){
        WebElement accountLink = driver.findElement(By.cssSelector("li.item:nth-child(2)"));
        accountLink.click();
        driver.findElement(By.cssSelector("li#option20.option-black.is-media")).click();
        driver.findElement(By.cssSelector("li#option81.option-xs")).click();
        driver.findElement(By.cssSelector("div .add-to-cart button.button.btn-cart")).click();
        driver.findElement(By.cssSelector("td.a-center.product-cart-remove.last>a.btn-remove.btn-remove2")).click();
    }





    @After
    public void close(){
        driver.quit();
    }



}
