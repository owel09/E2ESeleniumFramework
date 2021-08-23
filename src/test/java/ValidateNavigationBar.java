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

    @BeforeTest
    public void initializer() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void homePageNavigationBar()  {

        LandingPage landingPage = new LandingPage(driver);

        //check kung displayed ba yung Navigation bar sa taas
        Assert.assertTrue(landingPage.getnavigationBar().isDisplayed());

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }


    }
