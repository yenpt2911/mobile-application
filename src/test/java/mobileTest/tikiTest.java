package mobileTest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class tikiTest {
    public static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {


        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName","Android");
        cap.setCapability("deviceName","emulator-5554");
        cap.setCapability("appPackage","vn.tiki.app.tikiandroid");
        cap.setCapability("appActivity","vn.tiki.android.shopping.homeV3.HomeActivity");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url,cap);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        Thread.sleep(10);

        driver.findElement(By.id("vn.tiki.app.tikiandroid:id/ivCart")).click();
        Thread.sleep(10);

        String a = driver.findElement(By.xpath("//android.view.View[contains(@text,'Xin chào,')]")).getText();
        System.out.println(a);

        Assert.assertEquals(a,"Xin chào,");

/*        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Bách Hóa')]")).click();
        Thread.sleep(5);

        driver.findElement(By.id("\t\n" +
                "com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        Thread.sleep(5);

        Assert.assertEquals(driver.findElement(By.id("vn.tiki.app.tikiandroid:id/tvQuery")).getText(),"Bách Hóa");*/



       /* driver.findElement(By.xpath("//android.widget.TextView[@text='Lướt']")).click();
        Thread.sleep(5);

        driver.findElement(By.xpath("//android.widget.TextView[@text='Đã hiểu']")).click();

        String headerName = driver.findElement(By.xpath("//android.widget.TextView[@text='Lướt tin']")).getText();
        System.out.println(headerName);
        Assert.assertEquals(headerName, "Lướt tin");*/

        /*driver.findElement(By.xpath("//android.widget.TextView[@text='Mã giảm giá']")).click();
        Thread.sleep(10);

      String titlePage =  driver.findElement(By.xpath("//android.widget.TextView[@text='Chuyên trang tổng hợp mã giảm giá siêu hot tại Tiki | Tiki']")).getText();
      Assert.assertEquals(titlePage,"Chuyên trang tổng hợp mã giảm giá siêu hot tại Tiki | Tiki");*/


    }

}
