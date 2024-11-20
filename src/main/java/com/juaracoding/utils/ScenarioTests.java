package com.juaracoding.utils;

public enum ScenarioTests {

    // Koreksi Feature
    T1("Verifikasi data koreksi dengan input tanggal yang sesuai"),
    T2("Verifikasi data koreksi dengan input nama dan input tanggal yang sesuai"),
    T3("Menampilkan data koreksi dengan tidak mengisi tanggal yang sesuai"),
    T4("Menampilkan data koreksi dengan input nama yang tidak sesuai, tetapi tanggal valid"),
    T5("Menampilkan data koreksi dengan input nama yang sesuai, tetapi tanggal tidak valid"),
    T6("Menampilkan data koreksi dengan input nama departemen menggunakan filter By Unit"),
    T7("Menampilkan data koreksi dengan tidak memilih departemen menggunakan filter By Unit"),
    T8("Approval koreksi absen yang diajukan"),
    T9("Reject koreksi absen yang diajukan"),
    T10("Ubah tampilkan row per page menjadi 5"),
    T11("Ubah tampilkan row per page menjadi 25"),
    T12("Reject koreksi absen yang diajukan tanpa mengisi alasan"),

    // Izin Off Feature
    T13("Verifikasi data izin off dengan input tanggal yang sesuai"),
    T14("Verifikasi data izin off dengan input nama dan input tanggal yang sesuai"),
    T15("Menampilkan data izin off dengan tidak mengisi tanggal yang sesuai"),
    T16("Menampilkan data izin off dengan input nama yang tidak sesuai, tetapi tanggal valid"),
    T17("Menampilkan data izin off dengan input nama yang sesuai, tetapi tanggal tidak valid"),
    T18("Menampilkan data izin off dengan input nama departemen menggunakan filter By Unit"),
    T19("Menampilkan data izin off dengan tidak memilih departemen menggunakan filter By Unit"),
    T20("Approval izin off yang diajukan dengan atasan berbeda"),
    T21("Reject izin off yang diajukan dengan atasan berbeda"),
    T22("Ubah tampilkan row per page menjadi 5"),
    T23("Ubah tampilkan row per page menjadi 25"),
    T24("Reject izin off yang diajukan tanpa mengisi alasan");


    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
