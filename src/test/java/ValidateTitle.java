import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/*
 *Created by owel on 15/08/2021 7:53 PM
 * sa Homepage iccheck kung displayed ba yung navigation bar at Featured Courses
 */
public class ValidateTitle extends Base{

    @Test
    public void HomePageNavigation() throws IOException {

        driver = initializeDriver();
        driver.get(properties.getProperty("url"));

        LandingPage landingPage = new LandingPage(driver);

        //compare mo yung present text sa HomePage "Featured Courses". gamit ka ng Assert
        System.out.println(landingPage.gettextFeaturedCourses().getText());
        Assert.assertEquals(landingPage.gettextFeaturedCourses().getText(),"FEATURED COURSES");
        //check kung displayed ba yung Navigation bar sa taas
        Assert.assertTrue(landingPage.getnavigationBar().isDisplayed());


    }


    }
