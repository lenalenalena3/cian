package description;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class SearchPage {

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//button[@data-reactid='15']")
    private WebElement fieldAction;

    @FindBy(how = How.XPATH, using = "//button[@data-reactid='18']")
    private WebElement fieldRealty;

    @FindBy(how = How.XPATH, using = "//button[@data-reactid='22']")
    private WebElement fieldCategory;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'комн') or contains(text(),'своб') or contains(text(),'студия') or text()='Комнат']")
    private WebElement fieldNumberRooms;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='от']")
    private WebElement fieldPriceFirst;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='до']")
    private WebElement fieldPriceLast;

    @FindBy(how = How.XPATH, using = "//span[@data-reactid='42']/input")
    private WebElement fieldCity;

    @FindBy(how = How.XPATH, using = "//button[text()='Найти']")
    private WebElement buttonFind;

    public void setfieldAction(WebDriver driver, String value) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(fieldAction));
        fieldAction.isDisplayed();
        fieldAction.click();
        WebElement element = driver.findElement(By.xpath("//span[@data-reactid='14']//div[text()='" + value + "']"));
        element.click();
        assertTrue(fieldAction.getText().equalsIgnoreCase(value));
    }

    public void setfieldRealty(WebDriver driver, String value) {
        (new WebDriverWait(driver, 100)).until(ExpectedConditions.visibilityOf(fieldRealty));
        fieldRealty.isDisplayed();
        fieldRealty.click();
        WebElement element = driver.findElement(By.xpath("//div[@data-reactid='17']//span[text()='" + value + "']"));
        element.click();
    }

    public void setfieldCategory(WebDriver driver, String value) {
        (new WebDriverWait(driver, 100)).until(ExpectedConditions.visibilityOf(fieldCategory));
        fieldCategory.isDisplayed();
        fieldCategory.click();
        WebElement element = driver.findElement(By.xpath("//div[@data-reactid='21']//span[text()='" + value + "']"));
        element.click();
    }

    private void clearNumberRooms(WebDriver driver) {
        (new WebDriverWait(driver, 100)).until(ExpectedConditions.visibilityOf(fieldNumberRooms));
        fieldNumberRooms.isDisplayed();
        fieldNumberRooms.click();
        driver.findElement(By.xpath("//span[@data-reactid='25']//label[text()='1-комнатная']")).click();
        driver.findElement(By.xpath("//span[@data-reactid='25']//label[text()='2-комнатная']")).click();
    }

    public void setfieldNumberRooms(WebDriver driver, Map<String, Boolean> value) {
        clearNumberRooms(driver);
        for (Map.Entry<String, Boolean> item : value.entrySet()) {
            if (item.getValue()) {
                WebElement element = driver.findElement(By.xpath("//span[@data-reactid='25']//label[text()='" + item.getKey() + "']"));
                element.click();
            }
        }
    }

    public void setfieldPrice(WebDriver driver, String name, Double value) {
        WebElement fieldPrice = (name.equals("от")) ? fieldPriceFirst : fieldPriceLast;
        (new WebDriverWait(driver, 100)).until(ExpectedConditions.visibilityOf(fieldPrice));
        fieldPrice.isDisplayed();
        fieldPrice.click();
        fieldPrice.sendKeys(value.toString());
    }

    public void setfieldCity(WebDriver driver, String value) {
        (new WebDriverWait(driver, 100)).until(ExpectedConditions.visibilityOf(fieldCity));
        fieldCity.isDisplayed();
        fieldCity.click();
        fieldCity.clear();
        fieldCity.sendKeys(value.toString());
     //   fieldCity.sendKeys(Keys.ENTER);
        (new WebDriverWait(driver, 10000)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@title='Брянск, Россия']"))));

      //  WebElement element = driver.findElement(By.xpath("//div[@title='"+value+"']"));
      //  element.click();
    }

    public void buttonFindlClick(WebDriver driver){
        (new WebDriverWait(driver, 1000)).until(ExpectedConditions.visibilityOf(buttonFind));
        buttonFind.isDisplayed();
        buttonFind.click();
    }
}
