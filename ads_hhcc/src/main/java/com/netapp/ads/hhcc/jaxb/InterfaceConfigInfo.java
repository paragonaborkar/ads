package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class InterfaceConfigInfo {

	private InterfaceConfigInfoChild[] interfaceConfigInfoChild;

	public InterfaceConfigInfoChild[] getInterfaceConfigInfoChild() {
		return interfaceConfigInfoChild;
	}

	@XmlElement(name = "interface-config-info")
	public void setInterfaceConfigInfoChild(InterfaceConfigInfoChild[] interfaceConfigInfoChild) {
		this.interfaceConfigInfoChild = interfaceConfigInfoChild;
	}

}
