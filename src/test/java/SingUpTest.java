import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class SingUpTest {
    WebDriver driver;
    private static final String URL = "http://automationpractice.com/";
    private String clickSignIn = "//a[@class='login']";
    private String buttonSubmitCreate = "SubmitCreate";
    private String inputEmail = "email_create";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void close() {
        driver.close();
    }

    @Test
    public void testToCart() {
        String expectedResult = "MY ACCOUNT";

        driver.findElement(By.xpath(clickSignIn)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id(inputEmail)).sendKeys("cc1`2@cc.cc");
        driver.findElement(By.id(buttonSubmitCreate)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("customer_firstname")).sendKeys("firstName");
        driver.findElement(By.id("customer_lastname")).sendKeys("lastName");
        driver.findElement(By.id("passwd")).sendKeys("password");

        driver.findElement(By.id("firstname")).sendKeys("firstName");
        driver.findElement(By.id("lastname")).sendKeys("lastName");
        driver.findElement(By.id("address1")).sendKeys("adress");
        driver.findElement(By.id("city")).sendKeys("kiev");
        driver.findElement(By.id("id_state")).click();
        driver.findElement(By.xpath("//*[@id='id_state']/option[2]")).click();
//        driver.findElement(By.xpath("//*[@id='id_state']/option[2]")).isEnabled();// проверяет что поле редактируется.
//        driver.findElement(By.xpath("//*")).isEnabled();
//        driver.findElement(By.xpath("//*")).isDisplayed();
//        driver.findElement(By.xpath("//*")).isSelected();

        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("phone_mobile")).sendKeys("06688774411");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("submitAccount")).click();
        String actualResult = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();

        Assert.assertEquals("don't finded text " + expectedResult + ".", expectedResult, actualResult);
    }
}
