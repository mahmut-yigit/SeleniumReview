import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.xml.transform.sax.SAXSource;
import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {
    /*
    // 1. Amazon.com'a gideceğiz.
// 2. Arama kutusuna "baby stroller"
// 3. 2. Sıradaki ürüne tıklayacağız.
// 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
// 5. Ürünün ortalama puanını (5 üzerinden) alacağız.
     */
    WebDriver driver;
    @Test
    public void amazon(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("baby stroller"+ Keys.ENTER);

        WebElement secondBabyStroller=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        secondBabyStroller.click();

        WebElement price=driver.findElement(By.xpath("//span[@id='priceblock_ourprice']"));
        System.out.println(price.getText());

        Actions actions=new Actions(driver);

        WebElement stars=driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star a-star-4-5'])[1]"));
        actions.moveToElement(stars).perform();

        WebElement starsCount=driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']"));
        System.out.println(starsCount.getText());
    }
    @Test
    public void test2(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://www.amazon.com/");
//        driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://www.google.com/");
        WebElement searchBox=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchBox.sendKeys("kemal ozden"+Keys.ENTER);


        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }

}
