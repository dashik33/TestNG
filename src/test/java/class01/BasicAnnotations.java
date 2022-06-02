package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAnnotations {

    //tests execute in alphabetical order of the names of methods
    @Test(groups = "smoke")
    public void firstTest(){
        System.out.println("My first testcase");
    }
    @Test
    public void secondTest(){
        System.out.println("My second testcase");

    }
    @Test
    public void thirdTest(){
        System.out.println("My third testcase");

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method testcase");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method testcase");
    }
}
