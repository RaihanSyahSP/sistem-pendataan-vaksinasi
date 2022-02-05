
package pbo.pbo5.uas.sistem_pendataan_vaksinasi.pkg10120173.pkg10120186.pkg10120193.pkg10120194;

public class JoinNikWithKodeRs {
  String nik, nama, kd_rs, nama_rs; 
    
   public JoinNikWithKodeRs() {
       
   }
   
   public void TampilJoinNikWithKodeRs(String nik, String nama, String kd_rs, String nama_rs) {
       this.nik = nik;
       this.kd_rs = kd_rs;
       this.nama = nama;
       this.nama_rs = nama_rs;
   }
   
   public void set_nik (String nik) {
       this.nik = nik;
   }
   
   public String get_nik () {
       return nik;
   }
   
   public void set_nama (String nama) {
       this.nama = nama;
   }
   
   public String get_nama () {
       return nama;
   }
   
   public void set_kd_rs (String kd_rs) {
       this.kd_rs = kd_rs;
   }
   
   public String get_kd_rs () {
       return kd_rs;
   }
   
   public void set_nama_rs(String nama_rs) {
       this.nama_rs = nama_rs;
   }
   
   public String get_nama_rs() {
       return nama_rs;
   }
   
   public String tampil_tabel_join() {
       return  String.format("%-17s|",nik) + 
               String.format("%-20s|", nama) +
               String.format("%-12s|",kd_rs) + 
               String.format("%-17s|", nama_rs);
   }
   
   
}
