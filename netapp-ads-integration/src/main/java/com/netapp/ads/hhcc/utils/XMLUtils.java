package com.netapp.ads.hhcc.utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLUtils {

	DocumentBuilderFactory docFactory;
	DocumentBuilder docBuilder;

	public Document newXML() {

		Document xmlDocument = null;
		docFactory = DocumentBuilderFactory.newInstance();

		try {
			docBuilder = docFactory.newDocumentBuilder();
			xmlDocument = docBuilder.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return xmlDocument;
	}

	public Element addRootElement(Document xmlDocument, String strRootElementName) {

		Element rootElement = xmlDocument.createElement(strRootElementName);
		xmlDocument.appendChild(rootElement);
		return rootElement;

	}

	public Element addChildElement(Document xmlDocument, Element parentElement, String strChildElementName,
			String strChildElementValue) {

		Element childElement = xmlDocument.createElement(strChildElementName);
		parentElement.appendChild(childElement);
		if (strChildElementValue != null) {
			childElement.appendChild(xmlDocument.createTextNode(strChildElementValue));
		}
		return childElement;
	}

	public void saveXMLToFile(Document xmlDocument, String strFileLoc) {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xmlDocument);
			StreamResult result = new StreamResult(new File(strFileLoc));
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		XMLUtils xmlUtils = new XMLUtils();
		Document xmlDocument = xmlUtils.newXML();
		Element rootElement = xmlUtils.addRootElement(xmlDocument, "nfs-stats-top-clients-list-iter-start");
		xmlUtils.addChildElement(xmlDocument, rootElement, "maxClient", "1000000");

		xmlUtils.saveXMLToFile(xmlDocument, "C:\\temp\\file.xml");

	}
}
