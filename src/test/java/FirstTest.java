import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    //    System.setProperty("webdriver.chrome.driver", "C:\\projects\\autotestcourse2019\\src\\main\\resources\\drivers\\chromedriver.exe");
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\autotestcourse2019\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/");
    }

    @After
    public void close() {
        driver.close();
    }

    @Test
    public void testToCart() {
        driver.findElement(By.id("search_query_top")).sendKeys("Bloose");
        driver.findElement(By.name("submit_search")).click();
        driver.findElement(By.id("list")).click();
        driver.findElement(By.xpath("//a[@title='Add to cart']")).click();
        driver.findElement(By.xpath("//*[@title='Proceed to checkout']")).click();
        String value = driver.findElement(By.id("total_price")).getText();

        Assert.assertEquals("Two elements NOT equa", "29.00", value);
    }
}
