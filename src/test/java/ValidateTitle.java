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
 * sa Homepage iccheck kung yung Featured Courses ay as expected
 */
public class ValidateTitle extends Base{

    WebDriver driver;

    private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());

    @BeforeTest
    public void initializer() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

        driver.get(properties.getProperty("url"));
        log.info("Navigated to Homepage");

    }

    @Test
    public void homePageNavigationTitle()  {

        LandingPage landingPage = new LandingPage(driver);

        //compare mo yung present text sa HomePage "Featured Courses". gamit ka ng Assert
        Assert.assertEquals(landingPage.gettextFeaturedCourses().getText(),"FEATURED COURSES1");
        log.info("Successfully validated text");

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }


    }
