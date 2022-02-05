
package pbo.pbo5.uas.sistem_pendataan_vaksinasi.pkg10120173.pkg10120186.pkg10120193.pkg10120194;
import java.util.*;
import java.sql.SQLException;



public class InputData {
    
    public InputData() {
        
    }
    
  
//    ======================
//    INPUT DATA ORANG
//    =====================
    
    public static void tambah_data_orang() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean tambah_lagi = true;
            while (tambah_lagi) {
                System.out.println();
                System.out.println("===========================================");
                System.out.println("            Penambahan Data Orang          ");
                System.out.println("===========================================");
                System.out.println("!INPUT NIK DENGAN SEKSAMA!");
                System.out.print("Masukkan NIK \t\t\t\t: ");
                String inputNIK = scanner.nextLine();
                System.out.print("Masukkan Nama \t\t\t\t: ");
                String inputNama = scanner.nextLine();
                System.out.print("Masukkan Alamat \t\t\t: ");
                String inputAlamat = scanner.nextLine();
                System.out.print("Masukkan Tanggal Lahir [yyyy-MM-dd]\t: ");
                String inputTgl = scanner.nextLine();
                System.out.print("Masukkan Jenis Kelamin \t\t\t: ");
                String inputJK = scanner.nextLine();
                System.out.print("Masukkan Nomer HP \t\t\t: ");
                String inputNoHp = scanner.nextLine();
                Orang orang = new Orang(inputNIK, inputNama.toLowerCase(), inputAlamat, inputTgl, inputJK, inputNoHp);
                DataBuilder.tambah_orang(orang);
                System.out.print("Tambah Data Orang Lagi? [Y/N] =  ");
                String tambah = scanner.nextLine();
                if(tambah.equalsIgnoreCase("y")) {
                    tambah_lagi = true;
                    DataBuilder.ClearConsole();
                } else {
                    tambah_lagi = false;
                    System.out.println("Tekan Enter Untuk Kembali.....");
                    System.out.println("===========================================");
                    scanner.nextLine();
                }
            }
            

            
        } catch (Exception e) {
            System.out.println("Silahkan Input Data Dengan Benar!");
            
            System.out.println("Pesan Error : " + e.toString());
        }
       
    }
    
    public static void tampil_data_orang() {
        try {
            ArrayList<Orang> data_orang = new ArrayList<>();
            data_orang = DataBuilder.tampil_data_orang();
            if (!data_orang.isEmpty()) {
                System.out.println();
                System.out.println("|=================================================================================================================|");
                System.out.println("|                                              Data Orang Vaksinasi                                               |");
                System.out.println("|=================================================================================================================|");
                System.out.println("| No |      NIK       |        Nama        |        Alamat        |   Tgl Lahir  |  Jenis Kelamin  |     No Hp    |");
                System.out.println("|====|================|====================|======================|==============|=================|==============|");
                for (int i = 0; i < data_orang.size(); i++ ) {
                    int no = i + 1;
                    Integer.toString(no);
                    System.out.print(String.format("|%-4s|", no));
                    
                    String baris = data_orang.get(i).tampil_tabel_orang();
                    System.out.println(baris);
                }
                System.out.println("|=================================================================================================================|");
                System.out.println("Tekan Enter Untuk Melanjutkan.....");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            } else {
                System.out.println("||====================================||");
                System.out.println("||                                    ||");
                System.out.println("||  Data Orang Vaksinasi Masih Kosong ||");
                System.out.println("||  Tekan Enter Untuk Melanjutkan.... ||");
                System.out.println("||                                    ||");
                System.out.println("||====================================||");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            
        } catch (SQLException e) {
            System.out.println( "Pesan Error : " + e.toString());
        }
        
    }
    
    public static void hapus_data_orang() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean hapus_lagi = true;
            String yakin;
            while(hapus_lagi) {
                tampil_data_orang();
                System.out.println("=====================================");
                System.out.println("   Hapus Data Orang Berdasarkan NIK  ");
                System.out.println("=====================================");
                System.out.print("Masukkan NIK = ");
                String nik = scanner.nextLine();
                System.out.print("Yakin Data Ini Dihapus? [Y/N] : ");
                yakin = scanner.nextLine();
                
                if (yakin.equalsIgnoreCase("y")) {
                    DataBuilder.hapus_data_orang(nik);
                    System.out.print("Hapus Data Orang Lagi? [Y/N] =  ");
                    String hapus = scanner.nextLine();
                    if (hapus.equalsIgnoreCase("y")) {
                        hapus_lagi = true;
                        DataBuilder.ClearConsole();
                    } else {
                        hapus_lagi = false;
                    }
                }    
                 else {
                    System.out.println("Tekan Enter Untuk Kembali....");
                    scanner.nextLine();
                    hapus_lagi = false;
                }
                   
            }
            
        } catch (Exception e) {
            System.out.println("Pesan Error : " + e.toString());
        }   
    }
    
    public static void edit_data_orang() {
        try {
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            boolean edit_lagi = true;
            while(edit_lagi) {
                tampil_data_orang();
                System.out.println("====================================================");
                System.out.println("            Edit Data Orang Berdasarkan NIK         ");
                System.out.println("====================================================");
                System.out.print("Masukkan NIK \t\t\t: ");
                String nik = scanner.nextLine();

                System.out.print("Masukkan Nama \t\t\t: ");
                String nama_baru = scanner.nextLine();

                System.out.print("Masukkan Alamat \t\t: ");
                String alamat_baru = scanner.nextLine();

                System.out.print("Masukkan Tgl Lahir [yyyy-MM-dd]\t: ");
                String tgl_baru = scanner.nextLine();

                System.out.print("Masukkan Jenis Kelamin \t\t: ");
                String jk_baru = scanner.nextLine();

                System.out.print("Masukkan No Hp \t\t\t: ");
                String nohp_baru = scanner.nextLine();
               
                Orang orang = new Orang(nik, nama_baru, alamat_baru, tgl_baru, jk_baru, nohp_baru);
                DataBuilder.edit_orang(nik, orang);
                System.out.print("Edit Data Orang Lagi? [Y/N] =  ");
                String edit = scanner.nextLine();
                if (edit.equalsIgnoreCase("y")) {
                    edit_lagi = true;
                    DataBuilder.ClearConsole();
                } else {
                    edit_lagi = false;
                }
            }
            
        } catch (Exception e) {
            System.out.println("Silahkan input data dengan benar");
            System.out.println("Pesan Error : " + e.toString());
        }   
    }
    
    public static void cari_nik() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean cari_lagi = true;
            while(cari_lagi) {
                System.out.println("=======================================================");
                System.out.println("             Cari Data Orang Berdasarkan NIK           ");
                System.out.println("=======================================================");
                System.out.print("Masukkan NIK = ");
                String nik = scanner.nextLine();
                System.out.println();

                ArrayList<Orang> data_orang = new ArrayList<>();
                data_orang = DataBuilder.cari_nik(nik);

                if(!data_orang.isEmpty()) {
                    System.out.println("|=================================================================================================================|");
                    System.out.println("|                                              Data Orang Vaksinasi                                               |");
                    System.out.println("|=================================================================================================================|");
                    System.out.println("| No |      NIK       |        Nama        |        Alamat        |   Tgl Lahir  |  Jenis Kelamin  |     No Hp    |");
                    System.out.println("|====|================|====================|======================|==============|=================|==============|");
                    for (int i = 0; i < data_orang.size(); i++ ) {
                        int no = i + 1;
                        Integer.toString(no);
                        System.out.print(String.format("|%-4s|", no));
                        
                        String baris = data_orang.get(i).tampil_tabel_orang();
                        System.out.println(baris);
                    }
                    System.out.println("|=================================================================================================================|");
                    System.out.println("Data Orang Yang Dicari Berhasil Ditemukan!");
                    System.out.print("Cari Data Orang Lagi? [Y/N] = ");
                } else {
                    System.out.println("Silahkan Input NIK dengan Benar!");
                    System.out.print("Cari Data Orang Lagi? [Y/N] = ");
                }
                
                    String cari = scanner.nextLine();
                    if (cari.equalsIgnoreCase("y")) {
                        cari_lagi = true;
                        DataBuilder.ClearConsole();
                    } else {
                        cari_lagi = false;
                    }
                    System.out.println();
            }
            
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.toString());
        }
        
    }
    
    public static void cari_nama() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean cari_lagi = true;
            while (cari_lagi) {
                System.out.println("=======================================================");
                System.out.println("           Cari Data Orang Berdasarkan Nama            ");
                System.out.println("=======================================================");
                System.out.print("Masukkan Nama = ");
                String nama = scanner.nextLine();
                System.out.println();

                ArrayList<Orang> data_orang = new ArrayList<>();
                data_orang = DataBuilder.cari_nama(nama);
                if(!data_orang.isEmpty()) {
                    System.out.println("|=================================================================================================================|");
                    System.out.println("|                                              Data Orang Vaksinasi                                               |");
                    System.out.println("|=================================================================================================================|");
                    System.out.println("| No |      NIK       |        Nama        |        Alamat        |   Tgl Lahir  |  Jenis Kelamin  |     No Hp    |");
                    System.out.println("|====|================|====================|======================|==============|=================|==============|");
                    for (int i = 0; i < data_orang.size(); i++ ) { 
                        int no = i + 1;
                        Integer.toString(no);
                        System.out.print(String.format("|%-4s|", no));
                        
                        String baris = data_orang.get(i).tampil_tabel_orang();
                        System.out.println(baris);
                    }
                    System.out.println("|=================================================================================================================|");
                    System.out.println("Data Orang Yang Dicari Berhasil Ditemukan!");
                    System.out.print("Cari Data Orang Lagi? [Y/N] = ");
                } else {
                    System.out.println("Silahkan Input Nama dengan Benar");
                    System.out.print("Cari Data Orang Lagi? [Y/N] = ");
                }
                
                    String cari = scanner.nextLine();
                    if (cari.equalsIgnoreCase("y")) {
                        cari_lagi = true;
                        DataBuilder.ClearConsole();
                    } else {
                        cari_lagi = false;
                    }
                    System.out.println();
            }
            
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.toString());
        }     
    }
    
//    ====================
//    INPUT DATA STATUS VAKSIN
//    ===================
    
    public static void tambah_status_vaksin() { 
        try {
           
            Scanner scanner = new Scanner(System.in);
            boolean tambah_lagi = true;
            while (tambah_lagi) {
                InputData.tampil_data_orang();
                InputData.tampil_tempat_vaksin();
                System.out.println();
                System.out.println("=================================================================");
                System.out.println("                  Penambahan Data Status Vaksin                  ");
                System.out.println("=================================================================");
                System.out.println();
                System.out.println("MASUKKAN NIK DAN KODE RS SESUAI DENGAN TABEL YANG TERTERA DIATAS!");
                System.out.print("Masukkan Kode Status \t\t\t: ");
                String kdStatus = scanner.nextLine();
                System.out.print("Masukkan Dosis \t\t\t\t: ");
                String dosis = scanner.nextLine();
                System.out.print("Masukkan Tanggal Vaksin [yyyy-MM-dd]\t: ");
                String inputTgl = scanner.nextLine();
                System.out.print("Masukkan Keterangan [sudah/belum]\t: ");
                String keterangan = scanner.nextLine();
                System.out.print("Masukkan NIK \t\t\t\t: ");
                String nik = scanner.nextLine();
                System.out.print("Masukkan Kode RS \t\t\t: ");
                String kodeRS = scanner.nextLine();
                System.out.println();
                
                StatusVaksin statusVaksin = new StatusVaksin(kdStatus, dosis, inputTgl, keterangan, nik, kodeRS);
                DataBuilder.tambah_status_vaksin(statusVaksin);
                System.out.print("Tambah Status Vaksin Lagi? [Y/N] =  ");
                String tambah = scanner.nextLine();
                if(tambah.equalsIgnoreCase("y")) {
                    tambah_lagi = true;
                    DataBuilder.ClearConsole();
                } else {
                    tambah_lagi = false;
                    System.out.println("Tekan Enter Untuk Kembali.....");
                    scanner.nextLine();
                }
            }
            
        } catch (Exception e) {
            System.out.println("Silahkan Input Data Dengan Benar!");
            System.out.println("Pesan Error : " + e.toString());
        }
    }
    
    public static void tampil_status_vaksin() {
        try {
            ArrayList<StatusVaksin> data_status = new ArrayList<>();
            data_status = DataBuilder.tampil_status_vaksin();
            if(!data_status.isEmpty()) {
                System.out.println();
                System.out.println("|=======================================================================================================|");
                System.out.println("|                                          Data Status Vaksinasi                                        |");
                System.out.println("|=======================================================================================================|");
                System.out.println("| No |   Kode Status   |     Dosis    |   Tgl Vaksin   |   Keterangan  |       NIK       |    Kode RS   |");
                System.out.println("|====|=================|==============|================|===============|=================|==============|");
                for (int i = 0; i < data_status.size(); i++ ) {
                    int no = i + 1;
                    Integer.toString(no);
                    System.out.print(String.format("|%-4s|", no));
                    
                    String baris = data_status.get(i).tampil_tabel_status();
                    System.out.println(baris);
                }
                System.out.println("|=======================================================================================================|");
                System.out.println("Tekan Enter Untuk Melanjutkan.....");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                System.out.println();
            } else {
                System.out.println("||====================================||");
                System.out.println("||                                    ||");
                System.out.println("|| Data Status Vaksinasi Masih Kosong ||");
                System.out.println("||  Tekan Enter Untuk Melanjutkan.... ||");
                System.out.println("||                                    ||");
                System.out.println("||====================================||");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }

        } catch (SQLException e) {
            System.out.println( "Pesan Error : " + e.toString());
        }
    }
    
    public static void hapus_status_vaksin() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean hapus_lagi = true;
            String yakin;
            while(hapus_lagi) {
                tampil_status_vaksin();
                System.out.println("=============================================");
                System.out.println("   Hapus Data Orang Berdasarkan Kode Status  ");
                System.out.println("=============================================");
                System.out.print("Masukkan Kode Status = ");
                String kdStatus = scanner.nextLine();
                System.out.print("Yakin Data Ini Dihapus? [Y/N] : ");
                yakin = scanner.nextLine();
                
                if (yakin.equalsIgnoreCase("y")) {
                    DataBuilder.hapus_data_status_vaksin(kdStatus);
                    System.out.print("Hapus Data Status Lagi? [Y/N] =  ");
                    String hapus = scanner.nextLine();
                    System.out.println();
                    if (hapus.equalsIgnoreCase("y")) {
                        hapus_lagi = true;
                        DataBuilder.ClearConsole();
                    } else {
                        hapus_lagi = false;
                    }
                } else {
                    System.out.println("Tekan Enter Untuk Melanjutkan.....");
                    hapus_lagi = false;
                    scanner.nextLine();
                }
                
                
                
            }
            
        } catch (Exception e) {
            System.out.println("Pesan Error : " + e.toString());
        }
    }
    
    public static void edit_status_vaksin() {
        try {
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            boolean edit_lagi = true;
            while(edit_lagi) {  
                InputData.tampil_data_orang();
                InputData.tampil_status_vaksin();
                System.out.println("=========================================================");
                System.out.println("      Edit Data Status Vaksin Berdasarkan Kode Status    ");
                System.out.println("=========================================================");
                System.out.println("Masukkan Kode Status dan NIK Sesuai dengan Tabel Di Atas!");
                System.out.print("Masukkan Kode Status \t\t\t: ");
                String kdStatus = scanner.nextLine();
                System.out.print("Masukkan Dosis \t\t\t\t: ");
                String dosis = scanner.nextLine();
                System.out.print("Masukkan Tanggal Vaksin [yyyy-MM-dd]\t: ");
                String inputTgl = scanner.nextLine();
                System.out.print("Masukkan Keterangan [sudah/belum]\t: ");
                String keterangan = scanner.nextLine();
                System.out.print("Masukkan NIK \t\t\t\t: ");
                String nik = scanner.nextLine();
                System.out.print("Masukkan Kode RS \t\t\t: ");
                String kodeRS = scanner.nextLine();
                System.out.println();

                StatusVaksin statusVaksin = new StatusVaksin(kdStatus, dosis, inputTgl, keterangan, nik, kodeRS);
                DataBuilder.edit_status_vaksin(kdStatus, statusVaksin);
                System.out.print("Edit Data Orang Lagi? [Y/N] =  ");
                String edit = scanner.nextLine();
                if (edit.equalsIgnoreCase("y")) {
                    edit_lagi = true;
                    DataBuilder.ClearConsole();
                } else {
                    edit_lagi = false;
                }
            }
            
        } catch (Exception e) {
            System.out.println("Silahkan input data dengan benar");
            System.out.println("Pesan Error : " + e.toString());
        }
    }
    
    public static void cari_status_vaksin() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean cari_lagi = true;
            while (cari_lagi) {
                System.out.println("===================================================");
                System.out.println("   Cari Data Status Vaksin Berdasarkan Keterangan  ");
                System.out.println("===================================================");
                System.out.print("Masukkan Keterangan [belum/sudah] = ");
                String keterangan = scanner.nextLine();
                System.out.println();

                ArrayList<StatusVaksin> data_status = new ArrayList<>();
                data_status = DataBuilder.cari_status(keterangan);
                if(!data_status.isEmpty()) {
                    System.out.println("|=======================================================================================================|");
                    System.out.println("|                                          Data Status Vaksinasi                                        |");
                    System.out.println("|=======================================================================================================|");
                    System.out.println("| No |   Kode Status   |     Dosis    |   Tgl Vaksin   |   Keterangan  |       NIK       |    Kode RS   |");
                    System.out.println("|====|=================|==============|================|===============|=================|==============|");
                    for (int i = 0; i < data_status.size(); i++ ) {
                        int no = i + 1;
                        Integer.toString(no);
                        System.out.print(String.format("|%-4s|", no));
                        
                        String baris = data_status.get(i).tampil_tabel_status();
                        System.out.println(baris);
                    }
                    System.out.println("|=======================================================================================================|");
                    System.out.println("Data Keterangan Yang Dicari Berhasil Ditemukan!");
                    System.out.print("Cari Data Status Lagi? [Y/N] = ");
                } else {
                    System.out.println("Silahkan Input Nama dengan Benar");
                    System.out.print("Cari Data Orang Lagi? [Y/N] = ");
                }
                
                    String cari = scanner.nextLine();
                    if (cari.equalsIgnoreCase("y")) {
                        cari_lagi = true;
                        DataBuilder.ClearConsole();
                    } else {
                        cari_lagi = false;
                    }
                    System.out.println();
            }
            
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.toString());
        }
    }
    
    
//    ====================
//    INPUT DATA STATUS VAKSIN
//    ===================
    public static void tambah_tempat_vaksin() {
         try {
            Scanner scanner = new Scanner(System.in);
            boolean tambah_lagi = true;
            while (tambah_lagi) {
                System.out.println();
                System.out.println("=====================================");
                System.out.println("   Penambahan Data Tempat Vaksin  ");
                System.out.println("=====================================");
                System.out.print("Masukkan Kode RS \t : ");
                String inputKode = scanner.nextLine();
                System.out.print("Masukkan Nama RS \t : ");
                String inputNamaRS = scanner.nextLine();
                System.out.print("Masukkan Jam Operasional : ");
                String inputJamOperasional = scanner.nextLine();
                
                TempatVaksin tempat_vaksin = new TempatVaksin(inputKode, inputNamaRS.toLowerCase(), inputJamOperasional);
                DataBuilder.tambah_tempatvaksin(tempat_vaksin);
                System.out.print("Tambah Data Tempat Vaksin Lagi? [Y/N]  ");
                String tambah = scanner.nextLine();
                if(tambah.equalsIgnoreCase("y")) {
                    tambah_lagi = true;
                    DataBuilder.ClearConsole();
                } else {
                    tambah_lagi = false;
                    System.out.println("Tekan Enter Untuk Kembali.....");
                    scanner.nextLine();
                }
            }
            

            
        } catch (Exception e) {
            System.out.println("Silahkan Input Data Dengan Benar!");
            
            System.out.println("Pesan Error : " + e.toString());
        }
    }
     
    public static void tampil_tempat_vaksin() {
        try {
            ArrayList<TempatVaksin> data_tempat = new ArrayList<>();
            data_tempat = DataBuilder.tampil_tempat_vaksin();
            if(!data_tempat.isEmpty()) {
                System.out.println();
                System.out.println("|========================================================|");
                System.out.println("|                   Data Tempat Vaksinasi                |");
                System.out.println("|========================================================|");
                System.out.println("| No |   Kode RS  |     Nama RS    |   Jam Operasional   |");
                System.out.println("|=================|================|=====================|");
                for (int i = 0; i < data_tempat.size(); i++ ) {
                    int no = i + 1;
                    Integer.toString(no);
                    System.out.print(String.format("|%-4s|", no));
                    
                    String baris = data_tempat.get(i).tampil_tabel_tempat();
                    System.out.println(baris);
                }
                System.out.println("|========================================================|");
                System.out.println("Tekan Enter Untuk Melanjutkan.....");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            } else {
                System.out.println("||====================================||");
                System.out.println("||                                    ||");
                System.out.println("|| Data Tempat Vaksinasi Masih Kosong ||");
                System.out.println("||  Tekan Enter Untuk Melanjutkan.... ||");
                System.out.println("||                                    ||");
                System.out.println("||====================================||");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            
        } catch (SQLException e) {
            System.out.println( "Pesan Error : " + e.toString());
        }
    }
    
    public static void hapus_tempat_vaksin() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean hapus_lagi = true;
            String yakin;
            while(hapus_lagi) {
                tampil_tempat_vaksin();
                System.out.println("=============================================");
                System.out.println("           Hapus Data Tempat Vaksin         ");
                System.out.println("=============================================");
                System.out.print("Masukkan Kode RS = ");
                String inputKode = scanner.nextLine();
                System.out.print("Yakin Data Ini Dihapus [Y/N] : ");
                yakin = scanner.nextLine();
                if (yakin.equalsIgnoreCase("y")) {
                    DataBuilder.hapus_tempat_vaksin(inputKode);
                    System.out.print("Hapus Data Tempat Vaksin Lagi? [Y/N] =  ");
                    String hapus = scanner.nextLine();
                    System.out.println();
                    if (hapus.equalsIgnoreCase("y")) {
                        hapus_lagi = true;
                        DataBuilder.ClearConsole();
                    } else {
                        hapus_lagi = false;
                    }
                } else {
                    System.out.println("Tekan Enter Untuk Kembali...");
                    scanner.nextLine();
                    hapus_lagi = false;
                }
                
            }
            
        } catch (Exception e) {
            System.out.println("Pesan Error : " + e.toString());
        }
    }
    
    public static void cari_tempat_vaksin() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean cari_lagi = true;
            while (cari_lagi) {
                System.out.println("===================================================");
                System.out.println("   Cari Data Tempat Vaksin Berdasarkan Kode RS  ");
                System.out.println("===================================================");
                System.out.print("Masukkan Nama RS = ");
                String namaRS = scanner.nextLine();
                System.out.println();

                ArrayList<TempatVaksin> data_tempat = new ArrayList<>();
                data_tempat = DataBuilder.cari_nama_rs(namaRS);
                if(!data_tempat.isEmpty()) {
                    System.out.println("|========================================================|");
                    System.out.println("|                  Data Tempat Vaksinasi                 |");
                    System.out.println("|========================================================|");
                    System.out.println("| No |   Kode RS  |     Nama RS    |   Jam Operasional   |");
                    System.out.println("|====|============|================|=====================|");
                    for (int i = 0; i < data_tempat.size(); i++ ) {
                        String baris = data_tempat.get(i).tampil_tabel_tempat();
                        int no = i + 1;
                        Integer.toString(no);
                        System.out.print(String.format("|%-4s|", no));
                        System.out.println(baris);
                    }
                    System.out.println("|========================================================|");
                    System.out.println("Data Tempat Vaksin Yang Dicari Berhasil Ditemukan!");
                    System.out.print("Cari Data Tempat Vaksin Lagi? [Y/N] = ");
                } else {
                    System.out.println("Silahkan Input Nama RS dengan Benar");
                    System.out.print("Cari Data Tempat Vaksin Lagi? [Y/N] = ");
                }
                
                    String cari = scanner.nextLine();
                    if (cari.equalsIgnoreCase("y")) {
                        cari_lagi = true;
                        DataBuilder.ClearConsole();
                    } else {
                        cari_lagi = false;
                    }
                    System.out.println();
            }
            
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.toString());
        }
    }
     
    public static void edit_tampat_vaksin() {
        try {
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            boolean edit_lagi = true;
            while(edit_lagi) {
                tampil_tempat_vaksin();
                System.out.println("===============================================");
                System.out.println("   Edit Data Tempat Vaksin Berdasarkan Kode RS  ");
                System.out.println("===============================================");
                System.out.print("Masukkan Kode RS \t\t: ");
                String inputKode = scanner.nextLine();
                System.out.print("Masukkan Nama RS\t\t: ");
                String inputNamaRS = scanner.nextLine();
                System.out.print("Masukkan Jam Operasional\t: ");
                String inputJampOperasional = scanner.nextLine();
                System.out.println();

                TempatVaksin Tempat_Vaksin = new TempatVaksin(inputKode, inputNamaRS, inputJampOperasional);
                DataBuilder.edit_tempat_vaksin(inputKode, Tempat_Vaksin);
                System.out.print("Edit Data Tempat Vaksin Lagi? [Y/N] =  ");
                String edit = scanner.nextLine();
                if (edit.equalsIgnoreCase("y")) {
                    edit_lagi = true;
                    DataBuilder.ClearConsole();
                } else {
                    edit_lagi = false;
                }
            }
            
        } catch (Exception e) {
            System.out.println("Silahkan input data dengan benar");
            System.out.println("Pesan Error : " + e.toString());
        }
    }
    
    public static void tampil_data_join() {
        try {
            ArrayList<JoinNikWithKodeRs> data_join = new ArrayList<>();
            data_join = DataBuilder.tampil_tabel_join();
            if (!data_join.isEmpty()) {
                System.out.println();
                System.out.println("|==========================================================================|");
                System.out.println("|                      Data Orang Yang Sudah Didata                        |");
                System.out.println("|==========================================================================|");
                System.out.println("| No |       NIK       |        Nama        |  Kode Rs   |     Nama RS     |");
                System.out.println("|====|=================|====================|============|=================|");
          
                for (int i = 0; i < data_join.size(); i++ ) {
                    String baris = data_join.get(i).tampil_tabel_join();
                    int no = i + 1;
                    Integer.toString(no);
                    System.out.print(String.format("|%-4s|", no));
                    System.out.println(baris);
                }
                System.out.println("|==========================================================================|");
                System.out.println("Tekan Enter Untuk Melanjutkan.....");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            } else {
                System.out.println("||============================================||");
                System.out.println("||                                            ||");
                System.out.println("||  Data Orang Yang Sudah Didata Masih Kosong ||");
                System.out.println("||  Tekan Enter Untuk Melanjutkan....         ||");
                System.out.println("||                                            ||");
                System.out.println("||============================================||");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                DataBuilder.ClearConsole();
            }
            
        } catch (SQLException e) {
            DataBuilder.ClearConsole();
            System.out.println( "Pesan Error : " + e.toString());
        }
    }
}
