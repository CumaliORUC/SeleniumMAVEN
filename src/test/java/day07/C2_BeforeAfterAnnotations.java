package day07;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C2_BeforeAfterAnnotations {
    WebDriver driver;
@Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    System.out.println("setup çalıştı");
    }
    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        System.out.println("Teardown çalıştı");
    }
    @Test
    public void test01()  {

        driver.get("https://techproeducation.com");
        System.out.println("Test01 çalıştı");
    }
    @Test
    public void test02() {

        driver.get("https://www.amazon.com");
        System.out.println("Test02 çalıştı");
    }
    @Test
    public void test03()  {

        driver.get("https://www.facebook.com");
        System.out.println("Test03 çalıştı");
    }
}
