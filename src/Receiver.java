/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ashik
 */
public class Receiver {
    private String patientNm;
    
    private String hospital;
    private String hosAddress;
    private String chiefDoc;
    private String blGroup;
    private String donId;
    private String donName;
    private String bgNo;
    private String trDate;

    public Receiver(String patientNm, String hospital, String hosAddress, String chiefDoc, String blGroup, String donId, String donName, String bgNo, String trDate) {
        this.patientNm = patientNm;
        this.hospital = hospital;
        this.hosAddress = hosAddress;
        this.chiefDoc = chiefDoc;
        this.blGroup = blGroup;
        this.donId = donId;
        this.donName = donName;
        this.bgNo = bgNo;
        this.trDate = trDate;
    }

    public String getPatientNm() {
        return patientNm;
    }

    public String getHospital() {
        return hospital;
    }

    public String getHosAddress() {
        return hosAddress;
    }

    public String getChiefDoc() {
        return chiefDoc;
    }

    public String getBlGroup() {
        return blGroup;
    }

    public String getDonId() {
        return donId;
    }

    public String getDonName() {
        return donName;
    }

    public String getBgNo() {
        return bgNo;
    }

    public String getTrDate() {
        return trDate;
    }

    
}
