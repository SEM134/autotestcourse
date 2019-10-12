import onlineShopPage.OnlineShopPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NGOnlineShopTest extends BaseTest {

    OnlineShopPage page;

    @Test
    public void verifyAddItemToCartWithActins() {
        final String expectedTotalPrice = "$29.00";

        page = new OnlineShopPage(driver);
        page.searchItem("Bloose").switchOnListView();
        page.clickButtonAddToCart();
        page.clickProccedToCheckoutButton();
        String actualTotalPrice = driver.findElement(By.id("total_price")).getText();

        org.junit.Assert.assertEquals("Two elements NOT equal", expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void workWithMenu() {
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
