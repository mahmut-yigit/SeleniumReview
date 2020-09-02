import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
public class Day03_Ornek {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    // 1. DropDown'da Books kategorisini seçelim.
// 2. Arama kutusuna JAVA yazalım.
// 3. Toplam sonuç sayısını ekrana yazdıralım.
// 4. İlk sıradaki ürüne tıklayalım.
// 5. Back to results linki varsa, testimiz TRUE yoksa FALSE
    //      pass        fail
    public void amazonDropdownMyTest() {
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Books");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("JAVA");

        driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();

        System.out.println(driver.findElement(By.xpath("//*[.='1-16 of over 20,000 results for']")).getText());

        WebElement effectiveJava = driver.findElement(By.xpath("//*[.='Effective Java']"));
        effectiveJava.click();

        WebElement result = driver.findElement(By.xpath("//a[@id='breadcrumb-back-link']"));
        boolean resultTrue = result.isDisplayed();
        Assert.assertTrue(resultTrue);
    }

    @Test
    public void amazonDropdownTest() {
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Books");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("JAVA" + Keys.ENTER);
        WebElement ilkUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        ilkUrun.click();
        WebElement backToResultLinki = driver.findElement(By.partialLinkText("Back to results"));
        boolean varMi = backToResultLinki.isDisplayed();
        Assert.assertTrue(varMi); // TRUE gelirse, TESTİM başarılı

    }
}