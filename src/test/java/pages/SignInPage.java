package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    @FindBy(className = "login")
    WebElement login;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement passwd;

    @FindBy(id = "SubmitLogin")
    WebElement submitLogin;

    @FindBy(css = "h1")
    WebElement heading;

    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    public void login(String existingUserEmail, String existingUserPassword){
        login.click();
        email.sendKeys(existingUserEmail);
        passwd.sendKeys(existingUserPassword);
        submitLogin.click();
    }

    public String getHeaderText(){
        return heading.getText();
    }


}
