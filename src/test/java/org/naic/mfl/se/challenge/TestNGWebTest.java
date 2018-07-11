package org.naic.mfl.se.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.SignInPage;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestNGWebTest {

    WebDriver driver;
    WebDriverWait wait;

    String existingUserEmail = "mflsqe@naic.org";
    String existingUserPassword = "mflsqe1234";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 50);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test(priority = 1)
    public void signInTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        assertEquals(loginPage.getHeaderText(), "MY ACCOUNT");
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }

    @Test(priority = 2)
    public void logInTest() {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.login(existingUserEmail,existingUserPassword);

        assertEquals(signInPage.getHeaderText(), "MY ACCOUNT");
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));

    }

    @Test(priority = 3)
    public void checkoutTest() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkout();

        assertEquals("ORDER CONFIRMATION", checkoutPage.getHeaderText());
        assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));

    }

}
