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

    private By signIn = By.cssSelector("[class='fa fa-lock fa-lg']");
    private By textFeaturedCourses = By.cssSelector("div.text-center>h2");
    private By navigationBar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
    private By mailIcon = By.cssSelector("a[href*='info@qaclickacademy.com']");

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    //improved getLogin, clicking login button and giving the next page object para maccess yung methods ng LoginPage
    public LoginPage getLogin(){

        driver.findElement(signIn).click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }

    public WebElement gettextFeaturedCourses(){
        return driver.findElement(textFeaturedCourses);
    }

    public WebElement getnavigationBar(){
        return driver.findElement(navigationBar);
    }

    public WebElement getmailIcon(){
        return driver.findElement(mailIcon);
    }


}
