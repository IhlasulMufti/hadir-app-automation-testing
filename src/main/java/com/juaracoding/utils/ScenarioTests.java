package com.juaracoding.utils;

public enum ScenarioTests {

    T1("Login with email and password valid"),
    T2("Menampilkan data laporan Sakit dengan memasukkan nama, departement dan tanggal yang tidak sesuai"),
    T3("Menampilkan data Sakit dengan memilih tanggal start date yang tidak sesuai"),
    T4("Menampilkan data Sakit dengan memilih tanggal end date yang tidak sesuai"),
    T5("Menampilkan data Sakit dengan filter yang sesuai dan nama yang tidak sesuai"),
    T6("Menampilkan data Sakit dengan tidak memilih filter departement"),
    T7("Menampilkan data sakit input nama lalu pilih filter dengan tidak input tanggal Start Date dan tanggal End date yang sesuai"),
    T8("Menampilkan data sakit hanya dengan input nama yang sesuai di kolom search"),
    T9("Mendownload bukti sakit"),
    T10("Menampilkan data sakit dengan input nama, input start date dan end date, piih filter yang sesuai"),
    T11("Menampilkan data laporan Lembur dengan memasukkan nama, departement dan tanggal yang tidak sesuai"),
    T12("Menampilkan data Lembur dengan memilih tanggal start date yang tidak sesuai"),
    T13("Menampilkan data Lembur dengan memilih tanggal yang tidak sesuai"),
    T14("Menampilkan data Lembur dengan nama sesuai dan memilih tanggal yang tidak sesuai"),
    T15("Menampilkan data lembur dengan filter yang sesuai dan nama yang tidak sesuai"),
    T16("Export data Lembur dengan tidak memasukkan start date dan end date"),
    T17("Menampilkan data Lembur input nama lalu pilih filter dengan tidak input tanggal Start Date dan tanggal End date yang sesuai"),
    T18("Menampilkan data Lembur hanya dengan input nama yang sesuai di kolom search"),
    T19("Menampilkan Bukti sakit pada kolom foto"),
    T20("Menampilkan data unit dengan pilih departement"),
    T21("Menampilkan data sakit dengan next page"),
    T22("Menampilkan OT ATTACHMENT pada salah satu data"),
    T23("Cancel ubah atasan user yang request pada kolom aksi di data lembur"),
    T24("Exsport Data Sakit dengan mengisi start date dan end date"),
    T25("Menampilkan data lebih banyak dengan rows per page 25"),
    T26("Menampilkan data lebih banyak dengan rows per page 10"),
    T27("Menampilkan data lebih banyak dengan rows per page 5");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
