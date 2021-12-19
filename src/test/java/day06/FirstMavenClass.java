package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstMavenClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);
        WebElement resultsWebElementi= driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println("Arama Sonucu: " +resultsWebElementi.getText());
        //Sadece sonuc adedini istersek Stringe atayıp orda String Manipulation yapabiliriz.
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        driver.navigate().back();

        List<WebElement> baslıklar=driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));

        for (WebElement w : baslıklar) {
            System.out.println(w.getText());
        }

        driver.close();
    }
}
