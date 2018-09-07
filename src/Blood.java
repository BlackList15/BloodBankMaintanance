/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karshan
 */
public class Blood {
    private String BGroup;
    private String BVolume; 

    public Blood(String bGroup, String bVolume) {
        this.BGroup = bGroup;
        this.BVolume = bVolume;
    }

    public String getbGroup() {
        return BGroup;
    }

    public String getbVolume() {
        return BVolume;
    }
    
}
