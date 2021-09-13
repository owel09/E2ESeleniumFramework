import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*
 *Created by owel on 13/09/2021 9:55 AM
 * declare static extentReports globally kasi gagamitin yan ng ibang class, magkakaerror din kasi yung mga extentReports sa loob ng method
 * declare static yung getReportObject para madaling magamit ng Listener
 * declare String path
 * declare ExtentSparkReporter tapos attach yung path
 * config extentSparkReporter setReportName
 * config extentSparkReporter setDocumentTitle
 * config extentReport para maatach yung extentSparkReporter
 */
public class ExtentReportsNG {
    static ExtentReports extentReports;

    public static ExtentReports getReportObject(){
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);

        extentSparkReporter.config().setReportName("Web Automation Results");
        extentSparkReporter.config().setDocumentTitle("Test Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester","Owel");
        return extentReports;

    }
}
