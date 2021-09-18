import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 *Created by owel on 14/09/2021 3:53 PM
 */
public class ForgotPasswordPage {

    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.cssSelector("[id='user_email']");
    private By sendMeInstruction = By.cssSelector("input[type='submit']");

    public WebElement getEmail()
    {
        return driver.findElement(email);
    }

    public WebElement getSendMeInstruction()
    {
        return driver.findElement(sendMeInstruction);
    }
}
