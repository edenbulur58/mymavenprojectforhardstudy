package SeleniumReview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/* drop down : açılır menü

 <select id="menu" type="drop">
       <option value="value1">Bilgisayarlar</option>
       <option value="value2">Telefonlar</option>
       <option value="value3">Tabletler</option>
 </select>

 ------>Hangi locatorlar ile bulabilirsiniz
        id,xpath,cssSelector,tagName

 örnek : By.id("menu")

  */
public class DropDown {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        //driver nesnesi oluşturduk
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
@Test
    public void dropDown(){
       driver.get("http://amazon.com");
    WebElement dropDown=driver.findElement(By.cssSelector("#searchDropdownBox"));
    Select select=new Select(dropDown);
    //seçili olan optionı(seçimi) alabiliriz
    select.getFirstSelectedOption();

    //biz farklı bir kategori seçimi yapmak istersek
    //3 farklı seçeneğimiz var
    //1-)SelectByVisibleText
    //seçeneğin görünen yazısını kullanarak seçim yapmamızı sağlıyor
    select.selectByVisibleText("Baby");

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {

    }
    //2-)selectByIndex
    //seçeneğin sıralamadaki konumuna göre seçim yapmamızı sağlıyor
    select.selectByIndex(5);

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {

    }
    //3-)selectByValue
    //seçeneğin value attribute kullanılarak seçim yapmamızı sağlıyor
    select.selectByValue("search-alias=tools-intl-ship");

    //dropDown içerisindeki tüm seçenekleri almak için;
    List<WebElement>allOptions=select.getOptions();
    for (WebElement e:allOptions) {
        System.out.println(e.getText());
        System.out.println("Toplam kategori sayısı :"+allOptions.size());

    //Sadece seçilen seçeneği b,ze return eder
    WebElement selectedOption=select.getFirstSelectedOption();
        System.out.println("Şu an seçili olan" + selectedOption.getText());





    }
}
}
