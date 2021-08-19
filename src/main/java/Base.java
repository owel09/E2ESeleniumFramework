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
 * declare public Webdriver para makita ng lahat ng class at matawag
 * declare public Properties kasi gagamitin natin ito sa ibang class, para di hardcoded yung URL
 * declare FileInputStream, path is src/main/resources/data.properties
 * connect mo yung properties at fis gamit yung prop.load
 * declare String browserName getProperty kasi gagamitin natin yan sa IF, yung getProperty kasi yung pangkuha ng String sa data.properties
 * IF gamit ka ng equals() method
 * pagpumasok setProperty and driver = new ChromeDriver(), ito na yung lagi natin ginagawa
 */
public class Base {

    public WebDriver driver;
    public Properties properties;

    public WebDriver initializeDriver() throws IOException {

        properties = new Properties();
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
