package SeleniumReview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverKomutları {


        @Test
        public void test01() {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            //driverı tam ekran yaptık
            driver.manage().window().maximize();

            //webelementlerin yüklenmesini 10 saniye kadar bekleyebilirsin
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //herhangi bir wesayfasına gider
            driver.navigate().to("http://amazon.com");

            //bir önceki sayfaya geri döner
            driver.navigate().back();

            //ileri gider
            driver.navigate().forward();

            //sayfayı yeniler
            driver.navigate().refresh();

            //driver ı kapatmak için kullanılır(tüm sekmeleri)
            driver.quit();

            //açık olan sekmeyi kapatmak için kullanılır
            driver.close();
        }
    }




