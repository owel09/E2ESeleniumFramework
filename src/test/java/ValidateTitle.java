import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

/*
 *Created by owel on 15/08/2021 7:53 PM
 * extends mo yung base para matawag mo yung driver at method initializeDriver
 */
public class ValidateTitle extends Base{

    @Test
    public void HomePageNavigation() throws IOException {

        driver = initializeDriver();
        driver.get("http://www.qaclickacademy.com/");

        LandingPage landingPage = new LandingPage(driver);

        //compare mo yung present text sa HomePage "Featured Courses". gamit ka ng Assert
        System.out.println(landingPage.gettextFeaturedCourses().getText());
        Assert.assertEquals(landingPage.gettextFeaturedCourses().getText(),"FEATURED COURSES");
        //check kung displayed ba yung Navigation bar sa taas
        Assert.assertTrue(landingPage.driver.findElement(By.cssSelector("ul.nav.navbar-nav.navbar-right")).isDisplayed());


    }


    }
