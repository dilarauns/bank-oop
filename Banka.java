import java.util.ArrayList;
import java.util.Scanner;

public class Banka {
    public static Musteri musteriBilgileriAl() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("TC Kimlik No: ");
        long tcKimlikNo = scanner.nextLong();
        scanner.nextLine();
        System.out.print("\n");

        System.out.print("Ad: ");
        String ad = scanner.nextLine();
        System.out.print("\n");

        System.out.print("Soyad: ");
        String soyad = scanner.nextLine();
        System.out.print("\n");

        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("\n");

        System.out.print("Telefon Numarasi: ");
        long telefonNumarasi = scanner.nextLong();
        System.out.print("\n");

        System.out.print("Yillik Gelir: ");
        double yillikGelir = scanner.nextDouble();
        System.out.print("\n");
        Musteri musteri = new Musteri(tcKimlikNo, ad, soyad, email, telefonNumarasi, yillikGelir);

        return musteri;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1 tane olacak
        ArrayList<BankaPersonel> personeller = new ArrayList<BankaPersonel>();
        BankaPersonel bankaPersonel = new BankaPersonel();
        BankaPersonel bankaPersonel2 = new BankaPersonel();
        BankaPersonel bankaPersonel3 = new BankaPersonel();
        personeller.add(bankaPersonel);
        personeller.add(bankaPersonel2);
        personeller.add(bankaPersonel3);

        // Hangi personelle islem yapmak istiyorsunuz
        // Ne islem yapmak istiyorsunuz
        // islemler : Musteri eklemek icin 1
        // create musteri with musteriBilgileriAl method
        // personel.musteriListesineEkle
        // hesapEkle --> vadeli, vadesiz, yatirim
        // Musteriyseniz hesaplarinizi goruntulemek icin tcnizi giriniz?
        // Hesap islemleri ekle sil
        // Ekle
        // maas, normal
        // vadeli, vadesiz, yatirim
        // eklemek istediginiz tutar
        // Hesaplari goruntule
        // .toString()



        // hatali girias icin while
        while (true) {
            System.out.print(
                    "\nPersonel1, Personel2, Personel3\nHangi personel ile islem yapilacak ise numarasini girin (1,2 veya 3):");

            int secenekler = scanner.nextInt();

            if (secenekler == 1 || secenekler == 2 || secenekler == 3) {

                System.out.println(
                        "\nBanka hesabinizdaki bilgileri goruntulemek icin 1 kredi hesabinizin bilgilerini 2'ye  Eger  musteri eklemek istiyorsaniz 3'e basin.");
                int secenek = scanner.nextInt();

                switch (secenek) {
                    case 1:
                        int flag = 0;
                        for (int i = 0; i < 3; i++) {
                            System.out.println("Hesabiniz goruntulemek icin TC kimlik numaranizi giriniz:");
                            long tc = scanner.nextLong();
                            // arrayde tc kontrolu yapip ardindan bulunan indisten kullanicinin diger
                            // bilgileri cekilecek
                            for (Musteri eleman : personeller.get(secenekler - 1).getMusteriListesi()) {
                                if (tc == eleman.getTcKimlikNo()) {
                                    flag = 1;
                                    System.out.println(eleman.toString());

                                    // musteriye hesap ekle - sil sorgusu

                                    System.out.println(
                                            "Hesap eklemek istiyorsaniz 1'i, Hesap silmek istiyorsaniz 2'ye, Hesaplari goruntulemek istiyorsaniz 3, Para bozmak istiyorsaniz 4'e bas.");
                                    int ekleSil = scanner.nextInt();

                                    if (ekleSil == 1) {

                                        System.out.println("hesap bilginizi girin(vadeli, vadesiz, yatirim)");
                                        scanner.nextLine();
                                        String hesapBilgisi = scanner.nextLine();

                                        System.out.println(
                                                "hesap turunuz maas olacaksa 1'i, normal hesap olacaksa 2'yi basin");
                                        int hesapTuru = scanner.nextInt();

                                        if (hesapBilgisi.equals("vadeli")) {

                                            // musterinin hesaba yatiracagi paranin sorgusu yapilacak
                                            // BankaHesap hesap = new BankaHesap();
                                            System.out
                                                    .println("vadeli hesaba yatirilacak para miktari ne kadar olacak:");
                                            double vadelibakiye = scanner.nextDouble();

                                            if (eleman.bakiye < vadelibakiye) {
                                                System.out.println("yetersiz bakiye");
                                            } else {
                                                eleman.hesapEkle(eleman.bakiye, hesapBilgisi, hesapTuru, vadelibakiye); // creates
                                                                                                                        // vadeli
                                                                                                                        // hesap
                                            }

                                        } // vadeli

                                        else if (hesapBilgisi.equals("vadesiz")) {

                                            // musterinin hesaba yatiracagi paranin sorgusu yapilacak

                                            System.out.println(
                                                    "vadesiz hesaba yatirilacak para miktari ne kadar olacak:");
                                            double vadesizBakiye = scanner.nextDouble();
                                            if (eleman.bakiye < vadesizBakiye) {
                                                System.out.println("yetersiz bakiye");
                                            } else {

                                                eleman.hesapEkle(eleman.bakiye, hesapBilgisi, hesapTuru, vadesizBakiye);
                                            }

                                            // kalan bakiye tutari yazdirilacak
                                        } // vadesiz

                                        else if (hesapBilgisi.equals("yatirim")) {
                                            System.out.println(
                                                    "Yatirim turunuzun ne olacaginiz yazin(altin, dolar, euro):");
                                            scanner.nextLine();
                                            String yatirimTuru = scanner.nextLine();

                                            System.out.println("kur oranini giriniz:");
                                            float kur = scanner.nextFloat();

                                            System.out.println(
                                                    "yatirim hesabina yatirilacak para miktari ne kadar olacak:");
                                            double yatirimBakiye = scanner.nextDouble();
                                            if (eleman.bakiye < yatirimBakiye) {
                                                System.out.println("yetersiz bakiye");
                                            } else {

                                                eleman.hesapEkle(eleman.bakiye, hesapBilgisi, hesapTuru, yatirimBakiye,
                                                        yatirimTuru, kur);
                                            }

                                            // kalan bakiye tutari yazdirilacak
                                           

                                        } // yatirim
                                        else {

                                        } 

                                        flag = 0;
                                    } // if eklenecek eklesil

                                    else if (ekleSil == 2) {
                                        System.out.println("Silinecek hesabin ibanini girin:");
                                        scanner.nextLine();
                                        String iban = scanner.nextLine();

                                        for (i = 0; i < eleman.getHesaplar().size(); i++) {
                                            if (eleman.getHesaplar().get(i).getIban().equals(iban)) {
                                                eleman.hesapSil(i);
                                            }
                                        }
                                    } // else silinecek
                                    else if (ekleSil == 3) {
                                        if (eleman.getHesaplar().size() == 0) {
                                            System.out.println("Hesabiniz bulunmamaktadir.");
                                        } else {
                                            for (BankaHesap hesap : eleman.getHesaplar()) {
                                                hesap.hesapGoruntuleme();
                                                System.out.println(
                                                        "---------------------------------------------------------------------------------------------------------");
                                            }
                                        }
                                    }
                                    else if (ekleSil == 4) {
                                        System.out.println("yatirim hesabinizin ibanini girinzi:");
                                        String yatirimIban = scanner.nextLine();
                                        System.out.println("cekmek istediginiz para miktarini yaziniz:");
                                        double cekilecek = scanner.nextDouble();
                                        
                                        
                                        for (BankaHesap hesap : eleman.getHesaplar()) {
                                            if (hesap instanceof YatirimHesap){
                                                double cevrilmisPara = ((YatirimHesap) hesap).paraBoz(cekilecek);
                                                eleman.bakiye += cevrilmisPara;
                                            }else{
                                                System.out.println("Girdiginiz iban yatirim hesabina ait degildir");
                                            }
                                        }
                                        // elemanin hesaplarinda gezip yatirim hesabi olani bbul
                                        // buldugun yatirim hesabi uzerinden para boz calistir.
                                    
                                    
                                    }

                                    break;

                                } else {
                                    System.out.println("Hatali TC girisi. Tekrar deneyin");
                                }
                            }
                            if (flag == 1) {
                                break;
                            }
                        }

                        break;
                    case 2:
                        System.out.println("Kredi kartinizi goruntulemek icin TC kimlik numaranizi giriniz:");
                        long tc = scanner.nextLong();
                        for (Musteri eleman : personeller.get(secenekler - 1).getMusteriListesi()) {
                            if (tc == eleman.getTcKimlikNo()) {
                                System.out.println(
                                        "Bir kredi hesabi eklemek icin 1'i, hesap silmek icin 2'ye , kredi almak icin 3'e, kredi kartlarini goruntulemek icin 4'e bas:");
                                int ekleSil = scanner.nextInt();

                                if (ekleSil == 1) {
                                    eleman.krediKartiEkle();
                                } // kredihesap ekle

                                else if (ekleSil == 2) {
                                    // silinecek indexi bul
                                    // kartSil fonksiyonunu indexle beraber cagirarak elemandan sil

                                    System.out.println("Silinecek hesabin kart numarasini girin:");
                                    // scanner.nextLine(); hata alirsa ac
                                    long kartNumarasi = scanner.nextLong();

                                    for (int i = 0; i < eleman.getKrediKartlari().size(); i++) {
                                        if (eleman.getKrediKartlari().get(i).getkartNo() == kartNumarasi) {
                                            eleman.krediKartiSil(i);
                                        } // if
                                        else {
                                            System.out.println("bu kart numarasina ait kredi hesabi bulunamadi");
                                        }
                                    } // for kredikartbul

                                } // else

                                else if (ekleSil == 3) {

                                    System.out.println("Kart numarasini girin:");
                                    // scanner.nextLine(); hata alirsa ac
                                    long kartNumarasi = scanner.nextLong();

                                    for (KrediKarti kart : eleman.getKrediKartlari()) {
                                        if (kartNumarasi == kart.getkartNo()) {
                                            Krediler kredi = new Krediler(eleman.getMusteriNo(),
                                                    eleman.getYillikGelir());
                                            kredi.kampanya(kart.kullanilabilirLimit);
                                            System.out.println(kredi.toString());
                                        }
                                    }

                                } else if (ekleSil == 4) {
                                    for (KrediKarti kart : eleman.getKrediKartlari()) {
                                        System.out.println(kart.toString());
                                    }


                                }

                            } // musteri secildi
                        }

                        break;
                        case 3:
                            bankaPersonel.musteriListesineEkle(musteriBilgileriAl());
                        break;
                }// switch secenek

            } // ifpersonel giris

            else {
                System.out.println("Hatali personel secimi yapildi. Yeniden deneyiniz");
            } // else personelgiris
        } // while personel secimi
    }// main
}// classbanka

// // 3 tane hesap turumuz var
// // vadeli -- extends BankaHesap
// // vadesiz -- extends BankaHesap
// // yatirim -- extends BankaHesap
