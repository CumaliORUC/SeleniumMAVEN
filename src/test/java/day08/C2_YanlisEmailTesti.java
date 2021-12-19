package day08;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class C2_YanlisEmailTesti {
    /*
    Bir Class olusturalim YanlisEmailTesti
    http://automationpractice.com/index.php sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
    “Invalid email address” uyarisi ciktigini test edelim
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void yanlisEmailTesti(){
        driver.get("http://automationpractice.com/index.php");
        //Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();
        WebElement emailKutusu= driver.findElement(By.xpath("//input[@id='email_create']"));
        String yanlisEmail="asdfgh";
        emailKutusu.sendKeys(yanlisEmail);
        emailKutusu.submit();
        WebElement hataYazisiWebelementi=driver.findElement(By.xpath("//li[text()='Invalid email address.']"));
        // “Invalid email address” uyarisi ciktigini test edelim
        String expectedHataYazisi = "Invalid email address";
        String actualHataYazisi=hataYazisiWebelementi.getText();
        Assert.assertEquals(expectedHataYazisi,actualHataYazisi);
    }
}
