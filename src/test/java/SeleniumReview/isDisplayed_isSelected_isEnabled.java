package SeleniumReview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
/*
isDisplayed---->bir webelement görünüyorsa TRUE, görünmüyorsa FALSE
isSelected ---->bir webelement seçili ise TRUE,değilse FALSE
isEnabled------>bir webelement aktif ise TRUE,değilse FALSE
 */

public class isDisplayed_isSelected_isEnabled {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Ignore
    @Test
    public void isDisplayed(){
        driver.get("http://the-internet.herokuapp.com//dynamic_controls");

        WebElement displayed=driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        System.out.println(displayed.isDisplayed());
    }
@Test
    public void isSelected(){
    driver.get("http://the-internet.herokuapp.com//dynamic_controls");
WebElement isSelected=driver.findElement(By.xpath("//input[@type='checkbox']"));
isSelected.click();
//Eğer bir element seçili ise TRUE değilse FALSE return eder
    System.out.println(isSelected.isSelected());

}
@Test
    public void isEnabled() throws InterruptedException {
    driver.get("http://the-internet.herokuapp.com//dynamic_controls");
    WebElement aktifmi=driver.findElement(By.xpath("//input[@type='text']"));
    System.out.println("aktif mi(is Enabled or not) :"+aktifmi.getText());

    WebElement trueaktifmi=driver.findElement(By.xpath("//*[.='Enable']"));
    trueaktifmi.click();
    /*
    Java kodları çalışırken istediğiniz satırda kodları istediğiniz kadar
    bekletebiliyorsunuz.
     */
    try {
        Thread.sleep(3000);//3 sn bekliyor
    } catch (InterruptedException e) {

    }

    boolean aktifmi2=trueaktifmi.isEnabled();
    System.out.println("aktif mi(is Enabled or not) :"+aktifmi2);
    }
}
