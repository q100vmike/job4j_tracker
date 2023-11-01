package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String fio;
    private int groupnum;
    private Date admission;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getGroupnum() {
        return groupnum;
    }

    public void setGroupnum(int groupnum) {
        this.groupnum = groupnum;
    }

    public Date getAdmission() {
        return admission;
    }

    public void setAdmission(Date admission) {
        this.admission = admission;
    }
}
