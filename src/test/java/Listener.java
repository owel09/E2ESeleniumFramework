import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

/*
 *Created by owel on 24/08/2021 3:58 PM
 * extends Base class kasi nandoon yung takeScreenshot method, tatawagin natin siya sa onTestFailure
 * type onTestSucess and onTestFailure para maoveride
 * result - nasa kanya lahat ng method na pwede natin gamitin
 * tawagin yung takeScreenshot method para ipass yung testCaseMethodName
 */
public class Listener extends Base implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("PASSED");
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = null;

        //para magkaroon ng life yung driver natin
        driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());



        /*
        declare String testCaseMethodName kasi gagamitin natin yan sa try catch at
        ipapasa sa takeScreenshot method sa Base
         */
        String testCaseMethodName = result.getMethod().getMethodName();
        /*
        call takeScreenshot tapos pass mo testCaseMethodName
        lalabas yung try catch as required solution
         */
        try {
            getScreenShotPath(testCaseMethodName, driver);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ITestListener.super.onTestFailure(result);
        System.out.println("FAILED" + result.getName());
    }
}
