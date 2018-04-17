package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

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


    public void open() {
        //driver.get("https://admin:admin123@diploma-courses.7bits.it/login");
        driver.get("https://diploma-courses.7bits.it/login");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
