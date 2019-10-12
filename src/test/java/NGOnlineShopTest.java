
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NGOnlineShopTest extends BaseTest{

    final String expectedTotalPrice = "$29.00";
    private String buttonAddToCart = "//a[@title='Add to cart']";
    private String searchInput = "search_query_top";


    @Test
    public void testToCart() {
        enterIntoSearchField("Bloose");
        clickSearchButton();
        clickListView();
        clickButtonAddToCart();
        clickProccedToCheckoutButton();
        String actualTotalPrice = driver.findElement(By.id("total_price")).getText();

        Assert.assertEquals("Two elements NOT equal", this.expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void testToCartWithPluss() {
        String expectedTotalPrice = "$56.00";
        driver.findElement(By.id(searchInput)).sendKeys("Bloose");
        driver.findElement(By.name("submit_search")).click();
        clickListView();
        driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div/div[3]/div/div[2]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='quantity_wanted_p']/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@title='Proceed to checkout']")))).click();
        String actualTotalPrice = driver.findElement(By.id("total_price")).getText();

        Assert.assertEquals("Two elements NOT equal", expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void testToCartWithPlussAndDELETE() {
        String expectedTotalPrice = "Your shopping cart is empty.";
        driver.findElement(By.id(searchInput)).sendKeys("Bloose");
        driver.findElement(By.name("submit_search")).click();
        clickListView();

        driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div/div[3]/div/div[2]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='quantity_wanted_p']/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.
                findElement(By.xpath("//*[@title='Proceed to checkout']")))).click();

        driver.findElement(By.xpath("//*[@id='2_7_0_0']")).click();

        String actualTotalResult = "";
//        WebElement asert = driver.findElement(By.xpath("//*[@id='center_column']/p"));
        try {
             actualTotalResult = webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='center_column']/p")))).getText();
        }catch (StaleElementReferenceException e) {
            actualTotalResult = webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='center_column']/p")))).getText();
        }


        Assert.assertEquals("Two elements NOT equal", expectedTotalPrice, actualTotalResult);
    }

    @Test
    public void verifyAddItemToCartWithActins() {
        Actions actions =  new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@title='Women']"))).build().perform();

        driver.findElement(By.xpath("//a[@title='T-shirts']")).click();


    }
    private void enterIntoSearchField(String item) {
        driver.findElement(By.id(searchInput)).sendKeys(item);
    }
    private void clickSearchButton() {
        driver.findElement(By.name("submit_search")).click();
    }
    private void clickListView() {
        driver.findElement(By.id("list")).click();
    }
    private void clickButtonAddToCart() {
        driver.findElement(By.xpath(this.buttonAddToCart)).click();
    }
    private void clickProccedToCheckoutButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@title='Proceed to checkout']")))).click();
    }
}
