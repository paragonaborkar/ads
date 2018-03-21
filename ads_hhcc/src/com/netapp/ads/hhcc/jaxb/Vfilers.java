package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class Vfilers
{
    private VfilerInfo[] vfilerInfo;

    public VfilerInfo[] getVfilerInfo ()
    {
        return vfilerInfo;
    }

    @XmlElement(name = "vfiler-info")
    public void setVfilerInfo (VfilerInfo[] vfilerInfo)
    {
        this.vfilerInfo = vfilerInfo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [vfilerInfo = "+vfilerInfo+"]";
    }
}