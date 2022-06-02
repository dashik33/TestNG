package class01;

import org.testng.annotations.Test;

public class EnableAndDisable {
    @Test(enabled=false)
    public void firstTest(){
        System.out.println("1");
    }
    @Test
    public void secondTest(){
        System.out.println("2");
    }
    @Test
    public void thirdTest(){
        System.out.println("3");
    }
}
