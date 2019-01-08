package description;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultSearchPage {

    public ResultSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Сохранить файл в Excel']")
    private WebElement buttonExcel;

    public void buttonExcelClick(WebDriver driver){
        (new WebDriverWait(driver, 1000)).until(ExpectedConditions.visibilityOf(buttonExcel));
        buttonExcel.isDisplayed();
        buttonExcel.click();
    }
}
