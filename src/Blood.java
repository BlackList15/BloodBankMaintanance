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
    private String Ddate;
    private String BBid;
    private String Edate;

    public Blood(String bGroup, String bVolume) {
        this.BGroup = bGroup;
        this.BVolume = bVolume;
    }

    public Blood(String BBid, String BGroup, String Ddate, String Edate) {
        this.BBid = BBid;
        this.BGroup = BGroup;
        this.Ddate = Ddate;
        this.Edate = Edate;
    }

    public String getEdate() {
        return Edate;
    }

    public String getBBid() {
        return BBid;
    }

    public String getbGroup() {
        return BGroup;
    }

    public String getbVolume() {
        return BVolume;
    }

    public String getDdate() {
        return Ddate;
    }
    
}
