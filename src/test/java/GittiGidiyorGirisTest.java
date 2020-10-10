import org.junit.Test;

public class GittiGidiyorGirisTest extends BaseTestKeyword{


    @Test
    public void girisTest(){
        girisYap("erdemsahins@hotmail.com", "erdem1998");
        urunAra("Samsung");

    }

    @Test
    public void uyelikTest(){

        kayitOl("Melih", "Sakarya", "melihasd@gmail.com", "123456", "5334444444");
        girisYap("erdemsahins@hotmail.com", "erdem1998");
        urunAra("Samsung");
    }

    @Test
    public void adresEklemeTest(){
        girisYap("erdemsahins@hotmail.com", "erdem1998");
        adresEkleme("erdem1998","İstanbul Ev","Erdem","Şahin",
                "İstanbul","Tuzla","Orta mah.", "34957",
                "Ortam mah. Demokrasi Cad. No:142 Daire:6","5395926468","2163040004");
    }

    @Test
    public void urunAramaVeSepeteEklemeTest(){
        urunAra("Bilgisayar");
        RandomSepeteEkleme();
    }

}
