import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 *Created by owel on 17/08/2021 5:34 PM
 */
public class LoginPage {

    WebDriver driver;

    private By email = By.cssSelector("input#user_email");
    private By password = By.cssSelector("input#user_password");
    private By submit = By.cssSelector("input[type='submit']");
    private By forgotPassword = By.cssSelector("[href*='password/new']");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getEmail(){
        return driver.findElement(email);
    }

    public WebElement getPassword(){
        return driver.findElement(password);
    }

    public WebElement getSubmit(){
        return driver.findElement(submit);
    }

    public ForgotPasswordPage getForgotPassword(){
        driver.findElement(forgotPassword).click();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        return forgotPasswordPage;
    }


}
