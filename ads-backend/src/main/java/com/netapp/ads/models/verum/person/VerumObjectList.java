package com.netapp.ads.models.verum.person;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VerumObjectList
{
    private String verumIdentifier;

    @JsonProperty("SID")
    private String sid;

    private String lastName;

    private String status;

    private String email;

    private String nickName;

    private String businessUnitId;

    private String managerSid;

    private String costCenter;

    private String fullName;

    private String firstName;

    public String getVerumIdentifier ()
    {
        return verumIdentifier;
    }

    public void setVerumIdentifier (String verumIdentifier)
    {
        this.verumIdentifier = verumIdentifier;
    }

    @JsonProperty("SID")
     public String getSid() {
		return sid;
	}

    @JsonProperty("SID")
	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getLastName ()
    {
        return lastName;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getNickName ()
    {
        return nickName;
    }

    public void setNickName (String nickName)
    {
        this.nickName = nickName;
    }

    public String getBusinessUnitId ()
    {
        return businessUnitId;
    }

    public void setBusinessUnitId (String businessUnitId)
    {
        this.businessUnitId = businessUnitId;
    }

    public String getManagerSid ()
    {
        return managerSid;
    }

    public void setManagerSid (String managerSid)
    {
        this.managerSid = managerSid;
    }

    public String getCostCenter ()
    {
        return costCenter;
    }

    public void setCostCenter (String costCenter)
    {
        this.costCenter = costCenter;
    }

    public String getFullName ()
    {
        return fullName;
    }

    public void setFullName (String fullName)
    {
        this.fullName = fullName;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [verumIdentifier = "+verumIdentifier+", sid = "+sid+", lastName = "+lastName+", status = "+status+", email = "+email+", nickName = "+nickName+", businessUnitId = "+businessUnitId+", managerSid = "+managerSid+", costCenter = "+costCenter+", fullName = "+fullName+", firstName = "+firstName+"]";
    }
}
