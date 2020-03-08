import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import testUI.Configuration;

import static testUI.Configuration.*;
import static testUI.UIOpen.open;
import static testUI.elements.TestUI.E;

public class TestUITest {

    @Before
    public void setAndroidPlatform() {
        Configuration.automationType = Configuration.ANDROID_PLATFORM;
        automationName = "UiAutomator1";
    }

    @Test
    public void TEST_TESTUI_01() {

        androidAppPath = "src/test/resources/app/LoginApp.apk";
//        chromeDriverPath = "/";
//        installMobileChromeDriver = false;
        open();
//        addMobileDesiredCapabilities.setCapability("noReset", false);

        E(By.id("textInputEditTextEmail")).sendKeys("myemail@email.com");
        E(By.id("textInputEditTextPassword")).sendKeys("myemail@email.com");
        E(By.id("appCompatButtonLogin")).click();
    }

    @Test
    public void TEST_TESTUI_02() {

//        chromeDriverPath = "/";
//        installMobileChromeDriver = false;
//        Configuration.appPackage = "appPackage";
//        Configuration.appActivity = "appActivity";
        open("https://ru.aliexpress.com/");

    }
}
