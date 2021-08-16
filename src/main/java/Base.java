import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/*
 *Created by Work on 13/8/2021 7:21 PM
 */
public class Base {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/data.properties");

        properties.load(fileInputStream);
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
            driver = new ChromeDriver();


        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();


        } else if (browserName.equals("IE")) {
            driver = new InternetExplorerDriver();


        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }

}
