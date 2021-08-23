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

    @BeforeTest
    public void initializer() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void homePageNavigationTitle()  {

        LandingPage landingPage = new LandingPage(driver);

        //compare mo yung present text sa HomePage "Featured Courses". gamit ka ng Assert
        System.out.println(landingPage.gettextFeaturedCourses().getText());
        Assert.assertEquals(landingPage.gettextFeaturedCourses().getText(),"FEATURED COURSES");

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }


    }