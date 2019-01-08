package step;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import description.SearchPage;
import description.ResultSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class StepInitial {
    static WebDriver driver;
    public static SearchPage searchPage;
    public static ResultSearchPage resultSearchPage;
    public static WebDriver getDriver() {
           if (driver == null) {

           // String catalog = System.getProperty("user.dir")+"\\src\\main\\resources\\IEDriverServer.exe";
           // System.setProperty("webdriver.ie.driver", catalog);
           // driver = new InternetExplorerDriver();

            String catalog = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", catalog);
            driver = new ChromeDriver();
            searchPage = new SearchPage(driver);
            resultSearchPage = new ResultSearchPage(driver);
        }
        return driver;
    }

    @Дано("^открыт браузер и осуществлен переход на сайт$")
    public void openBrouser() {
        driver = getDriver();
        driver.get("https://www.cian.ru");
    }

    @Тогда("^пользователь закрывает браузер$")
    public void closeBrouser() {
        driver.quit();
    }
}
