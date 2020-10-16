package SeleniumReview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*<a href="/international-sales-offers/" class="nav-a "
tabindex="47">Today's Deals</a>
tagname   : a
attribute : href,class,tabindex
value     : /international-sales-offers/, nav-a , 47
text      : Today's Deals

locator   : konum bulucu
id,name,tagName,className,linkText,partialLinkText,xpath,cssSelector
NoSuchElementException :Aradığınız özelliklerde bir webelement
bulamadığınız zaman bu hatayı alırsınız

sendKeys()-->Bir web elemete yazı gönderebiliyoruz
getText()-->Bir web elementin içerdiği yazıyı almak için kullanılır
click()-->WebElemente tıklayabiliyoruz
submit()-->Yazılan yazıyı gönderme (bir nevi enter)görevi görür
           aramaKutusu.sendKeys("Merhabalar ");
 Keys.ENTER-->Enter butonuna tıklamak için
          aramaKutusu.sendKeys("Merhabalar"+Keys.ENTER);

 */

public class Locators {

    WebDriver driver;
@Test
   public void örnekAmazon() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.get("http://amazon.com");
    /*
    <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder=""
    class="nav-input" dir="auto" tabindex="0" aria-label="Search">
     */
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();

    WebElement textBox= driver.findElement(By.id("twotabsearchtextbox"));
  textBox.sendKeys("baby stroller");
 // <input type="submit" class="nav-input" value="Go" tabindex="0">
    driver.findElement(By.className("nav-input")).submit();
         // textBox.sendKeys("baby stroller"+ Keys.ENTER);

   // <span class="a-size-medium a-color-base a-text-normal" dir="auto">Graco Modes 3 Lite DLX Stroller, Includes Reversible Seat, Pierce</span>
    WebElement secondproduct=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
    secondproduct.click();

    //<span id="priceblock_ourprice" class="a-size-medium a-color-price priceBlockBuyingPriceString">$157.16</span>
     WebElement price=driver.findElement(By.id("priceblock_ourprice"));
    System.out.println(price.getText());

    //System.out.println("\"merhaba\"");==>Strin  içerisinde çift tırnak yazdırm

    driver.get("http://www.google.com");
WebElement googleTextBox=driver.findElement(By.name("q"));
googleTextBox.sendKeys("Finish"+Keys.ENTER);
//<div id="result-stats">Ongeveer 1.450.000.000 resultaten<nobr> (0,62 seconden)&nbsp;</nobr></div>
    System.out.println(driver.findElement(By.id("result-stats")).getText());


}



}
