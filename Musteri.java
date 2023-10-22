import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Musteri extends Kisi {
    private long musteriNo;

    private ArrayList<BankaHesap> hesaplar = new ArrayList<BankaHesap>();
    private ArrayList<KrediKarti> krediKartlari = new ArrayList<KrediKarti>();
    public double bakiye = 10000;
    /*
     * musteriListesi --> musterri1, musteri2, musteri3
     * input tc == musteri.tc
     * get musteri
     * 
     * hesaplar --> hesap1, hesap2, hesap3
     * musteri[i].hesaplar[2]
     * 
     * hesaplar[2].hesapGoruntuleme(musteri., q, iban)
     */

    Musteri() {
    }

    Musteri(long tcKimlikNo, String ad, String soyad, String email, long telefonNumarasi, double yillikGelir) {
        super(tcKimlikNo, ad, soyad, email, telefonNumarasi, yillikGelir);
        setMusteriNo();
    }

    public long getMusteriNo() {
        return musteriNo;
    }

    public void setMusteriNo() {
        //random musteri no atamasi
        int numDigits = 11;
        long lowerBound = (long) Math.pow(10, numDigits - 1);
        long upperBound = (long) Math.pow(10, numDigits) - 1;
        Random random = new Random();
        this.musteriNo = lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound));
    }

    public void hesapEkle(double toplamBakiye, String hesapBilgisi, int hesapTuru, double eklenecekBakiye){
        System.out.println(hesapBilgisi);
        if (hesapBilgisi.equals("vadeli"))
        { 
            this.setToplamBakiye(this.bakiye - eklenecekBakiye); 
            VadeliHesap vadeli = new VadeliHesap(this.bakiye, hesapBilgisi, hesapTuru, eklenecekBakiye);
            this.hesaplar.add( vadeli ); 
        }
        else if (hesapBilgisi.equals("vadesiz"))
        {
            this.setToplamBakiye(this.bakiye - eklenecekBakiye); 
            VadesizHesap vadesiz = new VadesizHesap(this.bakiye, hesapBilgisi, hesapTuru, eklenecekBakiye);
            this.hesaplar.add( vadesiz );
        }
        // simdi burada yatirimturu ve kur bilgisini almam lazim ama 
    }
    
    public void hesapEkle(double toplamBakiye, String hesapBilgisi, int hesapTuru, double eklenecekBakiye, String yatirimTuru, float kur)
    {
        this.setToplamBakiye(this.bakiye - eklenecekBakiye); 
        YatirimHesap yatirim = new YatirimHesap(this.bakiye, hesapBilgisi, hesapTuru, eklenecekBakiye, yatirimTuru, kur);
        this.hesaplar.add( yatirim );
    }

    public void hesapSil(int i) {
        hesaplar.remove(i);
    }

    public void krediKartiEkle(){
        //aylik geliri kadar kart limitimiz olacak 
        int totalBorc = 0;
        double limit = this.getYillikGelir() / 12.0;
        // kredi karti foru yazilacak
        KrediKarti newKrediKarti;
        if (krediKartlari.size() == 0){
            System.out.println("Hic kart bulunamadi ilk defa kart ekleniyor.");
            newKrediKarti = new KrediKarti(limit, 0, limit);
            System.out.println(newKrediKarti.toString());
        }
        else {
            for (KrediKarti krediKarti : this.krediKartlari){
                totalBorc += krediKarti.guncelBorc;
            }
            newKrediKarti = new KrediKarti(limit, 0, limit - totalBorc);
        }
        this.krediKartlari.add(newKrediKarti);
        
    }
    

    public void  krediKartiSil(int i ){
        this.krediKartlari.remove(i);
    } 

    public ArrayList<BankaHesap> getHesaplar() {
        return this.hesaplar;
    }

    public void setToplamBakiye(double bakiye) {
        this.bakiye = bakiye;
        for(BankaHesap hesap : this.hesaplar){
            hesap.setToplamBakiye(this.bakiye);
        }
    }

    public ArrayList<KrediKarti> getKrediKartlari(){
        return this.krediKartlari;
    } 

    public void printMusteriInfo() {
        System.out.println("TC:" + this.getTcKimlikNo());
        System.out.println("Ad:" + this.getAd());
        System.out.println("Soyad:" + this.getSoyad());
        System.out.println("Email:" + this.getEmail());
        System.out.println("Telefon Numarasi:" + this.getTelefonNumarasi());
        System.out.println("Yillik gelir:" + this.getYillikGelir());
        System.out.println("Musteri No:" + this.getMusteriNo());
    }

    public String toString() {
        return super.toString() + "\nMusteri Numarasi: " + musteriNo;
    }
}