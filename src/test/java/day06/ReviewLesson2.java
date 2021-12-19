package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReviewLesson2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        WebElement search=driver.findElement(By.id("twotabsearchtextbox"));

        search.sendKeys("headhones");

        search.click();

        Thread.sleep(3000);
        List<WebElement> searchadvise=driver.findElements(By.cssSelector("#suggestions-template"));

        System.out.println("===========================Başlıklar=====================================");
        for (WebElement w: searchadvise) {

            System.out.println(w.getText());
        }

        search.submit();

        WebElement ikincikutu= driver.findElement(By.xpath("(//img[@class='s-image'])[2]"));

        ikincikutu.click();

        List<WebElement> mavikulaklık= driver.findElements(By.xpath("//table[@class='a-normal a-spacing-micro']"));
        System.out.println("====================İkinici Lİste =====================");
        for (int i=0; i<=mavikulaklık.size(); i++) {
            System.out.println(mavikulaklık.get(i).getText());
        }

        driver.close();
    }
}
