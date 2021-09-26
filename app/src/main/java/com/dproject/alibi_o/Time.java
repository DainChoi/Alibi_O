package com.dproject.alibi_o;

public class Time {

    private String sun_in;
    private String mon_in;
    private String tue_in;
    private String wed_in;
    private String thu_in;
    private String fri_in;
    private String sat_in;

    private String sun_out;
    private String mon_out;
    private String tue_out;
    private String wed_out;
    private String thu_out;
    private String fri_out;
    private String sat_out;


    public Time(String sun_in, String mon_in, String tue_in,
                String wed_in, String thu_in, String fri_in, String sat_in,
                String sun_out, String mon_out, String tue_out,
                String wed_out, String thu_out, String fri_out, String sat_out) {


        this.sun_in = sun_in;
        this.mon_in = mon_in;
        this.tue_in = tue_in;
        this.wed_in = wed_in;
        this.thu_in = thu_in;
        this.fri_in = fri_in;
        this.sat_in = sat_in;

        this.sun_out = sun_out;
        this.mon_out = mon_out;
        this.tue_out = tue_out;
        this.wed_out = wed_out;
        this.thu_out = thu_out;
        this.fri_out = fri_out;
        this.sat_out = sat_out;


    }

    public Time(){}

    public String getSun_in() {
        return sun_in;
    }
    public void setSun_in(String sun_in) {
        this.sun_in = sun_in;
    }

    public String getMon_in() {
        return mon_in;
    }
    public void setMon_in(String mon_in) {
        this.mon_in = mon_in;
    }

    public String getTue_in() {
        return tue_in;
    }
    public void setTue_in(String tue_in) {
        this.tue_in = tue_in;
    }

    public String getWed_in() {
        return wed_in;
    }
    public void setWed_in(String wed_in) {
        this.wed_in = wed_in;
    }

    public String getThu_in() {
        return thu_in;
    }
    public void setThu_in(String thu_in) {
        this.thu_in = thu_in;
    }

    public String getFri_in() {
        return fri_in;
    }
    public void setFri_in(String fri_in) {
        this.fri_in = fri_in;
    }

    public String getSat_in() {
        return sat_in;
    }
    public void setSat_in(String sat_in) {
        this.sat_in = sat_in;
    }

    public String getSun_out() {
        return sun_out;
    }
    public void setSun_out(String sun_out) {
        this.sun_out = sun_out;
    }

    public String getMon_out() {
        return mon_out;
    }
    public void setMon_out(String mon_out) {
        this.mon_out = mon_out;
    }

    public String getTue_out() {
        return tue_out;
    }
    public void setTue_out(String tue_out) {
        this.tue_out = tue_out;
    }

    public String getWed_out() {
        return wed_out;
    }
    public void setWed_out(String wed_out) {
        this.wed_out = wed_out;
    }

    public String getThu_out() {
        return thu_out;
    }
    public void setThu_out(String thu_out) {
        this.thu_out = thu_out;
    }

    public String getFri_out() {
        return fri_out;
    }
    public void setFri_out(String fri_out) {
        this.fri_out = fri_out;
    }

    public String getSat_out() {
        return sat_out;
    }
    public void setSat_out(String sat_out) {
        this.sat_out = sat_out;
    }
}
