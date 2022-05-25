package com.example.day4sbexer.models;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AnnualLeave {
    private String id;
    private String  empName;
    private Date startDate; // the start date  of annual leave
    private Date endDate; // the end date of the annual leave

    public AnnualLeave(String id, String empName, Date startDate, Date endDate) {

        this.id = id;
        this.empName = empName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
