package SeleniumReview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class xPath {
/*
xPath
örnek WebElement :<input class="deneme" id="değer" />

1...//input[@class='deneme'];
    //input[@id='deger']
    //input

2...//*[@class='deneme'] : tagName'i farketmeksizin, (attribute : class,
value : deneme olan) tüm webelemetleri bul demek

<a href="http://google.com">Google Linki</a>
3...//*[.='Google Linki']

<div>Merhaba ben webelement</div>
//*[.='Merhaba ben webelement']
//div[.='Merhaba ben webelement']

4...//*[(text()='Google Linki')]
5...//*[contains(text(),'Linki')]
    //div[contains(text(),'Linki')]
6...1-)<div class="deneme" id="değer" placeholder="merhaba" />
    2-)<div class="tabindex" id="değer" placeholder="selamlar" />
or  :ya da
and :ve

  //div[@class='deneme' or @id='deger']
 //div[@class='deneme' and @id='deger']

örnek:class="deneme" attributene sahip weblelementleri bulun?
//div[@class='deneme']-->1

örnek:id="değer" attributene sahip weblelementleri bulun?
//div[@id='değer']-->1 ve 2

 örnek:id="değer" ya da class="deneme" attributene sahip weblelementleri bulun?
//div[@id='değer' or class='deneme']-->1 ve 2

örnek:id="değer" ve class="deneme" attributene sahip weblelementleri bulun?
//div[@id='değer' and class='deneme']-->1

7...//(div[@id='değer'])[1]--->1.sıradaki webelemente götürür
    //(div[@id='değer'])[2]--->2.sıradaki webelemente götürür

 */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        //driverı kullanılabilir hake getirdik
        WebDriverManager.chromedriver().setup();
        //driver nesnesini oluşturduk
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01() throws InterruptedException {
       driver.get("http://a.testaddressbook.com/");
//<a id="sign-in" class="nav-item nav-link" data-test="sign-in" href="/sign_in">Sign in</a>
         //  WebElement sign=driver.findElement(By.xpath("//*[@id='sign-in']"));
        //   WebElement sign=driver.findElement(By.linkText("Sign in"));
             WebElement sign=driver.findElement(By.xpath("//a[@id='sign-in']"));
        sign.click();
      // ---------->findElements kullanabilirsiniz
     //  ---------->tagname'i a olan elementler linktir.
    //   ---------->bir sayfadaki tüm webelementleri bulmak istiyorsanız,
    //   ---------->findElements kullanabilirsiniz.
       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {

       }

      List<WebElement> allLink=driver.findElements(By.tagName("a"));
        Thread.sleep(2000);
        for (WebElement w:allLink) {
            System.out.println(w.getText());
        }
//<input type="email" class="form-control" placeholder="Email" data-test="email" name="session[email]" id="session_email">

            WebElement email=driver.findElement(By.cssSelector("#session_email"));
            email.sendKeys("testtechproed@gmail.com");
//<input class="form-control" placeholder="Password" data-test="password" type="password" name="session[password]" id="session_password">
        Thread.sleep(4000);
            WebElement password=driver.findElement(By.cssSelector("input[name='session[password]']"));
            password.sendKeys("Test1234!");
     // <input type="submit" name="commit" value="Sign in" class="btn btn-primary" data-test="submit" data-disable-with="Sign in">
            WebElement signin=driver.findElement(By.cssSelector("input[name='commit']"));
            signin.click();
//------------>findElements By.xpath("//*") o sayfadaki tüm web elementleri bulur

       /*     List<WebElement>allElements=driver.findElements(By.xpath("//*"));
        for (WebElement e:allElements) {
            System.out.println(e.getText());
        }

        */
        WebElement allWriting=driver.findElement(By.tagName("//body"));
        System.out.println(allWriting.getText());
    }

@AfterClass
    public static void tearDown(){
        //driver.quit();
}
}
