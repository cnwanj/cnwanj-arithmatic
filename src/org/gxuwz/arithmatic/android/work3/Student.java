package org.gxuwz.arithmatic.android.work3;

public class Student {

    private Integer sNo;
    private String sName;
    private Integer sSex;
    private String sClass;
    private String sBirthday;

    public Student(){}

    public Student(Integer sNo, String sName, Integer sSex, String sClass, String sBirthday) {
        this.sNo = sNo;
        this.sName = sName;
        this.sSex = sSex;
        this.sClass = sClass;
        this.sBirthday = sBirthday;
    }

    public Integer getsNo() {
        return sNo;
    }

    public void setsNo(Integer sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsSex() {
        return sSex;
    }

    public void setsSex(Integer sSex) {
        this.sSex = sSex;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getsBirthday() {
        return sBirthday;
    }

    public void setsBirthday(String sBirthday) {
        this.sBirthday = sBirthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sNo=" + sNo +
                ", sName='" + sName + '\'' +
                ", sSex=" + (sSex==1?"男":"女") +
                ", sClass='" + sClass + '\'' +
                ", sBirthday=" + sBirthday +
                '}';
    }
}
