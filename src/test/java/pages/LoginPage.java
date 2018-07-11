package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

public class LoginPage {


    @FindBy(className = "login")
    WebElement login;

    @FindBy(id = "email_create")
    WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    WebElement submitCreate;

    @FindBy(id = "id_gender2")
    WebElement gender;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement days;

    @FindBy(id = "months")
    WebElement months;

    @FindBy(id = "years")
    WebElement years;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement idState;

    @FindBy(id = "postcode")
    WebElement postcode;

    @FindBy(id = "other")
    WebElement other;

    @FindBy(id = "phone")
    WebElement phone;

    @FindBy(id = "phone_mobile")
    WebElement phoneMobile;

    @FindBy(id = "alias")
    WebElement alias;

    @FindBy(id = "submitAccount")
    WebElement submitAccount;

    @FindBy(css = "h1")
    WebElement heading;


    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void login(){

        login.click();

        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        String name = "Firstname";
        String surname = "Lastname";

        emailCreate.sendKeys(email);
        submitCreate.click();


        gender.click();
        firstName.sendKeys(name);
        lastName.sendKeys(surname);
        password.sendKeys("Qwerty");

        Select select = new Select(days);
        select.selectByValue("1");
        select = new Select(months);
        select.selectByValue("1");
        select = new Select(years);
        select.selectByValue("2000");


        company.sendKeys("Company");
        address1.sendKeys("Qwerty, 123");
        address2.sendKeys("zxcvb");
        city.sendKeys("Qwerty");

        select = new Select(idState);
        select.selectByVisibleText("Colorado");

        postcode.sendKeys("12345");
        other.sendKeys("Qwerty");
        phone.sendKeys("12345123123");
        phoneMobile.sendKeys("12345123123");
        alias.sendKeys("hf");
        submitAccount.click();

    }

    public String getHeaderText(){
        return heading.getText();
    }

}
