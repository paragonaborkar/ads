
package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
		name="netapp")
public class NetApp {

/*    namespace="http://www.netapp.com/filer/admin",
*/
    		
	private Results results;

	public Results getResults() {
		return results;
	}

	@XmlElement(name = "results")
	public void setResults(Results results) {
		this.results = results;
	}
	
	
}
