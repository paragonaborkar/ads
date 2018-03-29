package org.talend.designer.codegen.translators.business.healthcare_deprecated_;

import java.util.List;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THL7OutputBeginJava
{
  protected static String nl;
  public static synchronized THL7OutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THL7OutputBeginJava result = new THL7OutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "System.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "class TalendHL7Util_";
  protected final String TEXT_3 = " {" + NL + "\tpublic void findSegments(" + NL + "\t\t\tca.uhn.hl7v2.model.Group messParent," + NL + "\t\t\tjava.util.Map<String, ca.uhn.hl7v2.model.Segment> map) {" + NL + "\t\tString[] childNames = messParent.getNames();" + NL + "\t\tfor (int i = 0; i < childNames.length; i++) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tca.uhn.hl7v2.model.Structure structure = messParent" + NL + "\t\t\t\t\t\t.get(childNames[i]);" + NL + "" + NL + "\t\t\t\tif (structure instanceof ca.uhn.hl7v2.model.Group) {" + NL + "\t\t\t\t\tfindSegments(" + NL + "\t\t\t\t\t\t\t(ca.uhn.hl7v2.model.Group) structure," + NL + "\t\t\t\t\t\t\tmap);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tmap.put(structure.getName(), (ca.uhn.hl7v2.model.Segment)structure);" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (ca.uhn.hl7v2.HL7Exception e) {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getSegSpecPath(ca.uhn.hl7v2.model.Structure seg) {" + NL + "\t\tString resultSpec = \"\";" + NL + "\t\tca.uhn.hl7v2.model.Structure prev = null;" + NL + "\t\tca.uhn.hl7v2.model.Structure curr = seg;" + NL + "\t\twhile (curr !=null && prev != curr) {" + NL + "\t\t\tif (curr == seg) {" + NL + "\t\t\t} else if (curr.getParent()!=null && curr.getParent() != curr) {" + NL + "\t\t\t\tresultSpec = \"/\" + curr.getName() + resultSpec;" + NL + "\t\t\t}" + NL + "\t\t\tprev = curr;" + NL + "\t\t\tcurr = curr.getParent();" + NL + "\t\t}" + NL + "\t\tif (!\"\".equals(resultSpec)) {" + NL + "\t\t\tresultSpec = resultSpec + \"/\";" + NL + "\t\t}" + NL + "" + NL + "\t\treturn resultSpec;" + NL + "\t}" + NL + "}" + NL + "TalendHL7Util_";
  protected final String TEXT_4 = " util_";
  protected final String TEXT_5 = " = new TalendHL7Util_";
  protected final String TEXT_6 = "();" + NL + "java.util.Map<String, ca.uhn.hl7v2.model.Segment> map2Seg_";
  protected final String TEXT_7 = " = new java.util.HashMap<String, ca.uhn.hl7v2.model.Segment>();";
  protected final String TEXT_8 = NL + "int i_";
  protected final String TEXT_9 = "_";
  protected final String TEXT_10 = " = 0;";
  protected final String TEXT_11 = NL + "ca.uhn.hl7v2.util.Terser terser_";
  protected final String TEXT_12 = " = null;" + NL + "ca.uhn.hl7v2.model.Message msg_";
  protected final String TEXT_13 = " = null;" + NL + "" + NL + "String tmpValue_";
  protected final String TEXT_14 = " = \"\";" + NL + "String hl7Spec_";
  protected final String TEXT_15 = " = \"\";" + NL;
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
	List< ? extends IConnection> incomingConns = node.getIncomingConnections();
	for (IConnection incomingConn : incomingConns) {
		if ( incomingConn.getLineStyle().equals(EConnectionType.FLOW_MERGE)) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
		}
	}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
