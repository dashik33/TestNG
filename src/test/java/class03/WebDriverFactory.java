package class03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static  void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void tearDown() {
        driver.get().close();
        driver.remove();
    }


}
