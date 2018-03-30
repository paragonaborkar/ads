package com.netapp.ads.models.verum.esource;

import java.util.List;

public class EmployeeProfile
{
    private String statusCode;

    private List<EmployeeList> employeeList;

    private String profileName;

    public String getStatusCode ()
    {
        return statusCode;
    }

    public void setStatusCode (String statusCode)
    {
        this.statusCode = statusCode;
    }

    public List<EmployeeList> getEmployeeList ()
    {
        return employeeList;
    }

    public void setEmployeeList (List<EmployeeList> employeeList)
    {
        this.employeeList = employeeList;
    }

    public String getProfileName ()
    {
        return profileName;
    }

    public void setProfileName (String profileName)
    {
        this.profileName = profileName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [statusCode = "+statusCode+", employeeList = "+employeeList+", profileName = "+profileName+"]";
    }
}
