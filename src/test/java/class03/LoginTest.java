package class03;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class LoginTest{

    @BeforeMethod
    public void openBrowser() {
        WebDriverFactory.setDriver();
        WebDriverFactory.getDriver().get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test(groups = "regression")
    public void VerifyCredentials() throws InterruptedException {

        SoftAssert soft = new SoftAssert();

        String expectedText = "Invalid credentials";
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(By.id("txtUsername")).sendKeys("123456");
        WebDriverFactory.getDriver().findElement(By.id("txtPassword")).sendKeys("123456");
        WebDriverFactory.getDriver().findElement(By.id("btnLogin")).click();
        String text = WebDriverFactory.getDriver().findElement(By.id("spanMessage")).getText();
        soft.assertEquals(text, expectedText);
        soft.assertAll();

    }

    @Test(groups = "regression")
    public void VerifyCredentials2() {

        SoftAssert soft = new SoftAssert();

        String expectedText = "Invalid credentials";
        WebDriverFactory.getDriver().findElement(By.id("txtUsername")).sendKeys("1234");
        WebDriverFactory.getDriver().findElement(By.id("txtPassword")).sendKeys("123");
        WebDriverFactory.getDriver().findElement(By.id("btnLogin")).click();
        String text =  WebDriverFactory.getDriver().findElement(By.id("spanMessage")).getText();
        soft.assertEquals(text, expectedText);
        soft.assertAll();

    }

    @AfterMethod
    public void CloseBrowser() {
        WebDriverFactory.tearDown();
        }
    }
