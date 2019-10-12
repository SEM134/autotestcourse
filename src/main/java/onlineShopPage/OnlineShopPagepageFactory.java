package onlineShopPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineShopPagepageFactory {
    WebDriver driver;

    @FindBy(id="search_query_top")
    private WebElement inputSearch;
    @FindBy(id="list")
    private WebElement switchOnListView;
    @FindBy(name="submit_search")
    private WebElement clickSearchButton;

    private String buttonAddToCart = "//a[@title='Add to cart']";
    private String searchInput = "search_query_top";

    public OnlineShopPagepageFactory(WebDriver driver) {
        PageFactory.initElements(driver,this);
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
        inputSearch.sendKeys(item);
        //driver.findElement(By.id(searchInput)).sendKeys(item);
    }
    public void clickSearchButton() {
        clickSearchButton.click();
    }
    public OnlineShopPagepageFactory searchItem(String item) {
        enterIntoSearchField(item);
        clickSearchButton();
        return this;
    }
    public OnlineShopPagepageFactory switchOnListView() {
        switchOnListView.click();
        return this;
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
