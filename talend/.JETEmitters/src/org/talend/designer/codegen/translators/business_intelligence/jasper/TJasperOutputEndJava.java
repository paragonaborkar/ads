package org.talend.designer.codegen.translators.business_intelligence.jasper;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;

public class TJasperOutputEndJava
{
  protected static String nl;
  public static synchronized TJasperOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJasperOutputEndJava result = new TJasperOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t" + NL + "\tif(CsvWriter_";
  protected final String TEXT_3 = "!=null) {" + NL + "\t\tCsvWriter_";
  protected final String TEXT_4 = ".close();" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_5 = "_NB_LINE\",nb_line_";
  protected final String TEXT_6 = ");" + NL + "\t" + NL + "\tString jasperFile_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = "+jrxmlName_";
  protected final String TEXT_9 = "+ \".jasper\";" + NL + "    String reportFile_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = "+\"/\"+";
  protected final String TEXT_12 = "+\".";
  protected final String TEXT_13 = "\";" + NL + "    " + NL + "    net.sf.jasperreports.engine.design.JasperDesign jasperDesign_";
  protected final String TEXT_14 = " = net.sf.jasperreports.engine.xml.JRXmlLoader.load(";
  protected final String TEXT_15 = ");" + NL + "    " + NL + "    jasperDesign_";
  protected final String TEXT_16 = ".setLanguage(net.sf.jasperreports.engine.design.JasperDesign.LANGUAGE_JAVA);" + NL + "    net.sf.jasperreports.engine.JasperCompileManager.compileReportToFile(jasperDesign_";
  protected final String TEXT_17 = ", jasperFile_";
  protected final String TEXT_18 = ");" + NL + "    java.util.Locale reportLocale_";
  protected final String TEXT_19 = "=null;";
  protected final String TEXT_20 = NL + "\t\treportLocale_";
  protected final String TEXT_21 = "=java.util.Locale.";
  protected final String TEXT_22 = ";";
  protected final String TEXT_23 = NL + "\t\treportLocale_";
  protected final String TEXT_24 = "=java.util.Locale.getDefault();";
  protected final String TEXT_25 = NL + "    java.util.Map<String, Object> hm_";
  protected final String TEXT_26 = " = new java.util.HashMap<String, Object>();" + NL + "    hm_";
  protected final String TEXT_27 = ".put(net.sf.jasperreports.engine.JRParameter.REPORT_LOCALE, reportLocale_";
  protected final String TEXT_28 = ");" + NL + "" + NL + "    net.sf.jasperreports.engine.data.JRCsvDataSource ds_";
  protected final String TEXT_29 = " = new net.sf.jasperreports.engine.data.JRCsvDataSource(" + NL + "            new java.io.File(tempFile_";
  protected final String TEXT_30 = "),";
  protected final String TEXT_31 = ");" + NL + "" + NL + "    ds_";
  protected final String TEXT_32 = ".setFieldDelimiter(',');" + NL + "\tds_";
  protected final String TEXT_33 = ".setRecordDelimiter(System.getProperty(\"line.separator\"));" + NL + "    ds_";
  protected final String TEXT_34 = ".setUseFirstRowAsHeader(true);" + NL + "    net.sf.jasperreports.engine.JasperPrint print_";
  protected final String TEXT_35 = " = net.sf.jasperreports.engine.JasperFillManager.fillReport(" + NL + "            jasperFile_";
  protected final String TEXT_36 = ", hm_";
  protected final String TEXT_37 = ", ds_";
  protected final String TEXT_38 = ");" + NL;
  protected final String TEXT_39 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_40 = " = new net.sf.jasperreports.engine.export.JRHtmlExporter();\t\t";
  protected final String TEXT_41 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_42 = " = new net.sf.jasperreports.engine.export.JRPdfExporter();\t\t";
  protected final String TEXT_43 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_44 = " = new net.sf.jasperreports.engine.export.JRXlsExporter();\t\t";
  protected final String TEXT_45 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_46 = " = new net.sf.jasperreports.engine.export.JRRtfExporter();\t\t";
  protected final String TEXT_47 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_48 = " = new net.sf.jasperreports.engine.export.JRTextExporter();\t\t" + NL + "\texporter_";
  protected final String TEXT_49 = ".setParameter(net.sf.jasperreports.engine.export.JRTextExporterParameter.PAGE_WIDTH, new Float(\"255\"));" + NL + "    exporter_";
  protected final String TEXT_50 = ".setParameter(net.sf.jasperreports.engine.export.JRTextExporterParameter.CHARACTER_WIDTH, new Float(\"10\"));" + NL + "    exporter_";
  protected final String TEXT_51 = ".setParameter(net.sf.jasperreports.engine.export.JRTextExporterParameter.PAGE_HEIGHT, new Float(\"61\"));" + NL + "    exporter_";
  protected final String TEXT_52 = ".setParameter(net.sf.jasperreports.engine.export.JRTextExporterParameter.CHARACTER_HEIGHT, new Float(\"20\"));        ";
  protected final String TEXT_53 = NL + "\tnet.sf.jasperreports.engine.JRExporter exporter_";
  protected final String TEXT_54 = " = new net.sf.jasperreports.engine.export.oasis.JROdtExporter();\t\t";
  protected final String TEXT_55 = NL + "\texporter_";
  protected final String TEXT_56 = ".setParameter(net.sf.jasperreports.engine.JRExporterParameter.CHARACTER_ENCODING, ";
  protected final String TEXT_57 = ");" + NL + "    exporter_";
  protected final String TEXT_58 = ".setParameter(net.sf.jasperreports.engine.JRExporterParameter.OUTPUT_FILE_NAME, reportFile_";
  protected final String TEXT_59 = ");" + NL + "    exporter_";
  protected final String TEXT_60 = ".setParameter(net.sf.jasperreports.engine.JRExporterParameter.JASPER_PRINT, print_";
  protected final String TEXT_61 = ");" + NL + "    exporter_";
  protected final String TEXT_62 = ".exportReport();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String filename = ElementParameterParser.getValue(node,"__JRXML_FILE__");
        String tempDirectory = ElementParameterParser.getValue(node,"__TEMP_FILE__");
        String destinationDirectory = ElementParameterParser.getValue(node,"__DESTINATION__");
       	String reportType = ElementParameterParser.getValue(node,"__REPORT_TYPE__");
       	String outFileName=ElementParameterParser.getValue(node,"__FILE_NAME__");
       	boolean isSpecifyLocale="true".equals(ElementParameterParser.getValue(node,"__SPECIFY_LOCALE__"));
       	String reportLocale=ElementParameterParser.getValue(node,"__REPORT_LOCALE__");
       	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
       	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tempDirectory);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(destinationDirectory);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(outFileName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(reportType);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
	if(isSpecifyLocale){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(reportLocale);
    stringBuffer.append(TEXT_22);
    
	}else{

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
	}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
			if(reportType.equalsIgnoreCase("html")){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
			}else if(reportType.equalsIgnoreCase("pdf")){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
			}else if(reportType.equalsIgnoreCase("xls")){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
			}else if(reportType.equalsIgnoreCase("rtf")){

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
			}else if(reportType.equalsIgnoreCase("txt")){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
			}else if(reportType.equalsIgnoreCase("odt")){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
			}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
	}
}

    return stringBuffer.toString();
  }
}
