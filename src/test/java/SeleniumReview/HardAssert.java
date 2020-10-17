package SeleniumReview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HardAssert {
    /* Maven ile test yaptığınız projelerde,if else ile doğrulama yaparak sadece
    kendinizi ve o projeyi izleyenleri bilgilendirirsiniz.
    Fakat test çalıştırma ortaminiza (mesela intellij) JUnit,TestNg,
    Cucumber gibi kütüphanelerden gelen Assert işlemini uygulamanız
    gerekir.Aksi durumda Assert işlemi yapmazsak tüm testleriniz başarılı
    görünür.
    HARD ASSERT                    SOFT ASSERT
    Assert.assertTrue              SoftAssert nesnesi oluşturuulr.
    Assert.assertFalse
    Assert.assertEquals
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void hardAssert01() {
        driver.get("http://amazon.com");
        String title = driver.getTitle();
        System.out.println(title);

    /*contains-->bir string ifadesinin içerisinde diğer bir
    string ifadenin geçip geçmediğini kontrol ediyor
    ÖRNEK : "Merhaba Dünya"-->contains("Dünya") TRUE FALSE
     */
        if (title.contains("Car")) {//TRUE ya da FALSE
            System.out.println("Geçiyor => " + title);
        } else {
            System.out.println("Geçmiyor => " + title);
        }
        Assert.assertTrue(title.contains("Car"));//TRUE olduğunu doğrula
        //Eğer TRUE ise Testiniz başarılıdır
        //Eğer FALSE ise testiniz başarısızdır
    }

    @Test
    public void hardAssert02() {
        driver.get("http://amazon.com");
        String title = driver.getTitle();
        System.out.println(title);
//Sayfanın başlığında Google kelimesinin geçmesi durumunu
        //kontrol ediyor
        //Eğer Google kelimesi yoksa TEST BAŞARILI.
        //Eğer Google kelimesi varsa TEST BAŞARISIZ.

        boolean falseMu = title.contains("Google");
        Assert.assertFalse(falseMu);//False

        //iki farklı değeri karşılaştırıyoruz
        //Bu iki farklı değer String,boolean,int,long,float olabilir

    }

    @Test
    public void hardAssert03() {
        driver.get("http://amazon.com");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Amazon.com",title);
//Bizim Beklentimiz : Amazon.com
//Gerçek durum : Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more
        System.out.println("Eğer testiniz BAŞARISIZSA Assert işleminden sonra testinizin kalan kısmı çalışmaz");
    }
}