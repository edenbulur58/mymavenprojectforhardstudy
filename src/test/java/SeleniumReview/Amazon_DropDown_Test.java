package SeleniumReview;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Amazon_DropDown_Test {
    /*
    SoftAssert classından nesne üretmek zorundayız
    test fail olsa bile çalışmaya devam eder
     */
    static WebDriver driver;
    @BeforeClass
    public static  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    /*
    1 DropDown'da Books kategorisini seçelim
    2 Arama butonuna java yazalım
    3 Toplam sonuç sayısını ekrana yazdıralım
    4 ilk sıradaki ürünü tıklayalım
    5 Back to Results linki varsa, testiniz TRUE yoksa FALSE
                                         //pass        fail
     */
    @Test
    public void amazonDropDownTest(){
        driver.get("http://amazon.com");
        WebElement dropDown=driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Books");
        WebElement textBox=driver.findElement(By.id("twotabsearchtextbox"));
        textBox.sendKeys("Java"+ Keys.ENTER);
        WebElement resultOfJava=driver.findElement(By.xpath("//*[.='1-16 of over 20,000 results for']"));
        System.out.println(resultOfJava.getText());
        WebElement firstOption=driver.findElement(By.xpath("//*[.='Effective Java']"));
        firstOption.click();
        WebElement text=driver.findElement(By.cssSelector("#breadcrumb-back-link"));
        String resultOfText="Back to results";
        Assert.assertEquals(resultOfText,text.getText());
        List<WebElement>listOfJavaBooks= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        for (WebElement w:listOfJavaBooks) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(w.getText());
            System.out.println(w.getSize());
        }


    }
}
