import org.testng.annotations.Test;

import java.io.IOException;

/*
 *Created by owel on 15/08/2021 7:53 PM
 */
public class Homepage extends Base{

    @Test
    public void basePageNavigation() throws IOException {

        //tinype muna yung initializeBrowser()
        //tapos nilagyan ng driver = kasi ang nirereturn ng initializeBrowser is driver
        //galing yung driver sa Base na na-ideclare as public para maaccess dito sa bagong class

        driver = initializeDriver();
        driver.get("http://www.qaclickacademy.com/");
    }
}