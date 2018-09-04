

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karshan
 */
public class Donor {
    private String donorId;
    private String name;
    private String email;
    private String address;
    private int contact;
    private String gender;
    private String dateOfBirth;
    private String bloodGroup;

    public Donor(String donorId, String name, String email, String address, int contact, String gender, String dateOfBirth, String bloodGroup) {
        this.donorId = donorId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
    }

    public String getDonorId() {
        return donorId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getContact() {
        return contact;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    
    
}
