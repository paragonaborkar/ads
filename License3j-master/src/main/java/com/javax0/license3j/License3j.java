package com.javax0.license3j;

import com.javax0.license3j.licensor.License;
import com.javax0.license3j.utils.CommandLineProcessor;

import java.io.*;
import java.util.ArrayList;
//import java.net.URL;
//import java.net.URLClassLoader;
import java.util.List;



/**
 * A sample command line tool application that
 * demonstrate the use of license3j
 * and also a nice tool to help development.
 * –
 * Simple class containing public static main to encode and decode licenses from
 * the command line.
 *
 * @author Peter Verhas
 */
public class License3j {

	private static final String commandLineString = "java -cp license3j.jar com.javax0.license3j.License3j";

	private static PrintStream errorOutput = System.err;
	private static CommandLineProcessor commandLine;

	private static void printUsage(String[] args) {
		errorOutput.print("Usage: " + commandLineString + " decode options\n"
				+ " mandatory options are: \n"
				+ "--license-file, --keyring-file, [ --output ] [--charset]\n");
		errorOutput
		.println("Usage: "
				+ commandLineString
				+ " command options\n"
				+ "commands available: \n"
				+ "      * encode\n"
				+ "      * decode\n"
				+ "arguments to the different commands type the command w/o args");
		if (args != null) {
			errorOutput.println("Arguments on the command line:");
			int i = 1;
			for (String arg : args) {
				errorOutput.println(i + ". " + arg);
				i++;
			}
			errorOutput.println("Command line options:");
			i = 1;
			for (String opt : commandLine.getOptions().keySet()) {
				errorOutput.println(i + ". option[" + opt + "]="
						+ commandLine.option(opt));
				i++;
			}
		}
		errorOutput.println("Current working directory "
				+ System.getProperties().get("user.dir"));
	}


	public static String[] add(String[] stringArray, String newValue)
	{
		String[] tempArray = new String[ stringArray.length + 1 ];
		for (int i=0; i<stringArray.length; i++)
		{
			tempArray[i] = stringArray[i];
		}
		tempArray[stringArray.length] = newValue;
		return tempArray;
	}

	/**
	 * Call this method from the command line.
	 * <p>
	 * <p>
	 * <pre>
	 *  java -cp license3j.jar com.javax0.license3j.License3j command options
	 *   commands available:
	 *       encode
	 *       decode
	 * to get arguments to the different commands type the command w/o args
	 * </pre>
	 * </p>
	 */
	public static void main(String[] args) throws Exception {

		System.out.println("Starting...");

		// FIXME: Tried to manually load the jar file here. Doesn't work correctly when this main() is run from a executeable jar.
		//		ClassLoader cl = ClassLoader.getSystemClassLoader();
		//		URL[] urls = ((URLClassLoader)cl).getURLs();
		//
		//		JarFileLoader jfl = new JarFileLoader(urls);
		//		jfl.addFile ("C:\\Users\\zemastev\\workspace\\License3j-master\\target\\bcprov-ext-jdk15on-159.jar");
		//		jfl.loadClass("org.bouncycastle.jce.provider.BouncyCastleProvider");
		//		System.out.println("Loaded: org.bouncycastle.jce.provider.BouncyCastleProvider");	
		//		urls = ((URLClassLoader) jfl).getURLs();
		//		
		//		for(URL url: urls){
		//			System.out.println(url.getFile());
		//		}
		// End manual loading of JAR
		
		List itemsToProcess = new ArrayList();
		
		
		
		// IF you wanted to create multiple keys while running in an IDE:
		itemsToProcess.add(new String[] {"--license-file=license-plain-0.txt", "--keyring-file=C:\\Users\\stephen.zemanick\\Desktop\\workspace\\License3j-master\\secring.gpg", "--key=GrooWikiDemoKey",  "--password=123123123", "--output=license-0.out", "encode"});
//		itemsToProcess.add(new String[] {"--license-file=license-plain-1.txt", "--keyring-file=c:\\users\\zemastev\\secring.gpg", "--key=GrooWikiDemoKey",  "--password=123123123", "--output=license-1.out", "encode"});
//		itemsToProcess.add(new String[] {"--license-file=license-plain-2.txt", "--keyring-file=c:\\users\\zemastev\\secring.gpg", "--key=GrooWikiDemoKey",  "--password=123123123", "--output=license-2.out", "encode"});
//		itemsToProcess.add(new String[] {"--license-file=license-plain-3.txt", "--keyring-file=c:\\users\\zemastev\\secring.gpg", "--key=GrooWikiDemoKey",  "--password=123123123", "--output=license-3.out", "encode"});
//		itemsToProcess.add(new String[] {"--license-file=license-plain-4.txt", "--keyring-file=c:\\users\\zemastev\\secring.gpg", "--key=GrooWikiDemoKey",  "--password=123123123", "--output=license-4.out", "encode"});
//		itemsToProcess.add(new String[] {"--license-file=license-plain-5.txt", "--keyring-file=c:\\users\\zemastev\\secring.gpg", "--key=GrooWikiDemoKey",  "--password=123123123", "--output=license-5.out", "encode"});
//		itemsToProcess.add(new String[] {"--license-file=license-plain-6.txt", "--keyring-file=c:\\users\\zemastev\\secring.gpg", "--key=GrooWikiDemoKey",  "--password=123123123", "--output=license-6.out", "encode"});
//		
//		itemsToProcess.add(new String[] {"--license-file=license-plain-err-expired.txt", "--keyring-file=c:\\users\\zemastev\\secring.gpg", "--key=GrooWikiDemoKey",  "--password=123123123", "--output=license-plain-err-expired.out", "encode"});
//		itemsToProcess.add(new String[] {"--license-file=license-plain-err-issued-in-future.txt", "--keyring-file=c:\\users\\zemastev\\secring.gpg", "--key=GrooWikiDemoKey",  "--password=123123123", "--output=license-plain-err-issued-in-future.out", "encode"});
//		itemsToProcess.add(new String[] {"--license-file=license-plain-invalid-fields.txt", "--keyring-file=c:\\users\\zemastev\\secring.gpg", "--key=GrooWikiDemoKey",  "--password=123123123", "--output=license-plain-invalid-fields.out", "encode"});
		
		// Uncomment the following to create multiple keys
		//for (int i=0; i<itemsToProcess.size(); i++) {
			// args = (String[])  itemsToProcess.get(i);
			
		commandLine = new CommandLineProcessor();
		if (args == null || args.length == 0) {
			printUsage(args);
			return;
		}
		System.out.println("Args are OK");


		commandLine.process(args);
		if (commandLine.getFiles().size() < 1) {
			printUsage(args);
			return;
		}
		System.out.println("Files are OK");

		String command = commandLine.getFiles().get(0);

		System.out.println("Command:" + command);

		if ("encode".equals(command)) {
			// encode a license file
			new License3j().encode();
		}
		if ("decode".equals(command)) {
			new License3j().decode();
		}

		System.out.println("DONE.");
		// Uncomment the following to create multiple keys
//		}
		
	}

	private void encode() throws Exception {
		try {
			System.out.println();
			System.out.println("Going to encode");
			System.out.println();
			OutputStream os = new FileOutputStream(commandLine.option("output"));
			os.write((new License().setLicense(
					new File(commandLine.option("license-file")), "utf-8").loadKey(
							commandLine.option("keyring-file"),
							commandLine.option("key")).encodeLicense(commandLine
									.option("password"))).getBytes("utf-8"));
			os.close();
		} catch (Exception e) {
			errorOutput
			.print("Usage: "
					+ commandLineString
					+ " encode options\n"
					+ " mandatory options are: \n"
					+ "--license-file, --keyring-file, --key, --password, --output\n");
			throw e;
		}
	}

	private void decode() throws Exception {
		try {
			final License license;
			if ((license = new License())
					.loadKeyRing(commandLine.option("keyring-file"), null)
					.setLicenseEncodedFromFile(
							commandLine.option("license-file"), "utf-8").isVerified()) {
				OutputStream os = System.out;
				if (commandLine.optionExists("output")) {
					os = new FileOutputStream(commandLine.option("output"));
				}
				final Writer w;
				if (commandLine.optionExists("charset")) {
					w = new OutputStreamWriter(os,
							commandLine.option("charset"));
				} else {
					w = new OutputStreamWriter(os);
				}
				w.write("---LICENSE STRING PLAIN TEXT START\n");
				w.flush();
				license.dumpLicense(os);
				os.flush();
				w.write("---LICENSE STRING PLAIN TEXT END\n");
				w.write("Encoding license key id=" + license.getDecodeKeyId()
				+ "L\n");
				w.write("---KEY RING DIGEST START\n");
				w.write(license.dumpPublicKeyRingDigest());
				w.write("---KEY RING DIGEST END\n");
				w.close();
				os.close();
			} else {
				errorOutput.println("The license can not be verified.");
			}
		} catch (Exception e) {
			printUsage(null);
			e.printStackTrace(errorOutput);
			throw e;
		}
	}
}
