class Kisi {
    private long tcKimlikNo;
    private String ad;
    private String soyad;
    private String email;
    private long telefonNumarasi; 
    private double yillikGelir;

    public Kisi() {}

    public Kisi(long tcKimlikNo, String ad, String soyad, String email, long telefonNumarasi, double yillikGelir) {
        this.tcKimlikNo = tcKimlikNo;
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefonNumarasi = telefonNumarasi;
        this.yillikGelir = yillikGelir;
    }

    public long getTcKimlikNo() {
        return this.tcKimlikNo;
    }

    public void setTcKimlikNo(long tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    public String getAd() {
        return this.ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return this.soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefonNumarasi() {
        return this.telefonNumarasi;
    }

    public void setTelefonNumarasi(long telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    public double getYillikGelir() {
        return this.yillikGelir;
    }

    public void setYillikGelir(double yillikGelir) {
        this.yillikGelir = yillikGelir;
    }

    public String toString() {
        return "TC Kimlik No: " + this.tcKimlikNo +
               "\nAd: " + this.ad +
               "\nSoyad: " + this.soyad +
               "\nEmail: " + this.email +
               "\nTelefon Numarasi: " + this.telefonNumarasi +
               "\nYillik Gelir: " + this.yillikGelir;
    }
}//kisi