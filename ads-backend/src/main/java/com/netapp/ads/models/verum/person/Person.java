package com.netapp.ads.models.verum.person;

import java.util.List;

public class Person
{
    private String statusCode;

    private String verumModelObjectName;

    private List<VerumObjectList> verumObjectList;

    public String getStatusCode ()
    {
        return statusCode;
    }

    public void setStatusCode (String statusCode)
    {
        this.statusCode = statusCode;
    }

    public String getVerumModelObjectName ()
    {
        return verumModelObjectName;
    }

    public void setVerumModelObjectName (String verumModelObjectName)
    {
        this.verumModelObjectName = verumModelObjectName;
    }

    public List<VerumObjectList> getVerumObjectList ()
    {
        return verumObjectList;
    }

    public void setVerumObjectList (List<VerumObjectList> verumObjectList)
    {
        this.verumObjectList = verumObjectList;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [statusCode = "+statusCode+", verumModelObjectName = "+verumModelObjectName+", verumObjectList = "+verumObjectList+"]";
    }
}
