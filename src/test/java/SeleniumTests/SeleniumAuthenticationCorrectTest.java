package SeleniumTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumAuthenticationCorrectTest {

    private static WebDriver driver;

    @BeforeAll
    public static void startDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void PositiveAuthenticationTest() throws Exception {
        LoginPage logPage = new LoginPage(driver);
        logPage.open();
        HomePage homePage = logPage.loginUser("admin","admin");
        assertEquals(true, homePage.isLoginIn());
    }

    @AfterAll
    public static void closerDriver(){
        driver.quit();
    }
}
