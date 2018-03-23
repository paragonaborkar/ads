package org.talend.designer.codegen.translators.elt.sqltemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;

import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSQLTemplateCommitMainJava {

  protected static String nl;
  public static synchronized TSQLTemplateCommitMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQLTemplateCommitMainJava result = new TSQLTemplateCommitMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "stmt_";
  protected final String TEXT_4 = ".close();" + NL;
  protected final String TEXT_5 = NL + "    conn_";
  protected final String TEXT_6 = ".close();";
  protected final String TEXT_7 = NL;

    public String generateSQLPatternCode(INode node) {
        String cid = node.getUniqueName();
        List<Map<String, Object>> list = (List<Map<String, Object>>) ElementParameterParser.getObjectValue(node,
                "SQLPATTERN_VALUE");

        Set<String> tableParamSet = new java.util.HashSet<String>();
        //fix bug 22221,if use hive DB,change addBatch() method to execute().
        String dbType = ElementParameterParser.getValue(node,"__DBTYPE__");
		boolean isHive=dbType.equalsIgnoreCase("HIVE");

        StringBuilder resultBuilder = new StringBuilder();
        if (list != null) {
        	int sql_id = 0;
            for (Map<String, Object> map : list) {
            	sql_id++;
                Set<String> keySet = map.keySet();
                for (String key : keySet) {
                    String SQLPattern = (String) map.get(key);
                    StringBuilder sqlPatternBuilder = new StringBuilder(SQLPattern);
                    // replace < % with \n< %
                    int position = 0;
                    int index = -1;
                    while (position < sqlPatternBuilder.length()) {
                        index = sqlPatternBuilder.indexOf("<", position);
                        if (index < 0) {
                            break;
                        }
                        if (index + 1 >= sqlPatternBuilder.length()) {
                            break;
                        }
                        if (sqlPatternBuilder.charAt(index + 1) == '%') {
                            if ((index + 2 >= sqlPatternBuilder.length()) || (sqlPatternBuilder.charAt(index + 2) != '=')) {
                                sqlPatternBuilder.insert(index, "\n");
                                position = index + 2;
                                continue;
                            }
                        }
                        position = index + 1;
                    }

                    // System.out.println("1");
                    String tempSQLPattern = sqlPatternBuilder.toString();
                    tempSQLPattern = tempSQLPattern.replaceAll("\r\n", "\n");
                    String[] lines = tempSQLPattern.split("(\\n)");
                    List<String> lineList = new ArrayList<String>();
                    StringBuilder codeStringBuilder = new StringBuilder();
                    for (String line : lines) {
                        while (line.startsWith(" ") || line.startsWith("\t") || line.startsWith("\f")) {
                            line = line.substring(1);
                        }
                        while (line.endsWith(" ") || line.endsWith("\t") || line.endsWith("\f")) {
                            line = line.substring(0, line.length() - 1);
                        }
                        if (line.length() > 0) {
                            lineList.add(line);
                        }
                    }
                    // System.out.println("2");
                    boolean jetScriptStarted = false;
                    StringBuilder sqlQueryBuilder = new StringBuilder("\"");
                    int i = 0;
                    String line = null;
                    LINES: do {
                        if (i >= lineList.size()) {
                            break;
                        }
                        if (line == null || line.length() == 0) {
                            line = lineList.get(i++);
                        }
                        if (line.startsWith("--") || line.startsWith("#")) {
                            line = null;
                            continue;
                        }

                        if (line.length() >= 2 && line.charAt(0) == '<' && line.charAt(1) == '%') {
                            if (line.length() > 2) {
                                if (line.charAt(2) != '=') {
                                    jetScriptStarted = true;
                                    line = line.substring(2).trim();
                                }
                            } else {
                                jetScriptStarted = true;
                                line = line.substring(2).trim();
                            }
                        }

                        // replace all "__XXX__" with real param value.
                        if (jetScriptStarted) {
                            StringBuilder lineBuilder = new StringBuilder(line);
                            position = 0;
                            position = lineBuilder.indexOf("__", position) + 2;
                            while (position > 0 && position < lineBuilder.length()) {
                                int indexOfEnd__ = lineBuilder.indexOf("__", position);
                                if ((indexOfEnd__ > 0) && ((indexOfEnd__ + 2) < lineBuilder.length())) {
                                    /*
                                     * all components' parameter name should match "[0-9A-Z\\-_]+"
                                     */
                                    String paramName = lineBuilder.substring(position, indexOfEnd__);
                                    if (paramName.matches("[0-9A-Z\\-_]+")) {
                                        // to see whether this is extract TABLE value sentence
                                        /*
                                         * The sentence for extract TABLE param must be in the scopce of "< %" and
                                         * "% >". And the code is something like EXTRACT(__PARAM__);
                                         */
                                        int indexEXTRACTBegin = position - 10;
                                        int indexEXTRACTEnd = indexOfEnd__ + 2;
                                        if (indexEXTRACTBegin >= 0 && indexEXTRACTEnd < lineBuilder.length()) {
                                            if (lineBuilder.substring(indexEXTRACTBegin, position).equals("EXTRACT(__")
                                                    && lineBuilder.charAt(indexEXTRACTEnd) == ')') {
                                                if (!tableParamSet.contains(paramName)) {
                                                    // modify it to merge SCHEMA(__ELT_SCHEMA__)
                                                    if (isSchemaProperty(node, paramName)) {
                                                        if (!schemaExists(node, paramName)) {
                                                            return sqlPatternExceptionCode(node, paramName, true);
                                                        }
                                                        resultBuilder.insert(0, extractSchemaValue(node, paramName));
                                                        tableParamSet.add(paramName);
                                                    } else {
                                                        if (!tableParameterExists(node, paramName)) {
                                                            return sqlPatternExceptionCode(node, paramName, false);
                                                        }
                                                        resultBuilder.insert(0, extractTableValue(node, paramName));
                                                        tableParamSet.add(paramName);
                                                    }
                                                }
                                                line = null;
                                                continue LINES;
                                            }
                                        }

                                        // to see whether this is the extracted TABLE para;
                                        boolean flag = false;
                                        for (String param : tableParamSet) {
                                            /*
                                             * caution: do not use the identical PARAMETER names among the component's
                                             * PARAMETERs.
                                             */
                                            if (paramName.startsWith(param)) {
                                                flag = true;
                                                break;
                                            }
                                        }

                                        String realValue = null;

                                        if (flag) {
                                            realValue = paramName + "_" + cid;
                                        } else {
                                            if (paramName.equals("CID")) {
                                                realValue = cid;
                                            } else {
                                                realValue = ElementParameterParser.getValue(node, "__" + paramName + "__"); // get
                                            }
                                        }
                                        // the param value
                                        int formerLength = paramName.length() + 4;
                                        int newLength = realValue.length();
                                        lineBuilder.replace(position - 2, indexOfEnd__ + 2, realValue);
                                        position = (indexOfEnd__ + 2) + (newLength - formerLength);
                                        position = lineBuilder.indexOf("__", position) + 2;
                                    } else {
                                        position = indexOfEnd__ + 2;
                                    }
                                } else {
                                    break;
                                }
                            }
                            line = lineBuilder.toString();
                        }

                        if (jetScriptStarted) {
                            int endTag = -1;
                            position = 0;
                            while (position < line.length()) {
                                index = line.indexOf("%", position);
                                if (index < 0) {
                                    break;
                                }
                                if (index + 1 >= line.length()) {
                                    break;
                                }
                                if (line.charAt(index + 1) == '>') {
                                    endTag = index;
                                    break;
                                }
                                position = index + 1;
                            }

                            // System.out.println("3");

                            if (endTag < 0) {
                                codeStringBuilder.append(line).append("\n");
                                line = null;
                            } else {
                                codeStringBuilder.append(line.substring(0, endTag)).append("\n");
                                line = line.substring(endTag + 2);
                                jetScriptStarted = false;
                            }
                        } else {
                            // repalce all " with \" for sql sentence.
                            StringBuilder lineBuilder = new StringBuilder(line);
                            index = 0;
                            position = 0;
                            OUTLOOP: while (position < lineBuilder.length()) {
                                index = lineBuilder.indexOf("\"", position);
                                if (index < 0) {
                                    break;
                                }
                                if (index > 0 && lineBuilder.charAt(index - 1) == '\\') {
                                    position = index + 1;
                                    continue;
                                }
                                char last = 0;
                                for (int j = index - 1; j >= 0; j--) {
                                    char currChar = lineBuilder.charAt(j);
                                    if (currChar == '%' && last == '>') {
                                        break;
                                    }
                                    if (currChar == '<' && last == '%') {// in region of < %= % >, skip it
                                        position = index + 1;
                                        continue OUTLOOP;
                                    }
                                    last = currChar;
                                }
                                lineBuilder.insert(index, "\\");
                                position = index + 2;
                            }
                            // System.out.println("4");
                            // lineBuilder.toString();

                            /*
                             * Caution: here, we assume all the assign script("< %=value % >") always doesn't span more
                             * than one lines; or it may generate error code.
                             */
                            // replace All "< %=" with "\" + "
                            position = 0;
                            index = 0;
                            while (position < lineBuilder.length()) {
                                index = lineBuilder.indexOf("%=", position);
                                if (index < 0) {
                                    break;
                                }
                                if ((index > 0) && (lineBuilder.charAt(index - 1) == '<')) {

                                    // replace all "__XXX__" with real param value.
                                    int position2 = index + 2;

                                    if ((position2 > 0 && position2 < lineBuilder.length())) {
                                        position2 = lineBuilder.indexOf("__", position2) + 2;
                                        while (position2 > 0) {
                                            int end = lineBuilder.indexOf("%", position2);
                                            if ((end < 0 || (end + 1 >= lineBuilder.length()) || (lineBuilder.charAt(end + 1) != '>'))) {
                                                break;
                                            }

                                            if (position2 >= end) {
                                                break;
                                            }

                                            int indexOfEnd__ = lineBuilder.indexOf("__", position2);

                                            if ((indexOfEnd__ > 0) && ((indexOfEnd__ + 2) <= end)) {
                                                String paramName = lineBuilder.substring(position2, indexOfEnd__);
                                                /* caution: all components' parameter name should match "[0-9A-Z\\-_]+" */
                                                if (paramName.matches("[0-9A-Z\\-_]+")) {

                                                    // to see whether this is the extracted TABLE para;
                                                    boolean flag = false;
                                                    for (String param : tableParamSet) {
                                                        /*
                                                         * caution: while designing the component, don't use the
                                                         * identical PARAMETER names
                                                         */
                                                        if (paramName.startsWith(param)) {
                                                            flag = true;
                                                            break;
                                                        }
                                                    }

                                                    String realValue = null;

                                                    if (flag) {
                                                        realValue = paramName + "_" + cid;
                                                    } else {
                                                        // get the param value
                                                        realValue = ElementParameterParser
                                                                .getValue(node, "__" + paramName + "__");
                                                    }
                                                    int formerLength = paramName.length() + 4;
                                                    int newLength = realValue.length();
                                                    lineBuilder.replace(position2 - 2, indexOfEnd__ + 2, realValue);
                                                    position2 = (indexOfEnd__ + 2) + (newLength - formerLength);
                                                    position2 = lineBuilder.indexOf("__", position2) + 2;
                                                } else {
                                                    position2 = indexOfEnd__ + 2;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }

                                    // matchs
                                    lineBuilder.replace(index - 1, index + 2, "\" + ");
                                    position = index + 3;
                                    continue;
                                }
                                position = index + 2;
                            }
                            // System.out.println("5");
                            // replace All "% >" with " + \""
                            position = 0;
                            index = 0;
                            while (position < lineBuilder.length()) {
                                index = lineBuilder.indexOf("%", position);
                                if (index < 0) {
                                    break;
                                }
                                if ((index + 1 < lineBuilder.length()) && (lineBuilder.charAt(index + 1) == '>')) {
                                    // matchs
                                    lineBuilder.replace(index, index + 2, " + \"");
                                    position = index + 4;
                                    continue;
                                }
                                position = index + 1;
                            }
                            // System.out.println("6");
                            line = lineBuilder.toString();

                            sqlQueryBuilder.append(line);
                            /*
                             * Caution: here, we assume that all the SQL query are end with ";" which will follows a new
                             * line("\n" or "\r\n").
                             */
                            if (line.endsWith(";")) {// end of SQL QUERY found
                                sqlQueryBuilder.append("\"");

                                // //////////////////////////////////////////////////
                                // //special code for tELTTeradataAggregate begin////
                                // //////////////////////////////////////////////////
                                position = 0;
                                position = sqlQueryBuilder.indexOf("</", position) + 2;
                                while (position > 0 && position < sqlQueryBuilder.length()) {
                                    int indexOfEnd = sqlQueryBuilder.indexOf("/>", position);
                                    if ((indexOfEnd > 0) && ((indexOfEnd + 2) < sqlQueryBuilder.length())) {
                                        /*
                                         * all components' parameter name should match "[0-9A-Z\\-_]+"
                                         */
                                        String paramName = sqlQueryBuilder.substring(position, indexOfEnd);
                                        if (paramName.matches("[0-9A-Z\\-_]+")) {
                                            String realValue = "";
                                            if (paramName.startsWith("SCHEMA")) {
                                                // ......
                                                // get the SCHEMA value
                                                List<IMetadataColumn> schemaValue = getColumnList(node, paramName);

                                                int size = 0;
                                                if (schemaValue != null) {
                                                    size = schemaValue.size();
                                                }

                                                for (int ii = 0; ii < size; ii++) {
                                                    IMetadataColumn column = schemaValue.get(ii);
                                                    if (ii != 0) {
                                                        realValue += ", ";
                                                    }
                                                    realValue += column.getLabel();
                                                }

                                            } else if (paramName.equals("OPERATION")) {
                                                if (!tableParameterExists(node, paramName)) {
                                                    return sqlPatternExceptionCode(node, paramName, false);
                                                }
                                                // get the OPERATION table value
                                                List<Map<String, String>> operationTableValue = (List<Map<String, String>>) ElementParameterParser
                                                        .getObjectValue(node, "__OPERATION__");

                                                for (int ii = 0; ii < operationTableValue.size(); ii++) {
                                                    Map<String, String> operationMap = operationTableValue.get(ii);
                                                    if (ii != 0) {
                                                        realValue += ", ";
                                                    }
                                                    realValue += (operationMap.get("FUNCTION") + "("
                                                            + operationMap.get("INPUT_COLUMN") + ")");
                                                }

                                            } else if (paramName.equals("GROUPBY")) {
                                                if (!tableParameterExists(node, paramName)) {
                                                    return sqlPatternExceptionCode(node, paramName, false);
                                                }
                                                // get the OPERATION table value
                                                List<Map<String, String>> groupbyTableValue = (List<Map<String, String>>) ElementParameterParser
                                                        .getObjectValue(node, "__GROUPBY__");

                                                for (int ii = 0; ii < groupbyTableValue.size(); ii++) {
                                                    Map<String, String> operationMap = groupbyTableValue.get(ii);
                                                    if (ii != 0) {
                                                        realValue += ", ";
                                                    }
                                                    realValue += operationMap.get("INPUT_COLUMN");
                                                }
                                            } else {
                                                // get the param value
                                                realValue = ElementParameterParser.getValue(node, "__" + paramName + "__");
                                                realValue = "\" + " + realValue + " + \"";
                                            }

                                            int formerLength = paramName.length() + 4;
                                            int newLength = realValue.length();
                                            sqlQueryBuilder.replace(position - 2, indexOfEnd + 2, realValue);
                                            position = (indexOfEnd + 2) + (newLength - formerLength);
                                        }
                                        position = sqlQueryBuilder.indexOf("</", position) + 2;

                                    } else {
                                        break;
                                    }
                                }
                                // //////////////////////////////////////////////////
                                // //special code for tELTTeradataAggregate end//////
                                // //////////////////////////////////////////////////

                                String sqlSentence = sqlQueryBuilder.toString();
                                if(sqlSentence.length() > 2){
                                    sqlSentence = sqlSentence.substring(0, sqlSentence.length() - 2);
                                    sqlSentence += "\"";
                                }
                                codeStringBuilder.append("String tempSQLSentence_").append(cid).append("_"+sql_id).append(" = ").append(sqlSentence).append(";\n");
                                codeStringBuilder.append("globalMap.put(\"").append(cid).append("_QUERY\", tempSQLSentence_").append(cid).append("_"+sql_id).append(");\n");
                                //fix bug 22221,if use hive DB,change addBatch() method to execute().
                                if(!isHive){
									codeStringBuilder.append("stmt_").append(cid).append(".addBatch(tempSQLSentence_").append(cid).append("_"+sql_id).append(");\n");
				                }else{
									codeStringBuilder.append("stmt_").append(cid).append(".execute(tempSQLSentence_").append(cid).append("_"+sql_id).append(");\n");
								}
                                sqlQueryBuilder.delete(0, sqlQueryBuilder.length()).append("\"");
                            } else {
                                sqlQueryBuilder.append(" ");
                            }
                            line = null;
                        }
                    } while (true);
                    //fix bug 22221,if use hive DB,do not use clearBatch() and executeBatch(),because the hive jar doesn't support these methods.
                    if(!isHive){
						resultBuilder.append("//execute sqlPattern: ").append(key).append("\nstmt_").append(cid).append(".clearBatch();\n");
					    resultBuilder.append(codeStringBuilder.toString()).append("\nstmt_").append(cid).append(".executeBatch();\n");
				    }else{
						resultBuilder.append(codeStringBuilder.toString());
				    }
                }
            }
        }
        return resultBuilder.toString();

    }

    private String extractTableValue(INode node, String param) {
        String cid = node.getUniqueName();
        StringBuilder resultBuilder = new StringBuilder();

        // get the table param value
        List<Map<String, String>> tableValue = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__"
                + param + "__");
        /* get table size value, use: __PARAM_LENGTH__ */
        resultBuilder.append("int ").append(param).append("_LENGTH_").append(cid).append(" = ").append(tableValue.size()).append(
                ";\n");
        if (tableValue.size() > 0) {
            Set<String> keySet = tableValue.get(0).keySet();
            for (String key : keySet) {
                /* get table item value, use: __PARAM_COLUMN__[i] */
                resultBuilder.append("String[] ").append(param).append("_").append(key).append("_").append(cid).append(
                        " = new String[").append(tableValue.size()).append("];\n");
            }

            for (int i = 0; i < tableValue.size(); i++) {
                Map<String, String> map = tableValue.get(i);
                Set<String> set = map.keySet();
                for (String key : set) {
                    resultBuilder.append(param).append("_").append(key).append("_").append(cid).append("[").append(i).append(
                            "] = ");

                    String value = map.get(key);
                    /* Info: int values in TABLE will be generated as String too. */
                    if (!value.startsWith("\"")) {
                        resultBuilder.append("\"");
                    }
                    resultBuilder.append(value);
                    if (!value.endsWith("\"")) {
                        resultBuilder.append("\"");
                    }
                    resultBuilder.append(";\n");
                }
            }

        }

        return resultBuilder.toString();
    }

    private boolean isSchemaProperty(INode node, String param) {
        if (node.getMetadataFromConnector(param) != null) {
            return true;
        }
        // default schema can be with name SCHEMA_SOURCE or SCHEMA
        if (param.equals("SCHEMA") || param.equals("SCHEMA_SOURCE")) {
            return true;
        }
        return false;
    }

    private String extractSchemaValue(INode node, String param) {
        String cid = node.getUniqueName();
        StringBuilder resultBuilder = new StringBuilder();

        // get the SCHEMA value
        List<IMetadataColumn> schemaValue = getColumnList(node, param);

        resultBuilder.append("class ").append(param).append("_struct_").append(cid).append(
                "{ \nString name;\nString dbType;\nboolean isKey;\nInteger length;\nInteger pricision;\nboolean nullable;\n}\n");

        int size = 0;
        if (schemaValue != null) {
            size = schemaValue.size();
        }
        resultBuilder.append(param).append("_struct_").append(cid).append("[] ").append(param).append("_").append(cid).append(
                " = new ").append(param).append("_struct_").append(cid).append(" [").append(size).append("];\n");

        resultBuilder.append("String[] ").append(param).append("_NAME_").append(cid).append(" = new String[").append(size)
                .append("];\n");
        resultBuilder.append("String[] ").append(param).append("_DBTYPE_").append(cid).append(" = new String[").append(size)
                .append("];\n");
        resultBuilder.append("String[] ").append(param).append("_ISKEY_").append(cid).append(" = new String[").append(size)
                .append("];\n");
        resultBuilder.append("String[] ").append(param).append("_LENGTH_").append(cid).append(" = new String[").append(size)
                .append("];\n");
        resultBuilder.append("String[] ").append(param).append("_NULLABLE_").append(cid).append(" = new String[").append(size)
                .append("];\n");
        resultBuilder.append("String[] ").append(param).append("_PRECISION_").append(cid).append(" = new String[").append(size)
                .append("];\n");
        for (int i = 0; i < size; i++) {
            IMetadataColumn column = schemaValue.get(i);
            resultBuilder.append(param).append("_").append(cid).append("[").append(i).append("] = new ").append(param).append(
                    "_struct_").append(cid).append("();\n");
            resultBuilder.append(param).append("_").append(cid).append("[").append(i).append("].name = ").append("\"").append(
                    column.getLabel()).append("\";\n");
            resultBuilder.append(param).append("_").append(cid).append("[").append(i).append("].dbType = ").append("\"").append(
                    column.getType()).append("\";\n");
            resultBuilder.append(param).append("_").append(cid).append("[").append(i).append("].isKey = ").append(column.isKey())
                    .append(";\n");
            resultBuilder.append(param).append("_").append(cid).append("[").append(i).append("].length = ").append(
                    column.getLength()).append(";\n");
            resultBuilder.append(param).append("_").append(cid).append("[").append(i).append("].pricision = ").append(
                    column.getPrecision()).append(";\n");
            resultBuilder.append(param).append("_").append(cid).append("[").append(i).append("].nullable = ").append(
                    column.isNullable()).append(";\n");
            resultBuilder.append(param).append("_NAME_").append(cid).append("[").append(i).append("] = ").append("\"").append(
                    column.getLabel()).append("\";\n");
            resultBuilder.append(param).append("_DBTYPE_").append(cid).append("[").append(i).append("] = ").append("\"").append(
                    column.getType()).append("\";\n");
            resultBuilder.append(param).append("_ISKEY_").append(cid).append("[").append(i).append("] = ").append("\"").append(
                    column.isKey()).append("\";\n");
            resultBuilder.append(param).append("_LENGTH_").append(cid).append("[").append(i).append("] = ").append("\"").append(
                    column.getLength()).append("\";\n");
            resultBuilder.append(param).append("_PRECISION_").append(cid).append("[").append(i).append("] = ").append("\"")
                    .append(column.getPrecision()).append("\";\n");
            resultBuilder.append(param).append("_NULLABLE_").append(cid).append("[").append(i).append("] = ").append("\"")
                    .append(column.isNullable()).append("\";\n");
        }

        return resultBuilder.toString();
    }

    private List<IMetadataColumn> getColumnList(INode node, String param) {
        IMetadataTable metadata = null;
        List<IMetadataColumn> columnList = null;
        metadata = node.getMetadataFromConnector(param);
        if (metadata == null) {
            List<IMetadataTable> metadatas = node.getMetadataList();
            if (metadatas != null && metadatas.size() > 0) {
                metadata = metadatas.get(0);
            }
        }
        if (metadata != null) {
            columnList = metadata.getListColumns();
        }
        return columnList;
    }

    private String sqlPatternExceptionCode(INode node, String param, boolean isSchema) {
        if (isSchema) {
            return "if(true){\ntry{\nthrow new Exception(\"Error! Schema with name '" + param + "' doesn't exist in component "
                    + node.getComponent().getName() + ". Maybe you are using a sqlpattern that isn't applicable in "
                    + node.getUniqueName() + ", or maybe you didn't specify the required schema in the component.\");\n}catch(Exception e){\ne.printStackTrace();}\n}";
        } else {
            return "if(true){\ntry{\nthrow new Exception(\"Error! TABLE parameter '__" + param + "__' doesn't exist in component "
                    + node.getComponent().getName() + ". Maybe you are using a sqlpattern that isn't applicable in "
                    + node.getUniqueName() + ".\");\n}catch(Exception e){\ne.printStackTrace();}\n}";
        }
    }

    private boolean tableParameterExists(INode node, String param) {
        return ElementParameterParser.getObjectValue(node, "__" + param + "__") != null;
    }

    private boolean schemaExists(INode node, String param) {
        return getColumnList(node, param) != null;
    }

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
boolean close = ("true").equals(ElementParameterParser.getValue(node,"__CLOSE__"));


    stringBuffer.append(TEXT_2);
    stringBuffer.append(generateSQLPatternCode(node) );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
      if(close){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
     }
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
