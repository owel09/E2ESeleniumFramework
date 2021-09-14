import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/*
 *Created by owel on 15/08/2021 7:53 PM
 * 3 beses maglologin sa qaacademy pero using dummy account, nakaintegrate yung DataProvider at data.properties
 * extends mo yung base para matawag mo yung driver at method initializeDriver
 * declare Webdriver locally para kung magrun ka ng parallel di magfafail
 * fundamental format to initialDriver at call url. Basic yan at dapat kabisado mo na
 * driver = initializeDriver();
 * driver.get(properties.getProperty("url"));
 */
public class Homepage extends Base{

    WebDriver driver;

    private static Logger log = LogManager.getLogger(Homepage.class.getName());

    @Test (dataProvider = "getData")
    public void loginPageNavigation(String email, String password) throws IOException {
        /*tinype muna yung initializeDriver()
         *tapos nilagyan ng driver = kasi ang nirereturn ng initializeDriver is driver
         *galing yung driver sa Base na na-ideclare as public para maaccess dito sa bagong class
         *kailangan mo to para matawag mo yung driver sa base. initial step yan
         */
        driver = initializeDriver();
        log.info("Driver is initialized");

        //para hindi lang hardcoded yung url
        driver.get(properties.getProperty("url"));
        log.info("Navigated to Homepage");

        /*ganito yung style ng pag-open ng page
        driver - galing sa Base class, using extends kaya nagamit dito need to pass sa LandingPage
         */
        LandingPage landingPage = new LandingPage(driver);

        //improved getLogin() kasi nasa loob nya na yung pagclick at pagopen ng LoginPage
        LoginPage loginPage = landingPage.getLogin();
        log.info("Login button is clicked");
        loginPage.getEmail().sendKeys(email);
        loginPage.getPassword().sendKeys(password);
        loginPage.getSubmit().click();

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][2];

        data[0][0] = "firstemail@example.com";
        data[0][1] = "password1";

        data[1][0] = "secondemail@example.com";
        data[1][1] = "password2";

        data[2][0] = "thirdemail@example.com";
        data[2][1] = "password3";

        return data;
    }
}