package com.juaracoding.utils;

public enum ScenarioTests {

    T1("Login with email and password valid"),
    T2("Menampilkan data laporan Sakit dengan memasukkan nama, departement dan tanggal yang tidak ada"),
    T3("Menampilkan data Sakit dengan memilih tanggal start date yang tidak ada"),
    T4("Menampilkan data Sakit dengan memilih tanggal end date yang tidak ada"),
    T5("Menampilkan data Sakit dengan filter yang sesuai dan nama yang tidak ada"),
    T6("Menampilkan data Sakit dengan tidak memilih filter departement"),
    T7("Menampilkan data sakit input nama lalu pilih filter dengan tidak input tanggal Start Date dan tanggal End date yang sesuai"),
    T8("Menampilkan data sakit hanya dengan input nama yang sesuai di kolom search"),
    T9("Menampilkan data sakit dengan input nama, input start date dan end date dan piih filter yang sesuai"),
    T10("Menampilkan data unit dengan pilih departement"),
    T11("Menampilkan Bukti sakit pada kolom foto"),
    T12("Mendownload bukti sakit"),
    T13("Menampilkan data sakit dengan next page");


    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
