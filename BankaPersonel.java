import java.util.ArrayList;
import java.util.Random;
class BankaPersonel extends Kisi {

    private long personelID;
    private ArrayList <Musteri> musteriListesi = new ArrayList<Musteri>();

    public BankaPersonel() {}

    public BankaPersonel(long tcKimlikNo, String ad, String soyad, String email, long telefonNumarasi, double yillikGelir) {
        super(tcKimlikNo, ad, soyad, email, telefonNumarasi, yillikGelir);
        setPersonelID();
    }

    // Getter
    public long getPersonelID() {
        return personelID;
    }

    // Setter
    public void setPersonelID() {
        Random random = new Random();
        int numDigits = 8; 
        long lowerBound = (long)Math.pow(10, numDigits - 1); 
        long upperBound = (long)Math.pow(10, numDigits) - 1; 
        
        this.personelID = lowerBound + (long)(random.nextDouble() * (upperBound - lowerBound)); 
    }
 
    public String toString() {
        return super.toString() +
            "\nPersonel ID: " + this.personelID;
    }

    public void musteriListesineEkle(Musteri musteri) {
        musteriListesi.add(musteri);
        System.out.println("Musteri Eklendi...");
        musteri.printMusteriInfo();

    }
    
    public ArrayList<Musteri> getMusteriListesi() {
        return this.musteriListesi;
    }

}//bankapersonel