package onlineShopPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineShopPage {
    WebDriver driver;

    private String buttonAddToCart = "//a[@title='Add to cart']";
    private String searchInput = "search_query_top";

    public OnlineShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorMessage() {
        return driver.findElement(By.xpath("//div[@id='create_account_error']")).getText();
    }

    public void clickButtonCreateAccount() {
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
    }

    public void enterIntoEmailField(String s) {
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(s);
    }

    public void clickSignIn() {
        driver.findElement(By.xpath("//a[@class='login']")).click();
    }


    public void enterIntoSearchField(String item) {
        driver.findElement(By.id(searchInput)).sendKeys(item);
    }

    public void clickSearchButton() {
        driver.findElement(By.name("submit_search")).click();
    }

    public void searchItem(String item) {
        enterIntoSearchField(item);
        clickSearchButton();
    }





    public void switchOnListView() {
        driver.findElement(By.id("list")).click();
    }

    public void clickButtonAddToCart() {
        driver.findElement(By.xpath(this.buttonAddToCart)).click();
    }

    public void clickProccedToCheckoutButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@title='Proceed to checkout']")))).click();
    }

    public void waitEmailField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated((By.id("email_create"))));
    }

    public void waitErrorMessage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='create_account_error']"))));
    }
}
