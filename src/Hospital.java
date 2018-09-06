/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ashik
 */
public class Hospital {
    private String hospitalId;
    private String hosName;
    private int hosContact;
    private String address;
    private float disFromHere;
    private String cheifDocName;
    private int cheifDocCon;

    public Hospital(String hospitalId, String hosName, int hosContact, String address, float disFromHere,String cheifDocName, int cheifDocCon) {
        this.hospitalId = hospitalId;
        this.hosName = hosName;
        this.hosContact = hosContact;
        this.address = address;
        this.disFromHere = disFromHere;
        this.cheifDocName = cheifDocName;
        this.cheifDocCon = cheifDocCon;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public String getHosName() {
        return hosName;
    }

    public int getHosContact() {
        return hosContact;
    }

    public String getAddress() {
        return address;
    }

    public float getDisFromHere() {
        return disFromHere;
    }

    public String getCheifDocName() {
        return cheifDocName;
    }

    public int getCheifDocCon() {
        return cheifDocCon;
    }
    
    
}
