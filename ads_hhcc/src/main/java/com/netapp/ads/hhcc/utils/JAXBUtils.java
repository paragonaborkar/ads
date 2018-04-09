package com.netapp.ads.hhcc.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.netapp.ads.hhcc.jaxb.Results;

public class JAXBUtils {

	public static <T> Object getNetAppObjectForXML(InputStream fis, Class<T> className) {

		Object object = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(className);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			object = jaxbUnmarshaller.unmarshal(fis);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return object;
	}

	public static void main(String[] args) {

		try {

			/*
			 * Consumer consumerObj = (Consumer) JAXBUtils.getObject(new
			 * FileInputStream("C:/temp/file1.xml"),Consumer.class);
			 * System.out.println(consumerObj.getPhone());
			 */
			// Netapp consumerObj = (Netapp) JAXBUtils.getObject(new
			// FileInputStream("C:/Users/bondmoha/Documents/workspace-sts-3.9.1.RELEASE/PowerShellToJava/src/com/test/jaxb/xsd/results.xml"),Netapp.class);
			/*
			 * NetApp consumerObj = (NetApp) JAXBUtils.getNetAppObjectForXML(new
			 * FileInputStream(
			 * "C:/Users/bondmoha/Documents/workspace-sts-3.9.1.RELEASE/PowerShellToJava/src/com/netapp/ads/storage/pojo/results.xml"
			 * ),NetApp.class);
			 * 
			 * 
			 * //System.out.println(consumerObj.getResults().getVfilers().getVfilerInfo()[1]
			 * .getVfnets().getVfnetInfo()[0].getIpaddress());
			 * //System.out.println(consumerObj.getResults().getInterfaceConfigInfo().
			 * getInterfaceConfigInfoChild().getV4PrimaryAddress().getIpAddressInfo().
			 * getAddress());
			 * System.out.println(consumerObj.getResults().getInterfaceConfigInfo().
			 * getInterfaceConfigInfoChild().getV4PrimaryAddress().getIpAddressInfo().
			 * getAddress());
			 */
			Results consumerObj = (Results) JAXBUtils.getNetAppObjectForXML(new FileInputStream(
					"C:/Users/bondmoha/Documents/workspace-sts-3.9.1.RELEASE/PowerShellToJava/src/com/netapp/ads/storage/pojo/results_2.xml"),
					Results.class);
			// System.out.println(consumerObj.getInterfaceConfigInfo().getInterfaceConfigInfoChild().getV4PrimaryAddress().getIpAddressInfo().getAddress());
			// System.out.println(consumerObj.getSystemInfo().getSystemName());
			System.out.println(consumerObj.getInterfaceConfigInfo().getInterfaceConfigInfoChild()[0]
					.getV4PrimaryAddress().getIpAddressInfo().getAddress());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
