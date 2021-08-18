import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 *Created by owel on 17/08/2021 5:34 PM
 */
public class LoginPage {

    WebDriver driver;

    By email = By.cssSelector("input#user_email");
    By password = By.cssSelector("input#user_password");
    By submit = By.cssSelector("input[type='submit']");


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


}
