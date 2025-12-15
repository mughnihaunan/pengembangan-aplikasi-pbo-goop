package com.goop.models;

/**
 * Class Guru - Merepresentasikan guru/pengajar dalam sistem GOOP
 * 
 * Konsep OOP yang digunakan:
 * - INHERITANCE: Guru extends (mewarisi) dari class User
 * - ENCAPSULATION: Semua fields private dengan getter/setter
 * - POLYMORPHISM: Override method toString()
 * 
 * Perbedaan Siswa vs Guru:
 * - Siswa: memiliki NIM, kelas, skorKognitif, proyekIds
 * - Guru: memiliki NIP, mengajar mata pelajaran
 * 
 * Keduanya adalah subclass dari User tapi memiliki attributes berbeda
 * Ini menunjukkan flexibility dari INHERITANCE
 * 
 * @author GOOP Development Team
 * @version 1.0
 */
public class Guru extends User {

    // ==================== ATTRIBUTES TAMBAHAN ====================
    // No additional attributes - Guru differentiated by role and behavior

    // ==================== CONSTRUCTORS ====================

    /**
     * Constructor default
     */
    public Guru() {
        super();
    }

    /**
     * Constructor dengan parameters
     * 
     * @param id          ID user
     * @param username    Username
     * @param password    Password
     * @param email       Email
     * @param namaLengkap Nama lengkap
     */
    public Guru(int id, String username, String password, String email, String namaLengkap) {
        // Memanggil constructor parent class
        // Role di-set "GURU" secara otomatis
        super(id, username, password, email, namaLengkap, "GURU");
    }

    // ==================== GETTERS & SETTERS ====================
    // Guru uses inherited getters/setters from User class

    // ==================== BUSINESS METHODS ====================

    /**
     * Method untuk validasi proyek siswa
     * Guru dapat memberikan skor untuk proyek yang di-submit siswa
     * 
     * @param proyekId ID proyek yang akan divalidasi
     * @param skor     Skor yang diberikan (0-100)
     * @return true jika validasi berhasil
     */
    public boolean validasiProyek(int proyekId, double skor) {
        // TODO: Implement setelah integrasi dengan DataStore
        // Logika:
        // 1. Cek apakah proyek dengan ID tersebut ada
        // 2. Update skor proyek
        // 3. Update status proyek menjadi "TERVALIDASI"

        System.out
                .println("Guru " + getNamaLengkap() + " memvalidasi proyek ID: " + proyekId + " dengan skor: " + skor);
        return true;
    }

    /**
     * Method untuk membuat soal tes kognitif baru
     * 
     * @param judulTes    Judul tes
     * @param durasiMenit Durasi pengerjaan tes dalam menit
     * @return ID tes yang dibuat
     */
    public int buatTesBaru(String judulTes, int durasiMenit) {
        // TODO: Implement setelah integrasi dengan DataStore
        System.out.println("Guru " + getNamaLengkap() + " membuat tes baru: " + judulTes);
        return 0;
    }

    /**
     * Method untuk membuat materi pembelajaran baru
     * 
     * @param judul  Judul materi
     * @param konten Konten materi
     * @param topik  Topik materi (Class, Object, Inheritance, dll)
     * @return ID materi yang dibuat
     */
    public int buatMateriBaru(String judul, String konten, String topik) {
        // TODO: Implement setelah integrasi dengan DataStore
        System.out.println("Guru " + getNamaLengkap() + " membuat materi: " + judul);
        return 0;
    }

    /**
     * Override toString() untuk debugging
     * Contoh POLYMORPHISM - method overriding
     * 
     * @return String representation dari Guru object
     */
    @Override
    public String toString() {
        return "Guru{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", namaLengkap='" + getNamaLengkap() + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }
}
