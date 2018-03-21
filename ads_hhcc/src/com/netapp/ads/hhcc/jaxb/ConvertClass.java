package com.netapp.ads.hhcc.jaxb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConvertClass {

	public static void main(String[] args) {

		try {
			File file=new File("C:\\Users\\bondmoha\\Documents\\workspace-sts-3.9.1.RELEASE\\PowerShellToJava\\src\\com\\netapp\\ads\\storage\\pojo\\ClassData.txt");
			BufferedReader br=new BufferedReader(new FileReader(file));
			
			String line=null;
			while((line=br.readLine())!=null) {
				
				String newLine;
				if(line.contains("-")) {
					
					String newLine1="";
					String newLine2="";
					
					String guess="-";
					
					newLine1=line;
					int index = newLine1.indexOf(guess);
					while (index >= 0) {
						
						//System.out.println(line);
					    //System.out.println(index);
					    newLine2=newLine2+newLine1.substring(0, index);
					    newLine2=newLine2+newLine1.substring(index+1,index+2).toUpperCase();
					    newLine1=newLine1.substring(index+2);
					    index = newLine1.indexOf(guess);
					    
					}
					
					newLine2=newLine2+newLine1;
					newLine=newLine2;
					//System.out.println(newLine2);
					
					//int index=line.indexOf("-");
					
				} else {
					newLine=line;
				}
				System.out.println(newLine);
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
