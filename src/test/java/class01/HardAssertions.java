package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertions {
    public static WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

@Test
    public void verifyCredentials() {

    WebElement username = driver.findElement(By.id("txtUsername"));
    username.sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).sendKeys("123456");
    boolean displayed = username.isDisplayed();
    Assert.assertTrue(displayed);
    driver.findElement(By.id("btnLogin")).click();
    String text = driver.findElement(By.id("spanMessage")).getText();
    String expectedText = "Invalid credentials";
    Assert.assertEquals(text, expectedText);

}
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
