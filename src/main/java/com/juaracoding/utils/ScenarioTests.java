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
    T12("Menampilkan data Lembur dengan memilih tanggal start date yang tidak sesuai");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
