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
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
    public static WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test(groups="regression")
    public void verifyCredentials() {

        SoftAssert soft=new SoftAssert();

        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        boolean displayed = username.isDisplayed();

        driver.findElement(By.id("txtPassword")).sendKeys("123456");

        driver.findElement(By.id("btnLogin")).click();

        String text = driver.findElement(By.id("spanMessage")).getText();
        String expectedText = "Invalid credentials 101";

        soft.assertTrue(displayed);
        soft.assertEquals(text, expectedText);
        soft.assertAll(); //without assertAll all tests seem to pass in soft assertions. so, we must have it at the end
        //to see which ones are actually failed. it's underlined cause some assertions failed
    }

    @Test(groups = "smoke")
    public void loginTest2(){
        System.out.println("Test for login under smoke");
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}

