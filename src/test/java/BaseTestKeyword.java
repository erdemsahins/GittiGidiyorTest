import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class BaseTestKeyword extends BaseTestAssert{

    String AlertTextXpath = "//*[@class='gg-icon gg-icon-close icon-close btn-alert-close']";


    public void girisYap(String kullaniciAdi, String sifre){
        String LoginBtnXpath = "//*[@data-cy='header-login-button']";

        callHomePage();
        checkTitle("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");
        HoldByText("Giriş Yap");
        checkXpath(LoginBtnXpath);
        clickByXpath(LoginBtnXpath);
        sendById("L-UserNameField", kullaniciAdi);
        sendById("L-PasswordField", sifre);
        clickById("gg-login-enter");
        checkLogin();
    }

    //@Step("Sisteme kayit ol ad: <ad> soyad: <soyad>")
    public void kayitOl(String ad, String soyad, String email, String sifre, String telefon){
        String RegisterBtnXpath = "//*[@data-cy='header-register-button']";
        String CheckBoxBtn = "//*[@for='informed-email']";

        callHomePage();
        checkTitle("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");

        HoldByText("Giriş Yap");

        checkXpath(RegisterBtnXpath);
        clickByXpath(RegisterBtnXpath);

        sendByName("name",ad);
        sendByName("surname",soyad);
        sendById("suggestion_email_input_verifier", email);
        sendById("pwdField", sifre);
        sendById("gsmData", telefon);

        checkXpath(CheckBoxBtn);
        clickByXpath(CheckBoxBtn);
        //clickById("SubmitForm");
    }

    //@Step("<keyword> ürününü ara")
    // "Samsung" ürününü ara
    public void urunAra(String keyword){
        String SearchInputXpath = "//*[@data-cy='header-search-input']";
        String SearchBtnXpath = "//*[@data-cy='search-find-button']";

        callHomePage();
        checkTitle("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");

        checkXpath(SearchInputXpath);
        sendByXpath(SearchInputXpath,keyword);

        checkXpath(SearchBtnXpath);
        clickByXpath(SearchBtnXpath);

    }

    public void adresEkleme(String password, String title, String ad, String soyad,
                            String sehir, String ilce, String mahalle, String postaKodu,
                            String adres, String gsm, String telefon)
    {
        String BilgilerimBtnXpath = "//*[@title='Bilgilerim / Ayarlarım']";
        String PassTextId = "L-PasswordField";
        String LoginBtnId ="gg-login-enter";
        String AddAdressBtnId = "AddAddress";
        String AdressSaveBtnId = "AddressSave";

        callHomePage();
        checkTitle("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");

        HoldByText("Hesabım");

        checkXpath(BilgilerimBtnXpath);
        clickByXpath(BilgilerimBtnXpath);

        clickByLintext("Adres Bilgilerim");

        checkId(PassTextId);
        sendById(PassTextId,password);

        checkId(LoginBtnId);
        clickById(LoginBtnId);

        checkId(AddAdressBtnId);
        clickById(AddAdressBtnId);

        sendByName("title",title);
        sendByName("name",ad);
        sendByName("surname",soyad);
        new Select(driver.findElement(By.id("cities"))).selectByVisibleText(sehir);
        new Select(driver.findElement(By.id("counties"))).selectByVisibleText(ilce);
        new Select(driver.findElement(By.id("neighborhoods"))).selectByVisibleText(mahalle);
        sendByName("zipCode",postaKodu);
        sendByName("address",adres);
        sendByName("phone",gsm);
        sendByName("gsm",telefon);

        checkId(AdressSaveBtnId);
        clickById(AdressSaveBtnId);

        checkText("Tebrikler. Adres ekleme işleminiz başarıyla tamamlandı.");

    }

    public void RandomSepeteEkleme(){
        String AlertTextXpath = "//*[@class='gg-icon gg-icon-close icon-close btn-alert-close']";
        String AddBasketId = "add-to-basket";

        randomSelect("//*[@class='catalog-view clearfix products-container']/li");

        checkXpath(AlertTextXpath);
        clickByXpath(AlertTextXpath);

        checkId(AddBasketId);
        clickById(AddBasketId);
    }


}
