
package pbo.pbo5.uas.sistem_pendataan_vaksinasi.pkg10120173.pkg10120186.pkg10120193.pkg10120194;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws SQLException{
        Connection conn = Koneksi.getConnection();
        if (conn!=null){
            DataBuilder dbbuilder = new DataBuilder(conn); //koneksi dipassing ke class DataBuilder
            selamat_datang();
            menu_utama();
         } else {
            System.out.println("DB Tidak Terkoneksi!");
         } 
    }
    
    public static void pilihanAdminUser(int pilihan) throws SQLException{
        switch (pilihan) {
            case 1: //admin
            DataBuilder.ClearConsole();
            {
            int menu_admin = menu_admin();
                switch(menu_admin) {
                    case 1:
                    {
                        // lihat data orang
                        int pilih_menu_orang = menu_data_orang();
                        switch (pilih_menu_orang) {
                            case 1:
                            {   
                                
                                //menambah data orang                                    
                                InputData.tambah_data_orang();
                                pilihanAdminUser(pilihan);   
                                break;
                            }
                            
                            case 2:
                            {
                                // menampilkan data orang
                                InputData.tampil_data_orang();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 3:
                            {
                                // menghapus data orang
                                InputData.hapus_data_orang();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 4:
                            {
                                // mengedit data orang
                                InputData.edit_data_orang();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 5:
                            {
                                // mencari data orang berdasarkan nik
                                InputData.cari_nik();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 6:
                            {
                                // mencari data orang berdasarkan nama
                                InputData.cari_nama();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 7:
                            {
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            default: 
                            {
                                System.out.println("Input Menu Dengan Benar!");
                                pilihanAdminUser(pilihan);
                                break;
                            }
                        }
                    }
                    case 2:
                    {
                        // lihat data status vaksin
                        int pilih_menu_status = menu_status_vaksin();
                        switch(pilih_menu_status) {
                            case 1:
                            {
                              // menambah data status vaksin
                                InputData.tambah_status_vaksin();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 2:
                            {
                              // menampilkan data status vaksin  
                                InputData.tampil_status_vaksin();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 3:
                            {
                              // menghapus data status vaksin
                                InputData.hapus_status_vaksin();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 4:
                            {
                              // mengedit data status vaksin
                                InputData.edit_status_vaksin();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 5:
                            {
                              // mencari data status vaksin berdasarkan keterangan
                                InputData.cari_status_vaksin();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 6:
                            {
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            default: 
                            {
                                System.out.println("Input Menu Dengan Benar!");
                                pilihanAdminUser(pilihan);
                                break;
                            }
                        }
                    }
                    case 3:
                    {
                        // lihat data tempat vaksin
                        int pilih_menu_tempat = menu_tempat_vaksin();
                        switch(pilih_menu_tempat) {
                            case 1:
                            {
                              // menambah data tempat vaksin
                                InputData.tambah_tempat_vaksin();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 2:
                            {
                              // menampilkan data tempat vaksin
                                InputData.tampil_tempat_vaksin();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 3:
                            {
                              // menghapus data tempat vaksin
                                InputData.hapus_tempat_vaksin();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 4:
                            {
                              // mengedit data tempat vaksin
                                InputData.edit_tampat_vaksin();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 5:
                            {
                              // mencari data tempat vaksin berdasarkan nama rs
                                InputData.cari_tempat_vaksin();
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            case 6:
                            {
                                pilihanAdminUser(pilihan);
                                break;
                            }
                            default: 
                            {
                                System.out.println("Input Pilihan Menu Dengan Benar!");
                                pilihanAdminUser(pilihan);
                                break;
                            }
                        }
                    }
                    case 4:
                    {
                        InputData.tampil_data_join();
                        pilihanAdminUser(pilihan);
                        break;
                    }
                    case 5:
                    {
                        menu_utama();
                        break;
                    }
                    
                    default: 
                    {
                        System.out.println("Input Pilihan Menu Dengan Benar!");
                        menu_utama();
                        break;
                    }
                }
            }
            case 2: //user
                DataBuilder.ClearConsole();
            {
               int menu_user = menu_user();
                switch(menu_user) {
                    case 1:
                    {
                      // menampilkan data orang
                        InputData.tampil_data_orang();
                        pilihanAdminUser(pilihan);
                      break;
                    }
                    case 2:
                    {
                      // menampilkan data status
                        InputData.tampil_status_vaksin();
                        pilihanAdminUser(pilihan);
                      break;
                    }
                    case 3:
                    {
                      // menampilkan data tempat
                        InputData.tampil_tempat_vaksin();
                        pilihanAdminUser(pilihan);
                      break;
                    }
                    case 4:
                    {   
                        InputData.tampil_data_join();
                        pilihanAdminUser(pilihan);
                        break;
                    }
                    case 5:
                    {
                        menu_utama();
                        break;
                    }
                    default :
                    {
                        System.out.println("Input Pilihan Menu Dengan Benar!");
                        menu_utama();
                        break;
                    }
                    
                } 
            
            }
            
            case 3: //tutup program
            {
                DataBuilder.ClearConsole();
                terimakasih();
                DataBuilder.conn.close();
                System.exit(0);
            }
            
            default :
            {
                System.out.println("Input Pilihan Menu Dengan Benar!");
                menu_utama();
                break;
            }
        }
    }
    
    
    public static void menu_utama() throws SQLException{
        System.out.println("====================================================");
        System.out.println("||  Selamat Datang di Sistem Pendataan Vaksinasi  ||");
        System.out.println("====================================================");
        System.out.println("Pilih Sebagai ");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("3. Akhiri Program");
        System.out.print("Pilihan = ");
        Scanner scanner = new Scanner(System.in);
        int pilihAdminUser = scanner.nextInt();
        pilihanAdminUser(pilihAdminUser);
       // DataBuilder.ClearConsole();
    }
    
    public static int menu_admin() {
        System.out.println("===================================================");
        System.out.println("               Selamat Datang Admin                ");
        System.out.println("===================================================");
        System.out.println("Pilihan Menu ");
        System.out.println("1. Lihat Data Orang ");
        System.out.println("2. Lihat Data Status Vaksin");
        System.out.println("3. Lihat Data Tempat Vaksin");
        System.out.println("4. Lihat Data Orang Yang Sudah Terdaftar [join tabel]");
        System.out.println("5. Kembali");
        System.out.print("Pilihan = ");
        Scanner scanner = new Scanner(System.in);
        int pilihMenuAdmin = scanner.nextInt();
        DataBuilder.ClearConsole();
        return pilihMenuAdmin;
    }
    
        public static int menu_user() {
        System.out.println("===================================================");
        System.out.println("          Selamat Datang di Aplikasi Ini           ");
        System.out.println("===================================================");
        System.out.println("Pilihan Menu ");
        System.out.println("1. Lihat Tabel Orang ");
        System.out.println("2. Lihat Tabel Status Vaksin");
        System.out.println("3. Lihat Tabel Tempat Vaksin");
        System.out.println("4. Lihat Data Orang Yang Sudah Terdaftar [join tabel]");
        System.out.println("5. Kembali");
        System.out.print("Pilihan = ");
        Scanner scanner = new Scanner(System.in);
        int pilihMenuUser = scanner.nextInt();
        DataBuilder.ClearConsole();
        return pilihMenuUser;
    }
    
    
    public static int menu_data_orang() {
        System.out.println("===================================================");
        System.out.println("               Data Orang Vaksinasi                ");
        System.out.println("===================================================");
        System.out.println("Pilihan Menu ");
        System.out.println("1. Menambah Data Orang Yang Divaksin");
        System.out.println("2. Menampilkan Data Orang Yang Divaksin");
        System.out.println("3. Menghapus Data Orang Yang Divaksin");
        System.out.println("4. Mengedit Data Orang Yang Divaksin");
        System.out.println("5. Mencari Data Orang Berdasarkan NIK");
        System.out.println("6. Mencari Data Orang Berdasarkan Nama");
        System.out.println("7. Kembali");
        System.out.print("Pilihan = ");
        Scanner scanner = new Scanner(System.in);
        int pilihMenuDataOrg = scanner.nextInt();
        DataBuilder.ClearConsole();
        return pilihMenuDataOrg;
    }
    
    public static int menu_status_vaksin() {
        System.out.println("===================================================");
        System.out.println("               Data Status Vaksinasi               ");
        System.out.println("===================================================");
        System.out.println("Pilihan Menu ");
        System.out.println("1. Menambah Data Status Vaksin");
        System.out.println("2. Menampilkan Data Status Vaksin");
        System.out.println("3. Menghapus Data Status Vaksin");
        System.out.println("4. Mengedit Data Status Vaksin");
        System.out.println("5. Mencari Data Status Vaksin Berdasarkan Keterangan");
        System.out.println("6. Kembali");
        System.out.print("Pilihan = ");
        Scanner scanner = new Scanner(System.in);
        int pilihMenuDataStatus = scanner.nextInt();
        DataBuilder.ClearConsole();
        return pilihMenuDataStatus;
    }
    
    public static int menu_tempat_vaksin() {
        System.out.println("===================================================");
        System.out.println("               Data Tempat Vaksinasi               ");
        System.out.println("===================================================");
        System.out.println("Pilihan Menu ");
        System.out.println("1. Menambah Data Tempat Vaksin");
        System.out.println("2. Menampilkan Data Tempat Vaksin");
        System.out.println("3. Menghapus Data Tempat Vaksin");
        System.out.println("4. Mengedit Data Tempat Vaksin");
        System.out.println("5. Mencari Nama Rumah Sakit");
        System.out.println("6. Kembali");
        System.out.print("Pilihan = ");
        Scanner scanner = new Scanner(System.in);
        int pilihMenuDataTempat = scanner.nextInt();
        DataBuilder.ClearConsole();
        return pilihMenuDataTempat;
    }
    
    public static void selamat_datang() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("||===================================================||");
        System.out.println("||                                                   ||");
        System.out.println("||                                                   ||");
        System.out.println("||                                                   ||");
        System.out.println("||   SELAMAT DATANG DI SISTEM PENDATAAN VAKSINASI    ||");
        System.out.println("||           Tekan Enter Untuk Melanjutkan..         ||");
        System.out.println("||                                                   ||");
        System.out.println("||                                                   ||");
        System.out.println("||                                                   ||");
        System.out.println("||===================================================||");
        scanner.nextLine();
        DataBuilder.ClearConsole();
    }
    
    public static void terimakasih() {
        System.out.println("||===================================================||");
        System.out.println("||                                                   ||");
        System.out.println("||                                                   ||");
        System.out.println("||                                                   ||");
        System.out.println("||                    TERIMAKASIH                    ||");
        System.out.println("||              Data Anda Sudah Tersimpan            ||");
        System.out.println("||                                                   ||");
        System.out.println("||                                                   ||");
        System.out.println("||                                                   ||");
        System.out.println("||===================================================||");
    }
}


