package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReviewLesson3 {
    /*  1-Test01 isimli bir class olusturun
        2- https://www.walmart.com/ adresine gidin
        3- Browseri tam sayfa yapin
        4-Sayfayi “refresh” yapin
        5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        7- URL in walmart.com icerdigini control edin
        8-”Nutella” icin arama yapiniz
        9- Kac sonuc bulundugunu yaziniz
        10-Sayfayi kapatin */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.walmart.com/");

        driver.navigate().refresh();

        String baslik=driver.getTitle();

        System.out.println(baslik);

        Assert.assertTrue(baslik.toLowerCase().contains("save"));

        Assert.assertEquals("Walmart.com | Save Money. Live Better",baslik);

        String url= driver.getCurrentUrl();

        Assert.assertTrue(url.contains("walmart.com"));

        WebElement arama= driver.findElement(By.xpath("//input[@name='q']"));

        arama.sendKeys("Nutella");

        arama.click();

        List <WebElement> aramatavsiye=driver.findElements(By.xpath("//ul[@data-testid='typeahead-list']"));

        for (WebElement w:aramatavsiye) {

            System.out.println(w.getText());

        }
        System.out.println("=============================================================================");

        arama.submit();

        WebElement toplam=driver.findElement(By.xpath("//h1"));

        System.out.println("Toplam Sonuc---------------> "+ toplam);

        driver.close();

    }

}
