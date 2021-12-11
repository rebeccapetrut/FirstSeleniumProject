import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public void register(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Jane");
        driver.findElement(By.id("middlename")).sendKeys("Jr");
        driver.findElement(By.id("lastname")).sendKeys("Doe");
        driver.findElement(By.id("email_address")).sendKeys("janejrdoe@mailinator.com");
        driver.findElement((By.id("password"))).sendKeys("password");
        driver.findElement(By.id("confirmation")).sendKeys("password");
        driver.close();

    }
}
