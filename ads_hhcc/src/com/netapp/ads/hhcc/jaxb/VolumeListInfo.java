package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class VolumeListInfo {

	String volume;

	public String getVolume() {
		return volume;
	}

	@XmlElement(name = "volume")
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
}
