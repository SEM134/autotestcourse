import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    private static final String URL = "http://automationpractice.com/";

    @BeforeMethod
    public void setUp() {
        //  System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        //        WebDriverManager.chromedriver().version("77.0").setup(); //для скачивания определенной версии драйвера
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
    }

    @AfterMethod
    public void close() {
        driver.close();
    }
}