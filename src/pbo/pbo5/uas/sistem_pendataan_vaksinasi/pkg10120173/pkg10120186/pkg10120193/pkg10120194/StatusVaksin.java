/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.pbo5.uas.sistem_pendataan_vaksinasi.pkg10120173.pkg10120186.pkg10120193.pkg10120194;


public class StatusVaksin {
    String kd_status, dosis, tgl_vaksin, keterangan, nik, kd_rs;
    
    public StatusVaksin() {
    }
    
    public StatusVaksin(String kd_status, String dosis, String tgl_vaksin, String keterangan, String nik,String kd_rs) {
        this.kd_status = kd_status;
        this.dosis = dosis;
        this.tgl_vaksin = tgl_vaksin;
        this.keterangan = keterangan;
        this.nik = nik;
        this.kd_rs = kd_rs;
    }
    
    public void tampil_status_vaksin(String kd_status, String dosis, String tgl_vaksin, String keterangan, String nik, String kd_rs) {
        this.kd_status = kd_status;
        this.dosis = dosis;
        this.tgl_vaksin = tgl_vaksin;
        this.keterangan = keterangan;
        this.nik = nik;
        this.kd_rs = kd_rs;
    }
    
    public String get_kd_status() {
        return kd_status;
    }
    
    public void set_kd_status(String kd_status) {
        this.kd_status = kd_status;
    }
    
    public String get_dosis(){
        return dosis;
    }
    
    public void set_dosis(String dosis){
        this.dosis=dosis;
    }
    
    public String get_tgl_vaksin(){
        return tgl_vaksin;
    }
    
    public void set_tgl_vaksin(String tgl_vaksin){
        this.tgl_vaksin=tgl_vaksin;
    }
    public String get_keterangan(){
        return keterangan;
    }
    
    public void set_keterangan(String keterangan){
        this.keterangan=keterangan;
    }
    public String get_nik() {
        return nik;
    }
    public void set_nik() {
        this.nik = nik;
    }
    public String get_kd_rs(){
        return kd_rs;
    }
    public void set_kd_rs(String kd_rs){
        this.kd_rs=kd_rs;
    }
    
     public String tampil_tabel_status() {
        return  String.format("%-17s|",kd_status) + 
                String.format("%-14s|", dosis) + 
                String.format("%-16s|",tgl_vaksin) + 
                String.format("%-15s|",keterangan) +
                String.format("%-17s|", nik) +
                String.format("%-14s|", kd_rs );
    }
    
}
