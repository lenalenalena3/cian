package step;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import description.SearchPage;
import description.ResultSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

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

            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito"); //режим инкогнито- не сохранится информация о сайтах, которые посещали
            options.addArguments("-start-maximized"); //запуск на полный экран
            options.addArguments("-dom.webnotifications.enabled"); //отключение веб-push уведомлений
            options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
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
