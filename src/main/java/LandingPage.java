import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 *Created by owel on 16/08/2021 5:18 PM
 * declare instance variable - Webdriver driver;
 * create constructor kasi ipapasa mo yung driver na galing Base
 * create ng Objects using By. yung basic na Page Object Repository
 * create method with WebElement return;
 */
public class LandingPage {

    WebDriver driver;

    By signIn = By.cssSelector("[class='fa fa-lock fa-lg']");
    By textFeaturedCourses = By.cssSelector("div.text-center>h2");
    By navigationBar = By.cssSelector("ul.nav.navbar-nav.navbar-right");

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getLogin(){
        return driver.findElement(signIn);
    }

    public WebElement gettextFeaturedCourses(){
        return driver.findElement(textFeaturedCourses);
    }

    public WebElement getnavigationBar(){
        return driver.findElement(navigationBar);
    }


}
