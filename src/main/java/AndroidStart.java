import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Ivan on 10.02.2017.
 */
public class AndroidStart {

    //private WebDriver driver;
    private AppiumDriver driver;

    @Before
    public void startUp() throws MalformedURLException{

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.4.2");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability("appium-version", "1.0.0");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void mul() {
        driver.findElement(By.id("com.android.calculator2:id/digit1")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit2")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit3")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit4")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit5")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit6")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit7")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit9")).click();

        driver.findElement(By.id("com.android.calculator2:id/mul")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit8")).click();

        driver.findElement(By.id("com.android.calculator2:id/equal")).click();

        Assert.assertEquals("98765432", driver.findElement(By.className("android.widget.EditText")).getText());

        driver.findElement(By.id("com.android.calculator2:id/clear")).click();
    }

    @Test
    public void sum() {
        driver.findElement(By.id("com.android.calculator2:id/digit2")).click();
        driver.findElement(By.id("com.android.calculator2:id/plus")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit2")).click();
        driver.findElement(By.id("com.android.calculator2:id/equal")).click();
        Assert.assertEquals("4", driver.findElement(By.className("android.widget.EditText")).getText());

        driver.findElement(By.id("com.android.calculator2:id/clear")).click();
    }

    @Test
    public void minus() {
        driver.findElement(By.id("com.android.calculator2:id/digit4")).click();
        driver.findElement(By.id("com.android.calculator2:id/minus")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit2")).click();
        driver.findElement(By.id("com.android.calculator2:id/equal")).click();
        Assert.assertEquals("1", driver.findElement(By.className("android.widget.EditText")).getText());

        driver.findElement(By.id("com.android.calculator2:id/clear")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
