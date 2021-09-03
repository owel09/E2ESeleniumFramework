import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

/*
 *Created by owel on 24/08/2021 3:58 PM
 */
public class Listener extends Base implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        //result - madaming method yan, yung getMehodName yung pwede mo gamitin.
        //tapos ilagay mo sa String variable testCaseMethodName
        String testCaseMethodName = result.getMethod().getMethodName();

        //natawag ko agad yung takeScreenshot sa Base class kasi nag extends ako
        //yung try catch lumabas lang siya as required resolution
        try {
            takeScreenshot(testCaseMethodName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ITestListener.super.onTestFailure(result);
        System.out.println("FAILED" + result.getName());
    }
}
