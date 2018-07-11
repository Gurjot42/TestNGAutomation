package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage {

    WebDriverWait wait;

    @FindBy(linkText = "Women")
    WebElement menuLink;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    WebElement imgLink;

    @FindBy(name = "Submit")
    WebElement Submit;

    @FindBy(linkText = "Proceed to checkout")
    WebElement ProceedToCheckout;

    @FindBy(name = "processAddress")
    WebElement processAddress;

    @FindBy(id = "uniform-cgv")
    WebElement formCGVClick;

    @FindBy(name = "processCarrier")
    WebElement processCarrier;

    @FindBy(className = "bankwire")
    WebElement bankwire;

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    WebElement cartButton;

    @FindBy(css = "h1")
    WebElement heading;


    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, 10, 50);
    }

    public void checkout(){

        wait.until(ExpectedConditions.visibilityOf(menuLink)).click();
        imgLink.click();
        Submit.click();

        ProceedToCheckout.click();
        ProceedToCheckout.click();

        processAddress.click();
        formCGVClick.click();
        processCarrier.click();
        bankwire.click();
        cartButton.click();
    }

    public String getHeaderText(){
        return heading.getText();
    }

}
