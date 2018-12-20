package com.example.dogu.myquizapplication.Model;


public class UserModel {
    private String displayName;
    private String email;
    private long createdAt;
    public int compMarksB=0;

    public int hardwareMarksB=0;

    public int osMarksB=0;

    public int finalMarks=0;

    private String mRecipientId;

    public UserModel() {
    }

    public UserModel(String displayName, String email,long createdAt,int compMarksB,int hardwareMarksB,int osMarksB,int finalMarks) {
        this.displayName = displayName;
        this.email = email;
        this.createdAt = createdAt;
        this.compMarksB=compMarksB;

        this.hardwareMarksB=hardwareMarksB;

        this.osMarksB=osMarksB;

        this.finalMarks=finalMarks;
    }

    public int getCompMarksB() {
        return compMarksB;
    }

    public void setCompMarksB(int compMarksB) {
        this.compMarksB = compMarksB;
    }





    public int getHardwareMarksB() {
        return hardwareMarksB;
    }

    public void setHardwareMarksB(int hardwareMarksB) {
        this.hardwareMarksB = hardwareMarksB;
    }



    public int getOsMarksB() {
        return osMarksB;
    }

    public void setOsMarksB(int osMarksB) {
        this.osMarksB = osMarksB;
    }


    public int getFinalMarks() {
        return finalMarks;
    }

    public void setFinalMarks(int finalMarks) {
        this.finalMarks = finalMarks;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    private String getUserEmail() {
        //Log.e("user email  ", userEmail);
        return email;
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



