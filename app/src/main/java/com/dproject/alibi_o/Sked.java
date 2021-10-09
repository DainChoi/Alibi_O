package com.dproject.alibi_o;

import java.io.Serializable;
import java.util.HashMap;

public class Sked implements Serializable {
    private String name;  // 직원 이름
    private String time_in;  // 출근 시간
    private String time_out;  // 퇴근 시간
    private String date;  // 날짜

    public Sked(){

    }
    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getTime_in(){
        return time_in;
    }

    public void setTime_in(String time_in) {
        this.time_in = time_in;
    }

    public String getTime_out(){
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }

    public HashMap<String, String> toFirebaseObject(){
        HashMap<String, String> sked = new HashMap<String, String>();
        sked.put("name",name);
        sked.put("time_in", time_in);
        sked.put("time_out", time_out);
        sked.put("date", date);

        return sked;
    }

}
