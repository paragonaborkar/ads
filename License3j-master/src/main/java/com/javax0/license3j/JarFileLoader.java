package com.javax0.license3j;

import java.net.URL;
import java.io.IOException;
import java.net.URLClassLoader;
import java.net.MalformedURLException;
public class JarFileLoader extends URLClassLoader
{
    public JarFileLoader (URL[] urls)
    {
        super (urls);
    }
    
    public void addFile (String path) throws MalformedURLException
    {
        String urlPath = "jar:file://" + path + "!/";
        addURL (new URL (urlPath));
    }
    
    public static void main (String args [])
    {
        try
        {
            System.out.println ("First attempt...");
            Class.forName ("org.gjt.mm.mysql.Driver");
        }
        catch (Exception ex)
        {
            System.out.println ("Failed.");
        }
        try
        {
            URL urls [] = {};
            JarFileLoader cl = new JarFileLoader (urls);
            cl.addFile ("/opt/mysql-connector-java-5.0.4/mysql-connector-java-5.0.4-bin.jar");
            System.out.println ("Second attempt...");
            cl.loadClass ("org.gjt.mm.mysql.Driver");
            System.out.println ("Success!");
        }
        catch (Exception ex)
        {
            System.out.println ("Failed.");
            ex.printStackTrace ();
        }
    }
}