package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class FindElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addlink= driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addlink.click();

        Thread.sleep(3000);
        WebElement delete= driver.findElement(By.cssSelector("div#elements"));

        Assert.assertTrue(delete.isDisplayed(),"Delete is displayed");
        System.out.println("Görünür");
        Thread.sleep(3000);

        WebElement deletetusu= driver.findElement(By.cssSelector("button.added-manually"));
        deletetusu.click();

        Thread.sleep(3000);
        Assert.assertTrue(!deletetusu.isDisplayed(),"Delete is not displayed");
        System.out.println("Görünür değil");
        driver.close();
    }
}
