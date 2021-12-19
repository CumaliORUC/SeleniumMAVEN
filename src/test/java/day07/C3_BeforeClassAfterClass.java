package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C3_BeforeClassAfterClass {
   static WebDriver driver;
    @BeforeClass
    public static void setup() { //beforeclass ve after clası kullanırken claslar static olmalı.
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("setup çalıştı");
    }
    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        System.out.println("Teardown çalıştı");
    }
    @Test
    public void test01()  {

        driver.get("https://techproeducation.com");
        System.out.println("Test01 çalıştı");
    }
    @Test @Ignore          //Ignore varsa o o clasa girmeden devam ediyor.
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


