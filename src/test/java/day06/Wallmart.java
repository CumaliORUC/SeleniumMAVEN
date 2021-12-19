package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*1-Test01 isimli bir class olusturun
2- https://www.walmart.com/ adresine gidin
        3- Browseri tam sayfa yapin
        4-Sayfayi “refresh” yapin
        5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        7- URL in walmart.com icerdigini control edin
        8-”Nutella” icin arama yapiniz
        9- Kac sonuc bulundugunu yaziniz
        10-Sayfayi kapatin */
public class Wallmart {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.walmart.com");
        driver.manage().window().maximize();
        driver.navigate().refresh();

        String title=driver.getTitle();

        if (title.contains("Save")) {
            System.out.println("Save İçeriyor");
        }
        else {
            System.out.println("Maalesef içermiyor");
            System.out.println("Gercek Baslık :" +title);
        }

        if (title.equals("Walmart.com | Save Money.Live Better")) {
            System.out.println("Başlık Walmart.com | Save Money.Live Better eşittir.");
        }
        else {
            System.out.println("Walmart.com | Save Money.Live Better Eşit Değil");
            System.out.println("Gercek Baslık :" +title);
        }
        String url=driver.getCurrentUrl();

        if (url.contains("walmart.com")) {
            System.out.println("Wallmart.com İçeriyor");
        }
        else {
            System.out.println("Maalesef içermiyor");
            System.out.println("Gercek Url :" +url);
        }
        WebElement arama= driver.findElement(By.xpath("//*[@id=\"global-search-input\"]"));
        arama.sendKeys("Nutella" + Keys.ENTER);

        System.out.println("Nutalla arama sonucu = " +driver.findElement(By.xpath("//div[@class='result-summary-container']")).getText());

        driver.close();
    }
}
