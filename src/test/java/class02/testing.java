package class02;

import org.testng.annotations.*;

public class testing {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite"); //runs only once before execution all the tests in pom file
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite"); //runs only once after execution all the tests in pom file
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test"); //runs before each test tag in pom file
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After test"); //runs after each test tag in pom file
    }

    @BeforeClass //runs before all class tags in pom file
            public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass //runs after all class tags in pom file
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeMethod //runs before each method in the class
    public void before() {
        System.out.println("Before method");
    }

    @AfterMethod //runs after each method in the class
    public void after() {
        System.out.println("After method");
    }

    @Test
    public void test() {
        System.out.println("Drive me crazy , drive me mad");
    }

    @Test
    public void test2() {
        System.out.println("Drive me to sanity , drive me to hell");
    }
}
