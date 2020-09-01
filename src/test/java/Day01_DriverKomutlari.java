import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_DriverKomutlari {
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");

        driver.navigate().to("http://amazon.com");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();

        driver.close();

        WebElement element=driver.findElement(By.className("nav-a  "));





    }
}
