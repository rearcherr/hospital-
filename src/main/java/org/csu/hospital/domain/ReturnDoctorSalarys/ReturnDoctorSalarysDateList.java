package org.csu.hospital.domain.ReturnDoctorSalarys;

public class ReturnDoctorSalarysDateList {
    private long id;
    private String name;
    private String department;
    private String rank;
    private boolean onduty;
    private double wage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public boolean isOnduty() {
        return onduty;
    }

    public void setOnduty(boolean onduty) {
        this.onduty = onduty;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
}
