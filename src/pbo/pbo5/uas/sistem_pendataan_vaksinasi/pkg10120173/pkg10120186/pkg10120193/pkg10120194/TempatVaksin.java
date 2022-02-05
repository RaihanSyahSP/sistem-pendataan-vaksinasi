
package pbo.pbo5.uas.sistem_pendataan_vaksinasi.pkg10120173.pkg10120186.pkg10120193.pkg10120194;


public class TempatVaksin {
    String kd_rs, nama_rs, jam_operasional;
    
    public TempatVaksin() {
        
    }
    
    public TempatVaksin(String kd_rs, String nama_rs, String jam_operasional) {
        this.kd_rs = kd_rs;
        this.nama_rs = nama_rs;
        this.jam_operasional = jam_operasional;
    }
    
   public void tampil_tempat_vaksin(String kd_rs, String nama_rs, String jam_operasional) {
       this.kd_rs = kd_rs;
       this.nama_rs = nama_rs;
       this.jam_operasional = jam_operasional;
   }
   
   public void set_kd_rs(String kd_rs) {
       this.kd_rs = kd_rs;
   }
   
   public String get_kd_rs() {
       return kd_rs;
   }
   
   public void set_nama_rs(String nama_rs) {
       this.nama_rs = nama_rs;
   }
   
   public String get_nama_rs() {
       return nama_rs;
   }
   
   public void set_jam_operasional(String jam_operasional) {
       this.jam_operasional = jam_operasional;
   }
   
   public String get_jam_operasional() {
       return jam_operasional;
   }
   
    public String tampil_tabel_tempat() {
        return  String.format("%-12s|",kd_rs) + 
                String.format("%-16s|", nama_rs) + 
                String.format("%-21s|", jam_operasional);
    }
   
}
