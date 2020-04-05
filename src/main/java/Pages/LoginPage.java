package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private AndroidDriver<AndroidElement> driver;

    @AndroidFindBy(className = "name")
    private AndroidElement nameElement;

    @AndroidFindBy(className = "password")
    private AndroidElement passwordElement;

    @AndroidFindBy(className = "login")
    private AndroidElement loginElement;

    @AndroidFindBy(className = "UIAKeyboard")
    private AndroidElement keyboard;

    public LoginPage() {

    }

    public LoginPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isDisplayed() {
        return loginElement.isDisplayed();
    }
}
