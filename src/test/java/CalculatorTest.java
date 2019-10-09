import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorTest {
    /*
     * Unit tests
     * делаем в основном положительные тесты
     * */
    Calculator calc;

    @Before
    public void init() {
        calc = new Calculator();
    }

    @Test
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/");
        driver.findElement(By.id("search_query_top")).sendKeys("Bloose");
        driver.findElement(By.name("submit_search")).click();
        driver.findElement(By.id("list")).click();
        driver.findElement(By.xpath("//a[@title='Add to cart']")).click();
        driver.findElement(By.xpath("//*[@title='Proceed to checkout']")).click();
        String value = driver.findElement(By.id("total_price")).getText();

        Assert.assertEquals("Two elements NOT equa","29.00",value);

        driver.close();
    }

    @Test
    public void checkSumOfIntegers() {
        int expectedSum = 11;
        int ActualSum = calc.getSum(5, 6);
        Assert.assertEquals(expectedSum, ActualSum);
    }

    @Test
    public void checkDiffOfIntegers() {
        int expectedDiff = 3;
        int expectedDiffNEG = -3;
        int expectedDiffPOS = 13;
        int expectedDiffPOSplusNOL = 123;

        int ActualDiff = calc.getDifference(7, 4);
        int ActualDiffNEG = calc.getDifference(-8, -5);
        int ActualDiffPOS = calc.getDifference(15, 2);
        int ActualDiffPOSplusNOL = calc.getDifference(123, 0);
        Assert.assertEquals(expectedDiff, ActualDiff);

        Assert.assertEquals("POS", expectedDiffPOS, ActualDiffPOS);
        Assert.assertEquals("NEG", expectedDiffNEG, ActualDiffNEG);
        Assert.assertEquals("POSplusNOL", expectedDiffPOSplusNOL, ActualDiffPOSplusNOL);


    }

}
