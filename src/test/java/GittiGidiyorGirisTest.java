import org.junit.Test;

public class GittiGidiyorGirisTest extends BaseTestKeyword{

    String email = "test@mail.com";
    String pass = "123456";

    String ad = "Erdem";
    String soyad = "Şahin";
    String gsm = "5554443322";
    String telefon = "2161112233";
    String adresBaslik = "İst Ev";
    String sehir = "İstanbul";
    String ilce = "Tuzla";
    String mahalle = "Orta mah.";
    String adres = "adresim";
    String postaKodu = "34956";

    String search = "Bilgisayar";


    @Test
    public void girisTest(){
        girisYap(email,pass);
        urunAra(search);
    }

    @Test
    public void uyelikTest(){

        kayitOl(ad, soyad, email, pass, gsm);
        girisYap(email, pass);
        urunAra(search);
    }

    @Test
    public void adresEklemeTest(){
        girisYap(email,pass);
        adresEkleme(pass,adresBaslik,ad,soyad,sehir,ilce,mahalle,postaKodu,adres,gsm,telefon);
    }

    @Test
    public void urunAramaVeSepeteEklemeTest(){
        urunAra(search);
        RandomSepeteEkleme();
    }

}
