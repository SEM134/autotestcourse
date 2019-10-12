
import onlineShopPage.OnlineShopPage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NGOnlineShopTest extends BaseTest {

    OnlineShopPage page;

    @Test
    public void verifyAddItemToCartWithActins() {
        page = new OnlineShopPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@title='Women']"))).build().perform();

        driver.findElement(By.xpath("//a[@title='T-shirts']")).click();
    }

    @Test(dataProvider = "create account", dataProviderClass = CreateAccountDataProvider.class)
    public void verifyCreateAccount(String email, String massage) {
        page = new OnlineShopPage(driver);

        page.clickSignIn();
        page.waitEmailField();
        page.enterIntoEmailField(email);
        page.clickButtonCreateAccount();
        page.waitErrorMessage();
        Assert.assertEquals(page.getErrorMessage(), massage);
    }




}
