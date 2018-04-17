package SeleniumTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumAuthenticationTest {

    @Test
    public void PositiveAuthenticationTest() throws Exception {
        ChromeDriver driver = new ChromeDriver();
        LoginPage logPage = new LoginPage(driver);
        logPage.open();
        HomePage homePage = logPage.loginUser("admin","admin");
        Thread.sleep(3000);
        assertEquals(true, homePage.isLoginIn());
        driver.close();
    }

    @Test
    public void NullPassvordAuthenticationTest() throws Exception {
        ChromeDriver driver = new ChromeDriver();
        LoginPage logPage = new LoginPage(driver);
        logPage.open();
        logPage.loginUser("admin","");
        assertEquals("true", logPage.buttonStatus());
        driver.close();
    }

    @Test
    public void DoublePasswordAuthenticationTest() throws Exception {
        ChromeDriver driver = new ChromeDriver();
        LoginPage logPage = new LoginPage(driver);
        logPage.open();
        HomePage homePage = logPage.loginUser("admin","adminadmin");
        Thread.sleep(3000);
        assertEquals(false, homePage.isLoginIn());
        driver.close();
    }

    @Test
    public void PasswordEyeTest(){
        ChromeDriver driver = new ChromeDriver();
        LoginPage logPage = new LoginPage(driver);
        logPage.open();
        logPage.passwordEye.click();
        assertEquals("form-password-field__hide-show form-password-field__hide-show_opened",logPage.passwordEye.getAttribute("class"));
        assertEquals("text",logPage.fieldPassword.getAttribute("type"));
        logPage.passwordEye.click();
        assertEquals("form-password-field__hide-show ",logPage.passwordEye.getAttribute("class"));
        assertEquals("password",logPage.fieldPassword.getAttribute("type"));
        driver.close();
    }
}
