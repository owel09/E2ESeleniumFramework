import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

/*
 *Created by owel on 24/08/2021 3:58 PM
 * extends Base class kasi nandoon yung takeScreenshot method, tatawagin natin siya sa onTestFailure
 * type onTestSucess and onTestFailure para maoveride
 * result - nasa kanya lahat ng method na pwede natin gamitin
 * tawagin yung takeScreenshot method para ipass yung testCaseMethodName
 *
 * onTestStart() - dito ilalagay yung extentReports object para magamit ng lahat ng test case
 * parang global definition na siya
 *
 */
public class Listener extends Base implements ITestListener {


    /*declare ExtentReport extentReportsListener globally pero at call getReportObject(). naka static naman kaya classname.method pwede na
    extentReportsListener - ito yung object na gagamitin sa onTestStart at alam nya rin yung extentReport sa ExtentReportsNG
     */
    ExtentReports extentReportsListener = ExtentReportsNG.getReportObject();

    /*
    delcare extentTest globally kasi gagamitin sya ng lahat ng method dito
     */
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        //result.getMethod().getMethodName() -  yung method name yung magiging pangalan ng test sa report
        extentTest = extentReportsListener.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,"Test Passed");
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {

        //log fails in the report
        extentTest.fail(result.getThrowable());

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

    /*
    pang flush lang ng reporter after magrun
     */
    @Override
    public void onFinish(ITestContext context) {
        extentReportsListener.flush();
    }
}
