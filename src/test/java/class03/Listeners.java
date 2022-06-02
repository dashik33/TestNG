package class03;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test case has failed "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test case has passed "+result.getName());
    }

}
