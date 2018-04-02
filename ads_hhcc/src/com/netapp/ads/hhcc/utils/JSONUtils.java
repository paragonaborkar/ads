package com.netapp.ads.hhcc.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONUtils {

	private static ObjectMapper jsonMapper = new ObjectMapper();

	public JSONUtils() {
		jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	public <T> void writeToFile(String strExportFile, Object className) {

		File exportFile = new File(strExportFile);
		File exportDirectory = exportFile.getParentFile();
		if (!exportDirectory.exists() || !exportDirectory.isDirectory()) {
			exportDirectory.mkdirs();
		}

		try {
			jsonMapper.writeValue(exportFile, className);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public <T> Object readFile(String strFile, Class<T> className) {

		Object object = null;
		try {
			object = jsonMapper.readValue(new File(strFile), className);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}

	
	public <T> Object readData(InputStream iStream, Class<T> className) {

		Object object = null;
		try {
			object = jsonMapper.readValue(iStream, className);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * Staff staff = new Staff();
	 * 
	 * staff.setName("mkyong"); staff.setAge(33); staff.setPosition("Developer");
	 * staff.setSalary(new BigDecimal("7500"));
	 * 
	 * List<String> skills = new ArrayList<>(); skills.add("java");
	 * skills.add("python");
	 * 
	 * staff.setSkills(skills);
	 * 
	 * new JSONUtils().writeToFile("c:/temp/jsontest.json", staff); Staff
	 * newStaff=(Staff) new JSONUtils().readFile("c:/temp/jsontest.json",
	 * Staff.class);
	 * 
	 * System.out.println(newStaff.getSkills().get(0)); }
	 */

}
