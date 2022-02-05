
package pbo.pbo5.uas.sistem_pendataan_vaksinasi.pkg10120173.pkg10120186.pkg10120193.pkg10120194;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataBuilder{
    static Connection conn = Koneksi.getConnection(); //hubungkan dengan database
    
    
//    =================================
//    TABEL ORANG
//    ================================
    public static void tambah_orang(Orang orang)  {
        try {
            String sql = "INSERT INTO orang(nik,nama,alamat,tgl_lahir,jenis_kelamin,no_hp) VALUES(?,?,?,?,?,?)";
            PreparedStatement pStatement = conn.prepareStatement(sql);

            String tanggal = orang.get_tgl_lahir();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date tglDate = null;
            try {
                tglDate = simpleDateFormat.parse(tanggal);
            } catch (ParseException e) {
               System.out.println("Format Tanggal Salah");
            }
            java.sql.Date tglSQL = new java.sql.Date(tglDate.getTime());

            pStatement.setString(1, orang.get_nik());
            pStatement.setString(2, orang.get_nama());
            pStatement.setString(3, orang.get_alamat());
            pStatement.setDate(4, tglSQL);
            pStatement.setString(5, orang.get_jk());
            pStatement.setString(6, orang.get_no_hp());

            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                System.out.println("Pennambahan Data Berhasil!");
            } else {
                System.out.println("Penambahan Data Gagal!");
            }
                
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.toString());
        }
        
    }
    
    public static ArrayList<Orang> tampil_data_orang() throws SQLException {
        
        String sql ="SELECT * FROM orang";
        PreparedStatement pStatement = conn.prepareStatement(sql);
        ArrayList<Orang> data_orang = new ArrayList<>();
        ResultSet rs = pStatement.executeQuery();
        while (rs.next()){
            Orang orang = new Orang();
            orang.tampilOrang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
             data_orang.add(orang);
        }
        return data_orang;
    }
    
    public static void hapus_data_orang(String nik) {
        try {
            String sql = "DELETE FROM orang WHERE nik=?";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1,nik);

            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                System.out.println("Penghapusan data berhasil!");
            } else {
                System.out.println("Penghapusan data gagal, silahkan cek NIK kembali!");
            }
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.toString());
        }
        
        
    }
    
    public static void edit_orang(String nik, Orang orang)  {
        try {
            String sql = "UPDATE orang SET nama=?, alamat=?, tgl_lahir=?, jenis_kelamin=?, no_hp=?, nik=nik where nik=?";
            PreparedStatement pStatement = conn.prepareStatement(sql);

            String tanggal = orang.get_tgl_lahir();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date tglDate = null;
             try {
                tglDate = simpleDateFormat.parse(tanggal);
            } catch (ParseException e) {
               System.out.println("Format Tanggal Salah");
            }
            java.sql.Date tglSQL = new java.sql.Date(tglDate.getTime());

            pStatement.setString(1,orang.get_nama());
            pStatement.setString(2,orang.get_alamat());
            pStatement.setDate(3,tglSQL);
            pStatement.setString(4,orang.get_jk());
            pStatement.setString(5,orang.get_no_hp());
            pStatement.setString(6,orang.get_nik());
            
            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                System.out.println("Pengeditan data berhasil!");
            } else {
                System.out.println("Pengeditan data gagal, silahkan cek NIK kembali!");
            }
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.toString());
        }
        
        
    }
    
        public static ArrayList<Orang> cari_nik (String nik) throws SQLException {            
            String sql ="SELECT * FROM orang where nik=?";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1,nik);
            ArrayList<Orang> data_orang = new ArrayList<>();
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()){
                Orang orang = new Orang();
                orang.tampilOrang((rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                data_orang.add(orang);
            }
            if (data_orang.isEmpty()){
                System.out.println("NIK yang dimasukan tidak ditemukan");
            }
            return data_orang;
        }
        
        public static ArrayList<Orang> cari_nama (String nama) throws SQLException {
            String sql ="SELECT * FROM orang where nama=?";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1,nama.toLowerCase());
            ArrayList<Orang> data_orang = new ArrayList<>();
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()){
                Orang orang = new Orang();
                orang.tampilOrang((rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                data_orang.add(orang);
            }
            if (data_orang.isEmpty()){
                System.out.println("Nama yang dimasukkan tidak ditemukan");
            }
            return data_orang;
        }
        
        
//        ==========================
//        TABEL STATUS VAKSIN
//        =========================
    public static void tambah_status_vaksin(StatusVaksin statusVaksin) {
        try {
            String sql = "INSERT INTO status_vaksin(kd_status, dosis, tgl_vaksin, keterangan, nik, kd_rs) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            
            String tanggal_vaksin = statusVaksin.get_tgl_vaksin();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date tglDate = null;
             try {
                tglDate = simpleDateFormat.parse(tanggal_vaksin);
            } catch (ParseException e) {
               System.out.println("Format Tanggal Salah");
            }
            java.sql.Date tglSQL = new java.sql.Date(tglDate.getTime());
                        
            pStatement.setString(1, statusVaksin.get_kd_status());
            pStatement.setString(2, statusVaksin.get_dosis());
            pStatement.setDate(3, tglSQL);
            pStatement.setString(4, statusVaksin.get_keterangan());
            pStatement.setString(5, statusVaksin.get_nik());
            pStatement.setString(6, statusVaksin.get_kd_rs());

            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                System.out.println("Penambahan Data Berhasil!");
            } else {
                System.out.println("Penambahan Data Gagal!");
            }
        } catch (SQLException e) {
            System.out.println("Silahkan Input NIK dan Kode RS Dengan Benar!");
            System.out.println("Pesan Error : " + e.toString());
        }
            
    }
        
    public static ArrayList<StatusVaksin> tampil_status_vaksin() throws SQLException{
        
        String sql ="SELECT * FROM status_vaksin";
        PreparedStatement pStatement = conn.prepareStatement(sql);
        ArrayList<StatusVaksin> data_status_vaksin = new ArrayList<>();
        ResultSet rs = pStatement.executeQuery();
        while (rs.next()){
            StatusVaksin status_vaksin = new StatusVaksin();
            status_vaksin.tampil_status_vaksin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            data_status_vaksin.add(status_vaksin);
        }
        return data_status_vaksin;
    }
    
    public static void hapus_data_status_vaksin(String kd_status)  {
        try {
            String sql = "DELETE FROM status_vaksin WHERE kd_status=?";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1,kd_status);

            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                System.out.println("Penghapusan Data Berhasil Dihapus!");
            } else {
                System.out.println("Kode Status Tidak Ditemukan!");
            }
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.toString());
        }
        
    }
    
    public static void edit_status_vaksin(String kd_status, StatusVaksin status_vaksin) {
        try {
            String sql = "UPDATE status_vaksin SET dosis=?, tgl_vaksin=?, keterangan=?, nik=?, kd_rs=? where kd_status=?";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1,status_vaksin.get_dosis());
            pStatement.setString(2,status_vaksin.get_tgl_vaksin());
            pStatement.setString(3,status_vaksin.get_keterangan());
            pStatement.setString(4,status_vaksin.get_nik());
            pStatement.setString(5,status_vaksin.get_kd_rs());
            pStatement.setString(6,status_vaksin.get_kd_status());

            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                System.out.println("Data Status Vaksin Berhasil Diubah!");
            } else {
                System.out.println("Kode Status Yang Dimasukkan Tidak Ditemukan!");
            }
         } catch (SQLException e) {
             System.out.println("Silahkan input data dengan benar");
             System.out.println("Pesan Error : " + e.toString());
         }
        
        
    }
    
    public static ArrayList<StatusVaksin> cari_status (String status) throws SQLException {
        String sql ="SELECT * FROM status_vaksin where keterangan=?";
        PreparedStatement pStatement = conn.prepareStatement(sql);
        pStatement.setString(1,status.toLowerCase());
        ArrayList<StatusVaksin> data_status = new ArrayList<>();
        ResultSet rs = pStatement.executeQuery();
        while (rs.next()){
            StatusVaksin status_orang = new StatusVaksin();
            status_orang.tampil_status_vaksin((rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            data_status.add(status_orang);
        }
        if (data_status.isEmpty()){
            System.out.println("Keterangan yang dimasukkan salah atau tidak ada\n");
        }
        return data_status;
    }
    
//    ===========================
//    TABEL TEMPAT VAKSIN
//    ==========================
    
    public static void tambah_tempatvaksin(TempatVaksin tempat_vaksin) {
        try {
            String sql = "INSERT INTO tempat_vaksin(kd_rs, nama_rs, jam_operasional ) VALUES(?, ?, ?)";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, tempat_vaksin.get_kd_rs());
            pStatement.setString(2, tempat_vaksin.get_nama_rs());
            pStatement.setString(3, tempat_vaksin.get_jam_operasional());

            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                System.out.println("Pennambahan Data Berhasil!");
            } else {
                System.out.println("Penambahan Data Gagal!");
            }
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.toString());
        }
        
    }
     public static ArrayList<TempatVaksin> tampil_tempat_vaksin() throws SQLException{  
        String sql ="SELECT * FROM tempat_vaksin";
        PreparedStatement pStatement = conn.prepareStatement(sql);
        ArrayList<TempatVaksin> data_tempatvaksin = new ArrayList<>();
        ResultSet rs = pStatement.executeQuery();
        while (rs.next()){
            TempatVaksin tempat_vaksin = new TempatVaksin();
            tempat_vaksin.tampil_tempat_vaksin(rs.getString(1), rs.getString(2), rs.getString(3));
             data_tempatvaksin.add(tempat_vaksin);
        }
        return data_tempatvaksin;
    }
     
    public static void hapus_tempat_vaksin(String kd_rs)  {
        try {
            String sql = "DELETE FROM tempat_vaksin WHERE kd_rs=?";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1,kd_rs);
            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                System.out.println("Penghapusan Data Berhasil!");
            } else {
                System.out.println("Kode RS Tidak Ditemukkan!");
            }
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.toString());
        }   
         
    }
      
        public static ArrayList<TempatVaksin> cari_nama_rs (String nama_rs) throws SQLException {            
            String sql ="SELECT * FROM tempat_vaksin where nama_rs=?";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1,nama_rs.toLowerCase());
            ArrayList<TempatVaksin> data_tempatvaksin = new ArrayList<>();
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()){
                TempatVaksin tempat_vaksin = new TempatVaksin();
                tempat_vaksin.tampil_tempat_vaksin((rs.getString(1)),rs.getString(2),rs.getString(3));
                data_tempatvaksin.add(tempat_vaksin);
            }
            if (data_tempatvaksin.isEmpty()){
                System.out.println("Nama RS yang dimasukkan tidak ditemukkan!\n");
            }
            return data_tempatvaksin;
        }
      
        
    public static void edit_tempat_vaksin(String kd_rs, TempatVaksin tempat_vaksin) throws SQLException {
        try {
            String sql = "UPDATE tempat_vaksin SET nama_rs=?, jam_operasional=? where kd_rs=?";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1,tempat_vaksin.get_nama_rs());
            pStatement.setString(2,tempat_vaksin.get_jam_operasional());
            pStatement.setString(3,tempat_vaksin.get_kd_rs());
            
            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                System.out.println("Data Tempat Vaksin Berhasil Diubah!");
            } else {
                System.out.println("Kode RS yang Dimasukkan Tidak Ditemukan!");
            }
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.toString());
        }
            
    }
    
    public static ArrayList<JoinNikWithKodeRs> tampil_tabel_join() throws SQLException{  
        String sql = "SELECT orang.nik, nama, tempat_vaksin.kd_rs, nama_rs FROM orang INNER JOIN status_vaksin INNER JOIN tempat_vaksin ON orang.nik = status_vaksin.nik AND tempat_vaksin.kd_rs = status_vaksin.kd_rs";
        PreparedStatement pStatement = conn.prepareStatement(sql);
        ArrayList<JoinNikWithKodeRs> data_join = new ArrayList<>();
        ResultSet rs = pStatement.executeQuery();
        while (rs.next()){
            JoinNikWithKodeRs hasil_join = new JoinNikWithKodeRs();
            hasil_join.TampilJoinNikWithKodeRs(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            data_join.add(hasil_join);
        }
        return data_join;
    }
    
    
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
      
}


