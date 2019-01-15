package com.example.dogu.myquizapplication.Model;


public class UserModel {
    private String displayName;
    private String facultyName;

    private String email;
    private long createdAt;
    private int countHukuk=0;
    private int countEczacilik=0;
    private int countMuhendislik=0;
    private int countIktisat =0;
    private int hukukB =0;

    private int eczacilikB =0;

    private int iktitasB =0;

    public int getCountHukuk() {
        return countHukuk;
    }

    public void setCountHukuk(int countHukuk) {
        this.countHukuk = countHukuk;
    }

    public int getCountEczacilik() {
        return countEczacilik;
    }

    public void setCountEczacilik(int countEczacilik) {
        this.countEczacilik = countEczacilik;
    }

    public int getCountMuhendislik() {
        return countMuhendislik;
    }

    public void setCountMuhendislik(int countMuhendislik) {
        this.countMuhendislik = countMuhendislik;
    }

    public int getCountIktisat() {
        return countIktisat;
    }

    public void setCountIktisat(int countIktisat) {
        this.countIktisat = countIktisat;
    }

    private int muhendislikB =0;

    private String mRecipientId;

    public UserModel() {
    }

    public UserModel(String fakultyName, String displayName, String email, long createdAt, int HukukB, int EczacilikB, int IktitasB, int MuhendislikB, int countEczacilik, int countHukuk, int countIktisat, int countMuhendislik) {


        this.countEczacilik=countEczacilik;
        this.countHukuk=countHukuk;
        this.countIktisat = countIktisat;

        this.countMuhendislik=countMuhendislik;




        this.displayName = displayName;
        this.email = email;
        this.facultyName = fakultyName;
        this.createdAt = createdAt;
        this.hukukB = HukukB;

        this.eczacilikB = EczacilikB;

        this.iktitasB = IktitasB;

        this.muhendislikB = MuhendislikB;
    }

    public int getHukukB() {
        return hukukB;
    }

    public void setHukukB(int hukukB) {
        this.hukukB = hukukB;
    }





    public int getEczacilikB() {
        return eczacilikB;
    }

    public void setEczacilikB(int eczacilikB) {
        this.eczacilikB = eczacilikB;
    }



    public int getIktitasB() {
        return iktitasB;
    }

    public void setIktitasB(int iktitasB) {
        this.iktitasB = iktitasB;
    }


    public int getMuhendislikB() {
        return muhendislikB;
    }

    public void setMuhendislikB(int muhendislikB) {
        this.muhendislikB = muhendislikB;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    private String getUserEmail() {

        return email;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRecipientId() {
        return mRecipientId;
    }

    public void setRecipientId(String recipientId) {
        this.mRecipientId = recipientId;
    }
}



