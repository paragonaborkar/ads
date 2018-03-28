package com.netapp.ads.models.verum.application;

import java.util.List;

public class OSI
{
    private String message;

    private String statusCode;

    private String dataExist;

    private String verumModelObjectName;

    private List<VerumObjectList> verumObjectList;

    private String success;
    
    public OSI() {
	}

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getStatusCode ()
    {
        return statusCode;
    }

    public void setStatusCode (String statusCode)
    {
        this.statusCode = statusCode;
    }

    public String getDataExist ()
    {
        return dataExist;
    }

    public void setDataExist (String dataExist)
    {
        this.dataExist = dataExist;
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

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

}