import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 *Created by Work on 13/8/2021 7:21 PM
 */
public class Base {

    public void initializeBrowser() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/data.properties");

        properties.load(fileInputStream);
        String browserName = properties.getProperty("browser");

        if(browserName == "chrome"){

            System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
            WebDriver webDriver = new ChromeDriver();

        }else if(browserName=="firefox"){

        }else if (browserName=="IE"){

        }

    }
}
