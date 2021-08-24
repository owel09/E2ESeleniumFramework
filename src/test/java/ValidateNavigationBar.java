import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/*
 *Created by owel on 15/08/2021 7:53 PM
 * sa Homepage iccheck kung displayed ba yung navigation bar
 */
public class ValidateNavigationBar extends Base{

    WebDriver driver;

    private static Logger log = LogManager.getLogger(ValidateNavigationBar.class.getName());

    @BeforeTest
    public void initializer() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
        driver.get(properties.getProperty("url"));
        log.info("Navigated to Homepage");
    }

    @Test
    public void homePageNavigationBar()  {

        LandingPage landingPage = new LandingPage(driver);

        //check kung displayed ba yung Navigation bar sa taas
        Assert.assertTrue(landingPage.getnavigationBar().isDisplayed());
        log.info("Navigation bar is displayed");

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }


    }
