public class VadeliHesap extends BankaHesap {
    private int hesapTuru;
    private double vadeliBakiye;
    private float faizOrani;

    public VadeliHesap(){}
    // vadeli bakiye kullanicidan alinacak
    //
    public VadeliHesap(double toplamBakiye, String hesapBilgisi, int hesapTuru, double vadeliBakiye) {
        super(toplamBakiye, hesapBilgisi);
        this.hesapTuru = hesapTuru;
        setFaizOrani(faizOrani);
        setVadeliBakiye(vadeliBakiye);
    }

    public int getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(int hesapTuru) {
        this.hesapTuru = hesapTuru;
    }

    public double getVadeliBakiye() {
        return vadeliBakiye;
    }

    public void setVadeliBakiye(double vadeliBakiye) { 
        //ya burda bakiyeden dustum yeni toplam bakiyeyi cunku oyle olmasi lazim 
        this.vadeliBakiye = faizOrani * vadeliBakiye + vadeliBakiye;
        
       
    }

    public float getFaizOrani() {
        return faizOrani;
    }

    public void setFaizOrani(float faizOrani) { 
        if (this.hesapTuru == 1) {
            this.faizOrani = (float) 0.2;
        } else {
            this.faizOrani = (float) 0.1;
        }
    }

    public String toString() {
        String hesapTuruStr = this.hesapTuru == 1 ? "Maas Hesabi" : "Normal Hesap";
        
        return "Toplam bakiye:"+ this.getToplamBakiye() + "\nhesapTuru: " + hesapTuruStr
        + "\nVadesiz bakiye: " + vadeliBakiye + "\n Iban: "+this.getIban();
    }
}
