public class YatirimHesap extends BankaHesap{
private int hesapTuru;
private double yatirimBakiye;
private String yatirimTuru;
float kur;

YatirimHesap(){}

YatirimHesap(double toplamBakiye, String hesapBilgisi, int hesapTuru, double yatirimBakiye, String yatirimTuru, float kur){
    super(toplamBakiye, hesapBilgisi);
    this.hesapTuru = hesapTuru;
    this.yatirimTuru=yatirimTuru;
    this.kur = kur;
   
    setYatirimBakiye(yatirimBakiye);
}
    
    public int getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(int hesapTuru) {
        this.hesapTuru = hesapTuru;
    }

    public double getYatirimBakiye() {
        return yatirimBakiye;
    }

    public void setYatirimBakiye(double yatirimBakiye) {
        this.yatirimBakiye = yatirimBakiye/kur;
        
    }

    public double  paraBoz(double cevirilecekMiktar){
        if ( cevirilecekMiktar>this.yatirimBakiye ){
            System.out.println("Bu kadar para bozamazsiniz.");
            return -1;
        }
        else {
            this.yatirimBakiye = yatirimBakiye - cevirilecekMiktar;
            return kur*cevirilecekMiktar ;
        }
    }
    
    public String getYatirimTuru() {
        return yatirimTuru;
    }

    public void setYatirimTuru(String yatirimTuru) {
        this.yatirimTuru = yatirimTuru;
    }

    public float getKur() {
        return kur;
    }

    public void setKur(float kur) {
        this.kur = kur;
    }



    public String toString() {
        String hesapTuruStr = this.hesapTuru == 1 ? "Maas Hesabi" : "Normal Hesap";
        
        return super.toString()+ "\nhesapTuru: " + hesapTuru
        + "\nYatirim bakiye: " + yatirimBakiye
        + "\nYatirim Turu: " + yatirimTuru
        + "\nkur: " + kur  + "\n Iban: "+this.getIban(); }


}



