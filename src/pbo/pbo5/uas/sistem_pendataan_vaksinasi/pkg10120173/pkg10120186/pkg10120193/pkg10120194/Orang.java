
package pbo.pbo5.uas.sistem_pendataan_vaksinasi.pkg10120173.pkg10120186.pkg10120193.pkg10120194;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;

public class Orang {
    String nik, nama, alamat, tgl_lahir, jenis_kelamin, no_hp;
    
    public Orang() {
    }
    
    public Orang(String nik, String nama, String alamat, String tgl_lahir, String jenis_kelamin, String no_hp) {
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.tgl_lahir = tgl_lahir;
        this.jenis_kelamin = jenis_kelamin;
        this.no_hp = no_hp;
  
    }
    
    public void tampilOrang(String nik, String nama, String alamat, String tgl_lahir, String jenis_kelamin, String no_hp) {
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.tgl_lahir = tgl_lahir;
        this.jenis_kelamin = jenis_kelamin;
        this.no_hp = no_hp;
    }
    
    public String get_nik() {
        return nik;
    }
    
    public void set_nik(String nik) {
        this.nik = nik;
    } 
    
    public String get_nama() {
        return nama;
    }
    
    public void set_nama(String nama) {
        this.nama = nama;
    }
    
    public String get_alamat() {
        return alamat;
    }
    
    public void set_alamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String get_tgl_lahir() {
        return tgl_lahir;
    }
    
    public void set_tgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }
    
    public String get_jk() {
        return jenis_kelamin;
    }
    
    public void set_jk(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
    
    public String get_no_hp() {
        return no_hp;
    }
    
    public void set_no_hp(String no_hp) {
        this.no_hp = no_hp;
    }
     
    
    public String tampil_tabel_orang() {
        return  String.format("%-16s|",nik) + 
                String.format("%-20s|", nama) + 
                String.format("%-22s|",alamat) + 
                String.format("%-14s|",tgl_lahir) + 
                String.format("%-17s|", jenis_kelamin) + 
                String.format("%-14s|", no_hp);
    }
    
}
