package SeleniumReview;

public class JUnitAnnotations {

    /*
    @Test----------->Test methodu olduğunu belirtmek için
    @BeforeClass---->SADECE 1 KERE
                     Her class'tan önce sadece 1 kere
                     Test işlemine başlamadan önce yapmak istediklerimizi
                     bu methodun içerisinde yapabiliriz
                     ÖRNEK : driver nesnesini oluşturabiliriz
    @AfterClass----->Sadece 1 Kere
                     Her class tan sonra sadece 1 kere
                     Test işlemi bittikten sonra yapmak istediklerimizi
                     bu methodun içerisinde yapabiliriz
                     ÖRNEK : driver.quit(), rapor alma
     @Before-------->Test sayısınca çalışır.
                     Her testten önce çalışılır.
                     ÖRNEK : 10 tane tesitiniz varsa,bu methotta 10 kere çalışır.
    @After---------->Test sayısınca çalışır.
                     Her testten sonra çalışılır.
                     ÖRNEK : 10 tane tesitiniz varsa,bu methotta 10 kere çalışır.
    @Ignore--------->Kullanıldışı testin görnmezden gelinmesini ister.
                     Testi atlamak için kullanılır

   JUnit 4.13 ile birlikte BeforeClass ve AfterClass methodları STATIC olmak zorunda
     */

}
