package SeleniumReview;

public class cssSelector {
    /*
    ******WHAT İS THE DİFFERENCE BETWEEN THE CSS CELECTOR AND XPATH?
    THE MOST İMPORTANT DİFFERENCE :WE CAN NOT NAVİGATE BETWEEN
  * THE WEBELEMENT TO FİND BY USİNG İNDEX
    <input type="email" class="form-control" placeholder="Email"/>
    <data-test="email" name="session[email]" id="session_email">

     ==>Bu webelement kaç farklı şekilde bulunabilir?
     * By.id     --->Bulunabilir.. -  By.id("session_email")
     * By.name   --->Bulunabilir.. -  By.name("session[email")
     *By.className-->Bulunabilir.. -  By.className("form-control")
     * By.tagName--->Bulunabilir.. -  By.tagName("input")
     * By.linkText-->BULUNAMAZ.... -  <a tagname'i yok
     * By.partialLinkText-->BULUNAMAZ.... -  <a tagname'i yok
     * By.xpath   -->Bulunabilir...-  By.xpath("//input[@type='email']")
     * By.cssSelector->Bulunabilir...-By.cssSelector("input[type='email']")
     *                               -By.cssSelector("#session[email")
     tagname   :input
     attribute :type,class,placeholder,data_test,name,id

     tagName[attribute='value']

     ***cssSelector'u biz daha çok CLASS ve ID attributelerine göre
     arama yapmak için kullanıyoruz
     //CLASS ==>.form-control
     //ID    ==>#session_email

     <div class="merhaba selamlar"/>
     * YANLIŞ KULLANIM :By.className("merhaba selamlar")
     * DOĞRU KULLANIM  :By.cssSelector(".merhaba.selamlar")



     */
}
