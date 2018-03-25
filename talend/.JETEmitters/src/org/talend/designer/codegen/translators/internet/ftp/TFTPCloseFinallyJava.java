package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFTPCloseFinallyJava
{
  protected static String nl;
  public static synchronized TFTPCloseFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPCloseFinallyJava result = new TFTPCloseFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t Object connObj = globalMap.get(\"conn_";
  protected final String TEXT_2 = "\");" + NL + "\t if (connObj != null) {   ";
  protected final String TEXT_3 = NL + "              com.enterprisedt.net.ftp.FTPClient conn = (com.enterprisedt.net.ftp.FTPClient) connObj;" + NL + "              conn.executeCommand(\"quit\");";
  protected final String TEXT_4 = NL + "              com.jcraft.jsch.ChannelSftp channel = (com.jcraft.jsch.ChannelSftp) connObj; " + NL + "              com.jcraft.jsch.Session session = channel.getSession();" + NL + "              channel.disconnect();" + NL + "\t\t\t  session.disconnect();";
  protected final String TEXT_5 = NL + "              it.sauronsoftware.ftp4j.FTPClient conn = (it.sauronsoftware.ftp4j.FTPClient) connObj;" + NL + "              conn.disconnect(true);";
  protected final String TEXT_6 = NL + "     " + NL + "  }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String cid = node.getUniqueName();
	boolean sftp = "true".equals(ElementParameterParser.getValue(node.getProcess(), connection, "__SFTP__"));
    boolean ftps = "true".equals(ElementParameterParser.getValue(node.getProcess(), connection, "__FTPS__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_2);
            if (sftp == false && ftps == false) { 
    stringBuffer.append(TEXT_3);
            } else if (sftp) { 
    stringBuffer.append(TEXT_4);
            } else if (ftps) { 
    stringBuffer.append(TEXT_5);
            }  
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
