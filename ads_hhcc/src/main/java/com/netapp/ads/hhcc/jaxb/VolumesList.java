package com.netapp.ads.hhcc.jaxb;
import javax.xml.bind.annotation.XmlElement;

public class VolumesList {

	VolumeListInfo[] volumesListInfo;

	public VolumeListInfo[] getVolumesListInfo() {
		return volumesListInfo;
	}

	@XmlElement(name = "volumes-list-info")
	public void setVolumesListInfo(VolumeListInfo[] volumesListInfo) {
		this.volumesListInfo = volumesListInfo;
	}
	
	
}
