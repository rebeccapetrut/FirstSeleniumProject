import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {

    private  WebDriver driver;

    @Before
    public  void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void loginWithValidCredentials() {
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector(".hello strong"));
        String welcomeText = welcomeTextElement.getText();

        Assert.assertTrue(welcomeTextElement.isDisplayed());
        Assert.assertEquals("Hello, Cosmin Fast", welcomeText);

        WebElement stateDropdown = driver.findElement(By.id("billing:region_id"));
        Select select = new Select(stateDropdown);
        select.selectByIndex(1);
        select.selectByVisibleText("Alaska");

    }


    @Test
    public void loginWithInvalidCredentials() {
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fsttrackit.org");
        driver.findElement(By.id("pass")).sendKeys(RandomString.make(6));
        driver.findElement(By.id("send2")).click();
        String text = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span")).getText();

        if (text.equals("Invalid login or password."))
            System.out.println("Success");
        else
            System.err.println("Fail");
    }

    @Test
    public void singOut(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("div #header-account li.last")).click();

        WebElement byeTextElement = driver.findElement(By.cssSelector("div.page-title > h1"));
        String byText = byeTextElement.getText();

        Assert.assertTrue(byeTextElement.isDisplayed());
        Assert.assertEquals("YOU ARE NOW LOGGED OUT", byText);


    }



    @After
    public void close(){
        driver.quit();
    }




}


