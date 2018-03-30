package org.talend.designer.codegen.translators.business_intelligence.olap_cube.mondrian;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TMondrianInputBeginJava
{
  protected static String nl;
  public static synchronized TMondrianInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMondrianInputBeginJava result = new TMondrianInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t" + NL + "\t\t\t" + NL + "\t";
  protected final String TEXT_3 = NL + NL + "\t";
  protected final String TEXT_4 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "; ";
  protected final String TEXT_10 = NL + "\t\t" + NL + "\t\tmondrian.olap.Connection connection_";
  protected final String TEXT_11 = " = mondrian.olap.DriverManager.getConnection(" + NL + "\t\t\"Provider=mondrian;\" +" + NL + "\t\t\"Jdbc='\" + ";
  protected final String TEXT_12 = " + \"';\" +" + NL + "\t\t\"Catalog='\" + ";
  protected final String TEXT_13 = " + \"';\" +" + NL + "\t    \"JdbcDrivers=";
  protected final String TEXT_14 = ";\"";
  protected final String TEXT_15 = " +" + NL + "\t\t\"JdbcUser=\" + ";
  protected final String TEXT_16 = " + \";\"";
  protected final String TEXT_17 = " +" + NL + "\t\t\"JdbcPassword=\" + decryptedPassword_";
  protected final String TEXT_18 = " + \";\"";
  protected final String TEXT_19 = NL + "\t\t, null, true);" + NL + "\t";
  protected final String TEXT_20 = NL + "\t\t, null);" + NL + "\t";
  protected final String TEXT_21 = NL + "\t" + NL + "\tmondrian.olap.Query query_";
  protected final String TEXT_22 = " = connection_";
  protected final String TEXT_23 = ".parseQuery(";
  protected final String TEXT_24 = ");" + NL + "\tmondrian.olap.Result result_";
  protected final String TEXT_25 = " = connection_";
  protected final String TEXT_26 = ".execute(query_";
  protected final String TEXT_27 = ");" + NL + "\t" + NL + "\tmondrian.olap.Axis[] axes_";
  protected final String TEXT_28 = " = result_";
  protected final String TEXT_29 = ".getAxes();" + NL + "\tif (axes_";
  protected final String TEXT_30 = ".length != 2) {" + NL + "\t\tthrow new RuntimeException(\"Only two dimensional results are supported\");" + NL + "\t}" + NL + "\t" + NL + "\tmondrian.olap.Axis columns_";
  protected final String TEXT_31 = " = axes_";
  protected final String TEXT_32 = "[0];" + NL + "\tmondrian.olap.Axis rows_";
  protected final String TEXT_33 = " = axes_";
  protected final String TEXT_34 = "[1];" + NL + "\t" + NL + "\tint columnsCount_";
  protected final String TEXT_35 = " = columns_";
  protected final String TEXT_36 = ".getPositions().size();" + NL + "\tint y_";
  protected final String TEXT_37 = " = 0, pos_";
  protected final String TEXT_38 = ";" + NL + "\tint[] coords_";
  protected final String TEXT_39 = " = {0, 0};" + NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_40 = "_QUERY\", ";
  protected final String TEXT_41 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_42 = "_NB_LINE\", rows_";
  protected final String TEXT_43 = ".getPositions().size());" + NL + "\t" + NL + "\t";
  protected final String TEXT_44 = NL + "\t\t\tfor (mondrian.olap.Position position_";
  protected final String TEXT_45 = " : rows_";
  protected final String TEXT_46 = ".getPositions()) {" + NL + "\t\t\t\tcoords_";
  protected final String TEXT_47 = "[1] = y_";
  protected final String TEXT_48 = "++;" + NL + "\t\t\t\t" + NL + "\t\t\t\tpos_";
  protected final String TEXT_49 = " = 0;" + NL + "\t\t\t\tfor (mondrian.olap.Member member_";
  protected final String TEXT_50 = " : position_";
  protected final String TEXT_51 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\t    if (pos_";
  protected final String TEXT_53 = " == ";
  protected final String TEXT_54 = ") {" + NL + "\t\t\t\t\t\t    \t";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " = member_";
  protected final String TEXT_57 = ".getUniqueName();" + NL + "\t\t\t\t\t\t    }" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_58 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tpos_";
  protected final String TEXT_59 = "++;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tfor (int x_";
  protected final String TEXT_60 = " = 0; x_";
  protected final String TEXT_61 = " < columnsCount_";
  protected final String TEXT_62 = "; x_";
  protected final String TEXT_63 = "++) {" + NL + "\t\t\t\t\tcoords_";
  protected final String TEXT_64 = "[0] = x_";
  protected final String TEXT_65 = ";" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\t    if (x_";
  protected final String TEXT_67 = " + pos_";
  protected final String TEXT_68 = " == ";
  protected final String TEXT_69 = ") {" + NL + "\t\t\t\t\t    \tObject value_";
  protected final String TEXT_70 = " = result_";
  protected final String TEXT_71 = ".getCell(coords_";
  protected final String TEXT_72 = ").getValue();" + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t    \t\tif (value_";
  protected final String TEXT_74 = ".equals(mondrian.olap.Util.nullValue)) {" + NL + "\t\t\t\t\t\t    \t\t";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = " = null;" + NL + "\t\t\t\t\t\t    \t} else {" + NL + "\t\t\t\t\t    \t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\t\t    \t";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = " = value_";
  protected final String TEXT_80 = ".toString();" + NL + "\t\t\t\t\t    \t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\t    \t\tif (value_";
  protected final String TEXT_82 = " instanceof Integer) {" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = (";
  protected final String TEXT_85 = ") ((Integer) value_";
  protected final String TEXT_86 = ").intValue();" + NL + "\t\t\t\t\t    \t\t} else if (value_";
  protected final String TEXT_87 = " instanceof java.math.BigDecimal) {" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = " = (";
  protected final String TEXT_90 = ") ((java.math.BigDecimal) value_";
  protected final String TEXT_91 = ").longValue();" + NL + "\t\t\t\t\t    \t\t} else if (value_";
  protected final String TEXT_92 = " instanceof Double) {" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = " = (";
  protected final String TEXT_95 = ") ((Double) value_";
  protected final String TEXT_96 = ").doubleValue();" + NL + "\t\t\t\t\t    \t\t} else if (value_";
  protected final String TEXT_97 = " instanceof String) {" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = " = (";
  protected final String TEXT_100 = ") Integer.parseInt(value_";
  protected final String TEXT_101 = ".toString());" + NL + "\t\t\t\t\t    \t\t}" + NL + "\t\t\t\t\t    \t\t";
  protected final String TEXT_102 = NL + "\t\t\t\t\t    \t\tif (value_";
  protected final String TEXT_103 = " instanceof Double) {" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = (";
  protected final String TEXT_106 = ") ((Double) value_";
  protected final String TEXT_107 = ").doubleValue();" + NL + "\t\t\t\t\t    \t\t} else if (value_";
  protected final String TEXT_108 = " instanceof Integer) {" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = (";
  protected final String TEXT_111 = ") ((Integer) value_";
  protected final String TEXT_112 = ").intValue();" + NL + "\t\t\t\t\t    \t\t} else if (value_";
  protected final String TEXT_113 = " instanceof java.math.BigDecimal) {" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = " = (";
  protected final String TEXT_116 = ") ((java.math.BigDecimal) value_";
  protected final String TEXT_117 = ").longValue();" + NL + "\t\t\t\t\t    \t\t} else if (value_";
  protected final String TEXT_118 = " instanceof String) {" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = " = (";
  protected final String TEXT_121 = ") Double.parseDouble(value_";
  protected final String TEXT_122 = ".toString());" + NL + "\t\t\t\t\t    \t\t}" + NL + "\t\t\t\t\t    \t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\t    \t\t}" + NL + "\t\t\t\t\t    \t\t";
  protected final String TEXT_124 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t{" + NL + "\t\t\t";
  protected final String TEXT_132 = NL + "\t\t{" + NL + "\t\t";
  protected final String TEXT_133 = NL + "\t// No code generated: define input and output schema first" + NL + "\t" + NL + "\t{" + NL + "\t";
  protected final String TEXT_134 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();
String mondrainVersion = ElementParameterParser.getValue(node, "__DB_VERSION__"); 
// Search outgoing schema
IMetadataTable metadata = null;

List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas != null && metadatas.size() > 0) {
    metadata = metadatas.get(0);
}

// Inner class (see tCreateTable_main#Transfer)
class Transfer{
	public String dbDriver(INode node){
		String dbType = ElementParameterParser.getValue(node,"__DBTYPE__");
		if(("MSSQL").equals(dbType)){
			return "net.sourceforge.jtds.jdbc.Driver";
		}else if(("MySQL").equals(dbType)){
			return "org.gjt.mm.mysql.Driver";
		}else if(("Oracle").equals(dbType)){
			return "oracle.jdbc.driver.OracleDriver";
		}else if(("Postgre").equals(dbType)){
			return "org.postgresql.Driver";
		}else if(("Access").equals(dbType)){
			return "sun.jdbc.odbc.JdbcOdbcDriver";
		}else if(("DB2").equals(dbType)){
			return "com.ibm.db2.jcc.DB2Driver";
		}else if(("Firebird").equals(dbType)){
			return "org.firebirdsql.jdbc.FBDriver";
		}else if(("Informix").equals(dbType)){
			return "com.informix.jdbc.IfxDriver";
		}else if(("Ingres").equals(dbType)){
			return "com.ingres.jdbc.IngresDriver";
		}else if(("JavaDB").equals(dbType)){
			String frameworkType=ElementParameterParser.getValue(node,"__JAVADBFRAME__");
			if(("Embeded").equals(frameworkType)){
				return "org.apache.derby.jdbc.EmbeddedDriver";
			}else if(("JCCJDBC").equals(frameworkType)){
				return "com.ibm.db2.jcc.DB2Driver";
			}else if(("DERBYCLIENT").equals(frameworkType)){
				return "org.apache.derby.jdbc.ClientDriver";
			}
		}else if(("SQLite").equals(dbType)){
			return "org.sqlite.JDBC";
		}else if(("Sybase").equals(dbType)){
			return "com.sybase.jdbc3.jdbc.SybDriver";
		}else if(("ODBC").equals(dbType)){
			return "sun.jdbc.odbc.JdbcOdbcDriver";
		}else if(("HSQLdb").equals(dbType)){
			return "org.hsqldb.jdbcDriver";
		}else if(("Interbase").equals(dbType)){
			return "interbase.interclient.Driver";
		}
		return null;
	}
	
	
	public String url(INode node){	
		String dbType = ElementParameterParser.getValue(node,"__DBTYPE__");
		String host = ElementParameterParser.getValue(node,"__HOST__");
		String port = ElementParameterParser.getValue(node,"__PORT__");
		String dbname = ElementParameterParser.getValue(node,"__DBNAME__");
		String user = ElementParameterParser.getValue(node,"__USER__");

		String oraType = ElementParameterParser.getValue(node,"__ORACLETYPE__");

		if(("MSSQL").equals(dbType)){
			return "\"jdbc:jtds:sqlserver://\"+"+host+"+\":\"+"+port+"+\"//\"+"+dbname;
		}else if(("MySQL").equals(dbType)){
			return "\"jdbc:mysql://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname+ "+\"?noDatetimeStringSync=true\"";
		}else if(("Oracle").equals(dbType)){//depends on SID/Service
					if(("Oracle SID").equals(oraType)){
						return "\"jdbc:oracle:thin:@\"+"+host+"+\":\"+" + port + "+\":\"+" + dbname;
					}else{
						return "\"dbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\"+" + host + "+\")(port=\"+" + port + "+\"))(connect_data=(service_name=\"+" + dbname +"+\")))\"";			
					}
		}else if(("Postgre").equals(dbType)){
			return "\"jdbc:postgresql://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
		}else if(("Access").equals(dbType)){
		String accessDbname = ElementParameterParser.getValue(node,"__ACCESSDBNAME__");
			return "\"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=\"+"+accessDbname;
		}else if(("DB2").equals(dbType)){
			return "\"jdbc:db2://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
		}else if(("Firebird").equals(dbType)){			
			String firebirdDB=ElementParameterParser.getValue(node,"__FIREBIRDDBNAME__");
			return "\"jdbc:firebirdsql:\"+"+host+"+\":\"+"+firebirdDB;
		}else if(("Informix").equals(dbType)){
			String server=ElementParameterParser.getValue(node,"__INFORMIXSERVER__");			
			return "\"jdbc:informix-sqli://\"+"+host+ "+\":\"+"+port+"+\"/\"+"+dbname+"+\":informixserver=\"+"+server;
		}else if(("Ingres").equals(dbType)){
			return "\"jdbc:ingres://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
		}else if(("JavaDB").equals(dbType)){
			String frameworkType=ElementParameterParser.getValue(node,"__JAVADBFRAME__");
			if(("Embeded").equals(frameworkType)){
				return "\"jdbc:derby:\"+" + dbname;
			}else if(("JCCJDBC").equals(frameworkType)){
				return "\"+jdbc:derby:net://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
			}else if(("DERBYCLIENT").equals(frameworkType)){
				return "\"+jdbc:derby://\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
			}
		}else if(("SQLite").equals(dbType)){		
			String sqliteDB=ElementParameterParser.getValue(node,"__SQLITEDBNAME__");
			return "\"jdbc:sqlite:/\"+" +sqliteDB.toLowerCase();
		}else if(("Sybase").equals(dbType)){
			return "\"jdbc:sybase:Tds:\"+"+host+"+\":\"+"+port+"+\"/\"+"+dbname;
		}else if(("ODBC").equals(dbType)){
			return "\"jdbc:odbc:\" + " + dbname;
		}else if(("HSQLdb").equals(dbType)){
			String runningMode=ElementParameterParser.getValue(node,"__HSQLMODE__");
			String tls=ElementParameterParser.getValue(node,"__TLS__");
			String dbalias=ElementParameterParser.getValue(node,"__HSQLDATABASEALIAS__");
			if(("SERVER").equals(runningMode)){
				if(("true").equals(tls)){
					return "\"jdbc:hsqldb:hsqls://\"+" + host + "+\":\"+" + port + "+\"/\"+" + dbalias;
				}else{
					return "\"jdbc:hsqldb:hsql://\"+" + host + "+\":\"+" + port + "+\"/\"+" + dbalias;
				}
			}else if(("WEBSERVER").equals(runningMode)){
				if(("true").equals(tls)){
					return "\"jdbc:hsqldb:https://\"+" + host + "+\":\"+" + port + "+\"/\"+" + dbalias;
				}else{
					return  "\"jdbc:hsqldb:http://\"+" + host + "+\":\"+" + port + "+\"/\"+" + dbalias;
				}
			}else if(("PROCESS").equals(runningMode)){
				String dbpath=ElementParameterParser.getValue(node,"__HSQLDATABASEPATH__");
				String hdbname=ElementParameterParser.getValue(node,"__HSQLDATABASE__");
				return "\"jdbc:hsqldb:file:\"+" + dbpath + "+\"/\"+" + hdbname + "+\";ifexists=true\"";
			}
		}else if(("Interbase").equals(dbType)){
			return "\"jdbc:interbase://\"+"+host+"+\"/\"+"+dbname;
		}
		return null;
	}
}

if (metadata != null) {
	String dbuser = ElementParameterParser.getValue(node,"__USER__");
	String dbpwd = ElementParameterParser.getValue(node,"__PASS__");
	Transfer transfer = new Transfer();
	String catalog = ElementParameterParser.getValue(node, "__CATALOG__");
	String dbquery = ElementParameterParser.getValue(node, "__QUERY__");
	dbquery = dbquery.replaceAll("\n", " ");
	dbquery = dbquery.replaceAll("\r", " ");
	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	
    stringBuffer.append(TEXT_2);
    
	String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_3);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(transfer.url(node));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(catalog);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(transfer.dbDriver(node));
    stringBuffer.append(TEXT_14);
    
	if (!("\"\"").equals(dbuser)) {
		
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_16);
    
	}
	if (!("\"\"").equals(dbpwd)) {
		
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
	}
	if("mondrian_2.jar".equals(mondrainVersion)){
    stringBuffer.append(TEXT_19);
    
	}else if("mondrian_3.jar".equals(mondrainVersion)){
	
    stringBuffer.append(TEXT_20);
    
	}
	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
	List<? extends IConnection> outConnections = node.getOutgoingConnections();
	IConnection firstOutConnection = null;
	
	if (outConnections != null) {
		// Search first outgoing connection, if exists
		int connectionIndex = -1;
		for (int i = 0; i < outConnections.size(); i++) {
			IConnection connection = outConnections.get(i);
			if (connection.getLineStyle().hasConnectionCategory(
					IConnectionCategory.DATA)) {
				firstOutConnection = connection;
				connectionIndex = i;
				break;
			}
		}
		
		if (firstOutConnection != null) {
			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
					for (int i = 0; i < metadata.getListColumns().size(); i++) {
						IMetadataColumn column = metadata.getListColumns().get(i);
						
						String colname = column.getLabel();
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					    
					    if (("String").equals(typeToGenerate)) {
						    
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
					    } else {
					    	break;
					    }
					}
					
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
					for (int i = 0; i < metadata.getListColumns().size(); i++) {
						IMetadataColumn column = metadata.getListColumns().get(i);
						
						String colname = column.getLabel();
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				        
					    
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
					    	if (column.isNullable()) {
					    		
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_76);
    
					    	}
					    	
					    	if (javaType == JavaTypesManager.STRING) {
					    		
    stringBuffer.append(TEXT_77);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
					    	} else if (javaType == JavaTypesManager.BYTE ||
						    		   javaType == JavaTypesManager.SHORT ||
						    		   javaType == JavaTypesManager.INTEGER ||
						    		   javaType == JavaTypesManager.LONG) {
					        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
					    		
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
					    	} else if (javaType == JavaTypesManager.FLOAT ||
					    			   javaType == JavaTypesManager.DOUBLE) {
					    		String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
					    		
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
					    	}
					    	
					    	if (column.isNullable()) {
					    		
    stringBuffer.append(TEXT_123);
    
					    	}
					    
    stringBuffer.append(TEXT_124);
    
					}
					
    stringBuffer.append(TEXT_125);
    
			
			for (int i = connectionIndex + 1; i < outConnections.size(); i++) {
				IConnection connection = outConnections.get(i);
				if (connection.getLineStyle().hasConnectionCategory(
						IConnectionCategory.DATA)) {
					for (IMetadataColumn column : metadata.getListColumns()) {
						
    stringBuffer.append(TEXT_126);
    stringBuffer.append(connection.getName());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(firstOutConnection.getName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_130);
    
					}
				}
			}
		} else {
			
    stringBuffer.append(TEXT_131);
    
		}
	} else {
		
    stringBuffer.append(TEXT_132);
    
	}
} else {
	
    stringBuffer.append(TEXT_133);
    
}

    stringBuffer.append(TEXT_134);
    return stringBuffer.toString();
  }
}
