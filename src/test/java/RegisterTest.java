import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    private WebDriver driver;

    @Before
    public  void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void register(){
        driver.findElement(By.cssSelector("div.account-cart-wrapper>a span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Jane");
        driver.findElement(By.id("middlename")).sendKeys("Jr");
        driver.findElement(By.id("lastname")).sendKeys("Doe");
        String email = RandomString.make(8)+"@email.test";
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement((By.id("password"))).sendKeys(RandomString.make(6));
        driver.findElement(By.id("confirmation")).sendKeys(RandomString.make(6));


        // aici imi zice ca nu imi gaseste selectoru mesajului, dar am incercat si cu copy selector
        // dar tot aceeasi eroare imi apare
        WebElement welcomeTextElement = driver.findElement(By.cssSelector("li.success-msg > ul > li > span"));
        String welcomeText = welcomeTextElement.getText();

        Assert.assertTrue(welcomeTextElement.isDisplayed());
        Assert.assertEquals("Thank you for registering with Madison Island.", welcomeText);




    }


    @After
    public void close(){
        driver.quit();
    }
}
