package org.javacore.pattern.prototype;

import java.util.Date;

/**
 *  工作经历
 * Created by znq on 2018/1/25.
 */
public class WorkExperience implements Cloneable{

    private Date workDate;

    private String company;

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
            "workDate=" + workDate +
            ", company='" + company + '\'' +
            '}';
    }
}
