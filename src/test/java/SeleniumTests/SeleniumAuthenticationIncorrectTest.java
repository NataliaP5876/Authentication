package SeleniumTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumAuthenticationIncorrectTest {
    //private static WebDriver driver= new ChromeDriver() ;
    private static WebDriver driver;

    @BeforeAll
    public static void startDriver(){
       driver = new ChromeDriver();
    }

    @Test
    public void NullPasswordAuthenticationTest() throws Exception {
        LoginPage logPage = new LoginPage(driver);
        logPage.open();
        logPage.loginUser("admin","");
        assertEquals("true", logPage.buttonStatus());
    }

    @Test
    public void WrongPasswordAuthenticationTest() throws Exception {
        LoginPage logPage = new LoginPage(driver);
        logPage.open();
        HomePage homePage = logPage.loginUser("admin","adminadmin");
        assertEquals(false, homePage.isLoginIn());
    }

    @Test
    public void PasswordEyeTest(){
        LoginPage logPage = new LoginPage(driver);
        logPage.open();
        logPage.passwordEye.click();
        assertEquals("form-password-field__hide-show form-password-field__hide-show_opened",logPage.passwordEye.getAttribute("class"));
        assertEquals("text",logPage.fieldPassword.getAttribute("type"));
        logPage.passwordEye.click();
        assertEquals("form-password-field__hide-show ",logPage.passwordEye.getAttribute("class"));
        assertEquals("password",logPage.fieldPassword.getAttribute("type"));
    }

    @AfterAll
    public static void closerDriver(){
        driver.quit();
    }
}
