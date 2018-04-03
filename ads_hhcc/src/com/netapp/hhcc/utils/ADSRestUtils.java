package com.netapp.hhcc.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.tools.ant.util.Base64Converter;

import com.netapp.ads.hhcc.utils.JSONUtils;
import com.netapp.ads.hhcc.vo.NADataSource;


public class ADSRestUtils {

	public static void main(String[] args) {
					
			new ADSRestUtils().getNetAppDataSources();		
	}

	public  NADataSource[] getNetAppDataSources() {
		
		HttpURLConnection conn = null;
		NADataSource[] naDataSourceArray = null;
		try {
			disableSSL();
			URL url = new URL("https://10.216.15.37/rest/v1/admin/datasources");	
			String credentials = "admin" + ":" + "admin123";

			Base64Converter converter = new Base64Converter();
			String encoding = converter.encode(credentials.getBytes("UTF-8"));

			URLConnection uc = url.openConnection();
			uc.setRequestProperty("Authorization", String.format("Basic %s", encoding));

			 conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			conn.setRequestProperty("Authorization", "Basic " + encoding);			

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			// create java object from json response	
			JSONUtils jsonUtils=new JSONUtils();
			naDataSourceArray=(NADataSource[]) jsonUtils.readData(conn.getInputStream(), NADataSource[].class);

			
			List<String> founadationIpsList = new ArrayList<String>();
		
			if(naDataSourceArray!=null) {
				for (NADataSource datasourceObj : naDataSourceArray) {					
				
					founadationIpsList.add(datasourceObj.getFoundationIp());					
				}
			}
			System.out.println("founadationIpsList from util class is-->"+founadationIpsList);			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			conn.disconnect();
		}
		
		return naDataSourceArray;
	}

	public static void disableSSL() {

		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
						throws java.security.cert.CertificateException {
					// TODO Auto-generated method stub

				}

				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
						throws java.security.cert.CertificateException {
					// TODO Auto-generated method stub

				}
			} };

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}

	}

}
