import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ForgotPassword extends Base{

    WebDriver driver;

    private static Logger log = LogManager.getLogger(ForgotPassword.class.getName());

    @Test
    public void forgotPasswordNavigation() throws IOException {

        driver = initializeDriver();

        driver.get(properties.getProperty("url"));
        log.info("Navigated to Homepage");

        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.getLogin();
        ForgotPasswordPage forgotPasswordPage = loginPage.getForgotPassword();
        forgotPasswordPage.getEmail().sendKeys("owel@123");
        forgotPasswordPage.getSendMeInstruction().click();

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }

}