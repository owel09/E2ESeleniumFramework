import javafx.beans.binding.ObjectExpression;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/*
 *Created by owel on 15/08/2021 7:53 PM
 * extends mo yung base para matawag mo yung driver at method initializeDriver
 */
public class Homepage extends Base{

    @Test (dataProvider = "getData")
    public void basePageNavigation(String email, String password) throws IOException {

        //tinype muna yung initializeBrowser()
        //tapos nilagyan ng driver = kasi ang nirereturn ng initializeBrowser is driver
        //galing yung driver sa Base na na-ideclare as public para maaccess dito sa bagong class
        driver = initializeDriver();
        driver.get("http://www.qaclickacademy.com/");

        //yung driver dito galing yung value sa base. extends kasi kaya nagamit ko din dito at pinass sa LandingPage
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getLogin().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(email);
        loginPage.getPassword().sendKeys(password);
        loginPage.getSubmit().click();

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