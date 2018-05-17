package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends Page {

    private final String username = "username";
    private final String password = "password";

    @FindBy(name="login")
    public WebElement fieldLogin;

    @FindBy(name="password")
    public WebElement fieldPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonLogin;

    @FindBy(className = "form-password-field__hide-show")
    public WebElement passwordEye;



    private void init() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        init();
    }

    @Override
    public void open() {
        driver.get("https://admin:admin123@diploma-courses.7bits.it/login");
        driver.get("https://diploma-courses.7bits.it/login");
        WebElement explicitWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }

    public HomePage loginUser(String login, String password){
        type(fieldLogin,login);
        type(fieldPassword,password);
        buttonLogin.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
    public String buttonStatus(){
        return buttonLogin.getAttribute("disabled");
    }
}
