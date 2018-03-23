package org.talend.designer.codegen.translators.business.microsoft_crm;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TMicrosoftCrmInputEndJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmInputEndJava result = new TMicrosoftCrmInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                    }" + NL + "                    // Entity For Loop end but moved to the end part" + NL + "                    if (fetchMore_";
  protected final String TEXT_3 = ") {" + NL + "                        pageNumber_";
  protected final String TEXT_4 = "++;" + NL + "                        pagingInfo_";
  protected final String TEXT_5 = ".setPageNumber(pageNumber_";
  protected final String TEXT_6 = ");" + NL + "                        pagingInfo_";
  protected final String TEXT_7 = ".setPagingCookie(pagingCookie_";
  protected final String TEXT_8 = ");" + NL + "                        queryExp_";
  protected final String TEXT_9 = ".setPageInfo(pagingInfo_";
  protected final String TEXT_10 = ");" + NL + "                    }" + NL + "}";
  protected final String TEXT_11 = NL + "    \t\t\t\t}" + NL + "    \t\t\t\t// Gets the next page link if exists." + NL + "    \t\t\t\tif (clientEntitySet_";
  protected final String TEXT_12 = ".getNext() != null) {" + NL + "                nextPageURI_";
  protected final String TEXT_13 = " = clientEntitySet_";
  protected final String TEXT_14 = ".getNext();" + NL + "\t            } else {" + NL + "\t                break;" + NL + "\t            }" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "    \t\t\t\t}" + NL + "    \t\t\t\tif(fetchMore_";
  protected final String TEXT_16 = "){" + NL + "\t                    pageNumber_";
  protected final String TEXT_17 = "++;" + NL + "\t                    pagingInfo_";
  protected final String TEXT_18 = ".setPageNumber(pageNumber_";
  protected final String TEXT_19 = ");" + NL + "\t                    pagingInfo_";
  protected final String TEXT_20 = ".setPagingCookie(pagingCookie_";
  protected final String TEXT_21 = ");" + NL + "\t                    query_";
  protected final String TEXT_22 = ".setPageInfo(pagingInfo_";
  protected final String TEXT_23 = ");" + NL + "\t                    rmr_";
  protected final String TEXT_24 = ".setQuery(query_";
  protected final String TEXT_25 = ");" + NL + "\t                    execute_";
  protected final String TEXT_26 = ".setRequest(rmr_";
  protected final String TEXT_27 = ");" + NL + "\t        \t\t\texecuteDoc_";
  protected final String TEXT_28 = ".setExecute(execute_";
  protected final String TEXT_29 = ");" + NL + "\t        \t\t\texecuteDoc_";
  protected final String TEXT_30 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory.parse(executeDoc_";
  protected final String TEXT_31 = ".toString());" + NL + "        \t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (!retrieveMultipleResult_";
  protected final String TEXT_33 = ".getMoreRecords()) {" + NL + "\t\t                break;" + NL + "\t\t            }" + NL + "\t\t            pagingInfo_";
  protected final String TEXT_34 = ".setPagingCookie(retrieveMultipleResult_";
  protected final String TEXT_35 = ".getPagingCookie());" + NL + "\t\t            pagingInfo_";
  protected final String TEXT_36 = ".setPageNumber(++pageNumber_";
  protected final String TEXT_37 = ");" + NL + "\t\t            query_";
  protected final String TEXT_38 = ".setPageInfo(pagingInfo_";
  protected final String TEXT_39 = ");" + NL + "\t\t        }" + NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_41 = "_NB_LINE\",nb_line_";
  protected final String TEXT_42 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    String authenticationType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
    String crmVersion = ElementParameterParser.getValue(node, "__MS_CRM_VERSION__");

    boolean isMsCrm2015OnPremise = "ON_PREMISE".equals(authenticationType) && "CRM_2015".equals(crmVersion);

    if(isMsCrm2015OnPremise){
       
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
    }else{
    	  String crmOnlineVersion = ElementParameterParser.getValue(node, "__API_VERSION__");
        boolean isOnline2016WithOdata="ONLINE".equals(authenticationType) && "API_2016_ODATA".equals(crmOnlineVersion);
    	  if(isOnline2016WithOdata){
    	  
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);

	if (metadata != null) {
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();

		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){

			IConnection outgoingConn = outgoingConns.get(0);

			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}
		}
	}
}

    
    	  }else{
        
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);

	if (metadata != null) {
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();

		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){

			IConnection outgoingConn = outgoingConns.get(0);

			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
				boolean isAPI2011 = ("API_2011").equals(ElementParameterParser.getValue(node,"__API_VERSION__"));
				String discWSDL = ElementParameterParser.getValue(node, "__DISC_WSDL__");
				if(!isAPI2011 || ("ON_PREMISE").equals(authType)){
				
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
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
    
				}else{
				
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
    
				}
			}
		}
	}
}

    
        }
    }

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    return stringBuffer.toString();
  }
}
