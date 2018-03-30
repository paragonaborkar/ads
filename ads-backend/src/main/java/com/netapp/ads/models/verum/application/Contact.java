package com.netapp.ads.models.verum.application;

public class Contact
{
    private String verumIdentifier;

    private String invNo;

    private String sid;

    private String contactType;
    
    public Contact() {
	}

    public String getVerumIdentifier ()
    {
        return verumIdentifier;
    }

    public void setVerumIdentifier (String verumIdentifier)
    {
        this.verumIdentifier = verumIdentifier;
    }

    public String getInvNo ()
    {
        return invNo;
    }

    public void setInvNo (String invNo)
    {
        this.invNo = invNo;
    }

    public String getSid ()
    {
        return sid;
    }

    public void setSid (String sid)
    {
        this.sid = sid;
    }

    public String getContactType ()
    {
        return contactType;
    }

    public void setContactType (String contactType)
    {
        this.contactType = contactType;
    }
}
