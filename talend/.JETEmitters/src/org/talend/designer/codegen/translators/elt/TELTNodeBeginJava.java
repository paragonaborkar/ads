package org.talend.designer.codegen.translators.elt;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IElementParameter;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;
import java.util.Collection;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TELTNodeBeginJava
{
  protected static String nl;
  public static synchronized TELTNodeBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTNodeBeginJava result = new TELTNodeBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\tSystem.out.println(\"this is code from tELTNode\");" + NL + "\t\tSystem.out.println(\"";
  protected final String TEXT_3 = "\");" + NL + "\t\tSystem.out.println(\"";
  protected final String TEXT_4 = "\");" + NL + "\t\tSystem.out.println(\"";
  protected final String TEXT_5 = "\");" + NL + "\t\tSystem.out.println(\"";
  protected final String TEXT_6 = "\");" + NL + "\t";
  protected final String TEXT_7 = NL + NL + "\t";
  protected final String TEXT_8 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_9 = " = null;" + NL + "\tconn_";
  protected final String TEXT_10 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_11 = "\");" + NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_12 = " = conn_";
  protected final String TEXT_13 = ".createStatement();" + NL + "\tString sql_";
  protected final String TEXT_14 = " = null;" + NL + "\tsql_";
  protected final String TEXT_15 = " = \"";
  protected final String TEXT_16 = "\";" + NL + "\tint ret_";
  protected final String TEXT_17 = " = stmt_";
  protected final String TEXT_18 = ".executeUpdate(sql_";
  protected final String TEXT_19 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_20 = "_QUERY\", sql_";
  protected final String TEXT_21 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_22 = "_NB_LINE\", ret_";
  protected final String TEXT_23 = ");" + NL + "\t";
  protected final String TEXT_24 = NL + "\tthrow new java.lang.Exception(\"";
  protected final String TEXT_25 = "\");" + NL + "\t";
  protected final String TEXT_26 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();


	
	/**
	 * @author Parham Parvizi (pparvizi@talend.com)
	 * @date 2011-02-12 (love day!)
	 */
	final class SQL {
		public List<HashMap<String,String>> has;
		public List<HashMap<String,String>> needs;
		
			
		SQL() {
			has = new ArrayList<HashMap<String,String>>(10);
			needs = new ArrayList<HashMap<String,String>>(10);
		}
		
		
		/**
		 * this functions returns a property item (HashMap<String,String) within 
		 * the has list that has the matching type and name to the parameters that
		 * are passed.
		 * @param type the type value to look for.
		 * @param name the name value to look for.
		 * @return HashMap<String,String> the is has the matching type and name within the has list. otherwise null.
		 */
		public HashMap<String,String> getHasProperty(String type, String name) {
			return getPropertyElement(has, type, name);
		}
		
		
		/**
		 * this functions returns a property item (HashMap<String,String) within 
		 * the needs list that has the matching type and name to the parameters that
		 * are passed.
		 * @param type the type value to look for.
		 * @param name the name value to look for.
		 * @return HashMap<String,String> the is has the matching type and name within the needs list. otherwise null.
		 */
		public HashMap<String,String> getNeedsProperty(String type, String name) {
			return getPropertyElement(needs, type, name);
		}
		
		/**
		 * this function searches through the list parameter for an item that has both 
		 * a 'type' and a 'name' element(key) in the Map collection. further the value of the 
		 * type and name in the Map must match the value of type and name parameter. if such 
		 * condition exists; then the Map item is returned.
		 * This function is mostly used to find a particular property item inside the has or needs list.
		 * @param list a List of Map<String,String>. each map must have a 'type' and 'name' element(key).
		 * @param type the value for the type to search for within the list.
		 * @param name the value for name to search for within the list.
		 * @return the item that type and name matches the parameter values.
		 */
		public HashMap<String,String> getPropertyElement(List<HashMap<String, String>> list, String type, String name) {
			if (list != null) {
				for (HashMap<String,String> item : list) {
					if (item.containsKey("type") && item.containsKey("name")) {
						boolean typeFlag = (type == null) ? true : (type.equals(item.get("type")) ? true : false);
						boolean nameFlag = (name == null) ? true : (name.equals(item.get("name")) ? true : false);
						if (typeFlag && nameFlag)
							return item;
					}
				}
			}
			return null;
		}
		
		public void removePropertyElement(List<HashMap<String, String>> list, String type, String name) {
			if (list != null) {
				for (int i=0; i < list.size(); i++) {
					HashMap<String,String> item = list.get(i);
					if (item.containsKey("type") && item.containsKey("name")) {
						boolean typeFlag = (type == null) ? true : (type.equals(item.get("type")) ? true : false);
						boolean nameFlag = (name == null) ? true : (name.equals(item.get("name")) ? true : false);
						if (typeFlag && nameFlag) {
							list.remove(i);
							return;
						}
					}
				}
			}
		}
		
		public HashMap<String,String> createPropertyElement(List<HashMap<String, String>> list, String type, String name) {
			HashMap<String,String> tmp = getPropertyElement(list, type, name);
			if (tmp == null) {	 // don't ever create a property that already exists
				tmp = new HashMap<String, String>(10);
				tmp.put("type", type);
				tmp.put("name", name);
				list.add(tmp);
			}
			return tmp;
		}
		
		
		public String getPropertyValue(List<HashMap<String, String>> list, String type, String name, String key) {
			HashMap<String,String> tmp = getPropertyElement(list, type, name);
			if (tmp != null && tmp.containsKey(key))
				return tmp.get(key);
			else
				return null;
		}
		
		public void setPropertyValue(List<HashMap<String, String>> list, String type, String name, String key, String value) {
			// get the correct property element (type,name); otherwise create a new one
			HashMap<String,String> tmp = createPropertyElement(list, type, name);
			tmp.put(key, value);			
		}
		
		public void removeProperty(List<HashMap<String, String>> list, String type, String name, String key) {
			HashMap<String,String> tmp = getPropertyElement(list, type, name);
			if (tmp != null && tmp.containsKey(key))
				tmp.remove(key);
		}
		
		private HashMap<String,String> createEmptyPropertyElement(List<HashMap<String, String>> list, String type, String name) {
			HashMap<String,String> tmp = getPropertyElement(list, type, name);
			if (tmp == null) {	 // don't ever create a property that already exists
				tmp = new HashMap<String, String>(10);
				tmp.put("type", type);
				tmp.put("name", name);
				list.add(tmp);
			}
			return tmp;
		}
		
		public String toString() {
			String ret = "";
			if (needs != null) {
				ret += "needs elements:\\n";
				for (HashMap<String,String> e : needs) {
					Iterator<String> it = e.keySet().iterator();
					while (it.hasNext()) {
						String key = it.next();
						ret += "\\t" + key + "=" + e.get(key) + "\\n"; 
					}
				}
			}
			if (has != null) {
				ret += "has elements:\\n";
				for (HashMap<String,String> e : has) {
					Iterator<String> it = e.keySet().iterator();
					while (it.hasNext()) {
						String key = it.next();
						ret += "\\t" + key + "=" + e.get(key) + "\\n"; 
					}
				}
			}
			return ret;
		}
	}
	
	
	/**
	 * @author Administrator
	 *
	 */
	abstract class ELTNode {
		//public INode node = null;
		public String nodeName = null;
		public List<ELTNode> inputNodes = new ArrayList<ELTNode>(6);
		public List<ELTNode> outputNodes = new ArrayList<ELTNode>(6);
		public ELTNode mainInputNode = null;
		public ELTNode mainOutputNode = null;
		public int maxNumberOfInputNodes = -1;
		public int maxNumberOfOutputNodes = -1;
		public List<IMetadataColumn> columns = new ArrayList<IMetadataColumn>(50);
		public List<String> columnNames = new ArrayList<String>(50);
		public Collection<IElementParameter> parameters;
		
		
		private String dbType = null;
		
		public void setDbType(String dbType){
			this.dbType = dbType;
		}
		
		protected String translatetoString(String map,Map<String,Object> operation,String type){
			String value = operation.get(type).toString();
			IElementParameter opeParam =   getParameterByName(map);
			if(!value.matches("^\\d+$")) {
				return value;
			}
			for (int i = 0; i < opeParam.getListItemsDisplayCodeName().length; i++) {
				IElementParameter tmpParam = (IElementParameter) opeParam.getListItemsValue()[i];
				if(tmpParam!=null&&tmpParam.getName().equals(type)){
					int intValue = Integer.parseInt((String) value);
					if (tmpParam.getListItemsValue().length == 0) {
						value = ""; 
					} else {
						value = (String) tmpParam.getListItemsValue()[(Integer) intValue];
					}
				}
			}
			return value.toString();
		}

        protected String getProtectedChar() {
        	if(dbType==null){
        		return "";
        	} else if("MYSQL".equals(dbType)){
        		return "`";
        	}
        	String[] array_types = new String[]{"DB2","GREENPLUM","POSTGRE","POSTGREPLUS","PARACCEL","INGRES","SQLITE","TERADATA","INTERBASE"};
        	for(String db :array_types){
        		if(db.equals(dbType)){
        			return "\\\"";
        		}
        	}
        	return "";
        }
        protected String getLProtectedChar() {
        	if("MSSQL".equals(dbType)){
        		return "[";
        	} else {
        		return getProtectedChar();
        	}
        }
        protected String getRProtectedChar() {
        	if("MSSQL".equals(dbType)){
        		return "]";
        	} else {
        		return getProtectedChar();
        	}
        }
		
		public abstract String run(SQL sql) throws java.lang.Exception;
		
		/**
		 * only constructor. the layout node must be able to refer to the
		 * actual talend node that's initiated from. therefore it's necessary
		 * to initialize the layout given the talend unique node name.
		 * @param name
		 */
		public ELTNode(String name) {
			nodeName = name;
		}
		
		/**
		 * return the node name. it's a unique name within a talend job.
		 * @return {@link String}
		 */
		public String getNodeName() {
			return nodeName;
		}

		/**
		 * this function returns an {@link IElementParameter} that corresponds to the 
		 * parameter name given to the function.
		 * @param name
		 * @return {@link IElementParameter}
		 */
		public IElementParameter getParameterByName(String name) {
			if (name == null || "".equals(name))
				return null;
			for (IElementParameter parameter : parameters) {
				if (name.equals(parameter.getName()))
					return parameter;
			}
			return null;
		}
		
		/**
		 * this function returns the number of components that are connected
		 * before this component in the tree.
		 * @return int (number of components connected to this)
		 */
		public int depth() {
			if (previous() == null)
				return 0;
			else
				return 1 + previous().depth();
		}
		
		/**
		 * this an {@link String} containing a list of all the columns in the schema
		 * separated by the separator.
		 * @param separator to separate the list by
		 * @return
		 */
		public String getColumnList(String separator) {
			return getColumnList(separator, null);
		}
		
		/**
		 * this an {@link String} containing a list of all the columns in the schema
		 * separated by the separator and prefixed with the alias.
		 * @param separator to separate the list by
		 * @param alias prefix the columns with alias name
		 * @return {@link String}: list of columns
		 */
		public String getColumnList(String separator, String alias) {
			if (columns != null && columns.size() > 0) {
				String str = "";
				for (int i=0; i < columns.size(); i++) {
					if (i == (columns.size()-1))
						str += (alias == null ? "" : alias + ".") + getLProtectedChar() + columns.get(i).getLabel() + getRProtectedChar();
					else
						str += (alias == null ? "" : alias + ".") + getLProtectedChar() + columns.get(i).getLabel() + getRProtectedChar() + separator;
				}
				return str;
			}
			else
				return "";
		}
		
		
		/**
		 * this function adds a connection to the front of this component.
		 * @param connectingNode
		 */
		public void addInputNode(ELTNode connectingNode) {
			if (connectingNode == null || connectingNode.getNodeName() == null)
				return;
			if (connectingNode.equals(this))
				return;
			if (inputNodes == null)
				inputNodes = new ArrayList<ELTNode>(6);
			if (maxNumberOfInputNodes < 0 || maxNumberOfInputNodes > inputNodes.size()) {
				// check to see if the connecting components is not already 
				// in the inputConns
				for (ELTNode n : inputNodes)
					if (n.equals(connectingNode))
						return;
				// add the node into the input conns
				inputNodes.add(connectingNode);
				// if this is the primary input conn (first input conn) then set
				// the connectingNode as the maininputconn and first()
				if (mainInputNode == null || inputNodes.size() == 1)
					mainInputNode = connectingNode;
				// check the connectingNode and add this node to it's output conns
				connectingNode.addOutputNode(this);
			}
		}
		
		/**
		 * this function adds a connection to the end of this component.
		 * @param connectingNode
		 */
		public void addOutputNode(ELTNode connectingNode) {
			if (connectingNode == null || connectingNode.getNodeName() == null)
				return;
			if (connectingNode.equals(this))
				return;
			if (outputNodes == null)
				outputNodes = new ArrayList<ELTNode>(6);
			if (maxNumberOfOutputNodes < 0 || maxNumberOfOutputNodes < outputNodes.size()) {
				// check to see if the connecting components is not already in the outputConns
				for (ELTNode n : outputNodes)
					if (n.equals(connectingNode))
						return;
				// add the node into the outputConns
				outputNodes.add(connectingNode);
				// if this is the primary output conn (first output conn) then set
				// the connectingNode as the mainoutputconn and next()
				if (mainOutputNode == null || outputNodes.size() == 1)
					mainOutputNode = connectingNode;
				// check the connectingNode and add this node to it's input conns
				connectingNode.addInputNode(this);
			}
		}

		/**
		 * this function removes the connectingNode from the list of this component's
		 * inputConns. if the connectingNode is also identified as the main input conn,
		 * it's removed from mainInputConn.
		 * @param connectingNode
		 */
		public void deleteInputNode(ELTNode connectingNode) {
			if (connectingNode == null || connectingNode.getNodeName() == null)
				return;
			if (connectingNode.equals(this))
				return;
			if (inputNodes == null || inputNodes.size() == 0)
				return;
			// search through the inputConns and remove the connecting node
			for (ELTNode n : inputNodes) {
				if (n.equals(connectingNode)) {
					// remove from the inputConns list
					inputNodes.remove(connectingNode);
					// if this connection was the main connection, or if the inputConns
					// is empty now, then clear the main connection. otherwise set the 
					// mainInputConn to the next node in the inputConns.
					if (inputNodes.size() == 0)
						mainInputNode = null;
					else if (mainInputNode.equals(connectingNode))
						mainInputNode = inputNodes.get(0);
					// remove this component from the outputConns of the connectingNode
					connectingNode.deleteOutputNode(this);
				}
			}
		}
		
		
		/**
		 * this function removes the connectingNode from the list of this component's
		 * outputConns. if the connectingNode is also identified as the main output conn,
		 * it's removed from mainOutputConn.
		 * @param connectingNode
		 */
		public void deleteOutputNode(ELTNode connectingNode) {
			if (connectingNode == null || connectingNode.getNodeName() == null)
				return;
			if (connectingNode.equals(this))
				return;
			if (outputNodes == null || outputNodes.size() == 0)
				return;
			// search through the inputConns and remove the connecting node
			for (ELTNode n : outputNodes) {
				if (n.equals(connectingNode)) {
					// remove from the outputConns list
					outputNodes.remove(connectingNode);
					// if this connection was the main connection, or if the outputConns
					// is empty now, then clear the main connection. otherwise set the 
					// mainOutputConn to the next node in the outputConns.
					if (outputNodes.size() == 0)
						mainOutputNode = null;
					else if (mainOutputNode.equals(connectingNode))
						mainOutputNode = outputNodes.get(0);
					// remove this node from the inputConns of the connectingNode
					connectingNode.deleteInputNode(this);
				}
			}
		}
		
		/** 
		 * this function returns the main components that's connected before
		 * this component in the job design. the main input connection of this
		 * component.
		 * @return ELTNode
		 */
		public ELTNode previous() {
			return mainInputNode;
		}
		
		/** 
		 * this function returns the main components that's connected after
		 * this component in the job design. the main output connection of 
		 * this component.
		 * @return ELTNode
		 */
		public ELTNode next() {
			return mainOutputNode;
		}
		
		
		/**
		 * to check if 2 ELTNodes are equals we must check if their INodes
		 * have the same unique name. if so then return true. otherwise return
		 * false
		 * @param node: comparing node
		 * @return boolean: returns true if node and this node have the same unique name.
		 */
		public boolean equals(ELTNode node) {
			if (this.getNodeName() == null)
				return false;
			if (this.getNodeName().equals(node.getNodeName()))
				return true;
			return false;
		}

	}
	
	
	/**
	 * 
	 * @author pparvizi
	 * @since 2011-01-26
	 *
	 */
	final class ELTNodeInsert extends ELTNode {
		
		public ELTNodeInsert(String name) {
			super(name);
		}
		
		protected String getTable() {
			String ret = "";
			String schema = (String)getParameterByName("SCHEMA_NAME").getValue();
			String table = (String)getParameterByName("TABLE_NAME").getValue();
			if (schema == null || schema.equals("") || schema.equals("\"\""))
				ret = getLProtectedChar() + "\" + " + table + " + \"" + getRProtectedChar();
			else
				ret = getLProtectedChar() + "\" + " + schema + " + \"" + getRProtectedChar()+"."+getLProtectedChar()+"\" + "+ table + " + \"" + getRProtectedChar();
			return ret;
		}
		
		private void addColumnsToSQL(SQL sql) {
			int i=1;
			for (IMetadataColumn column : columns) {
				sql.createPropertyElement(sql.needs, "column", column.getLabel());
				sql.setPropertyValue(sql.needs, "column", column.getLabel(), "order", String.valueOf(i++));
				sql.setPropertyValue(sql.needs, "column", column.getLabel(), "physical-name", column.getLabel());
				//sql.setPropertyValue(sql.needs, "column", column.getLabel(), "alias-name", column.getLabel());
			}
		}
		
		public String run(SQL sql) throws java.lang.Exception {
			if (this.previous() == null)
				return "";
			else if (columns == null || columns.size() == 0)
				return "";
			else {
				addColumnsToSQL(sql);
				return "INSERT INTO " + getTable() + " (" + getColumnList(", ") + ") " + previous().run(sql);
			}
		}
	}
	

	
	/**
	 * 
	 * @author pparvizi
	 * @since 2011-01-26
	 *
	 */
	final class ELTNodeFilter extends ELTNode {
		
		public ELTNodeFilter(String name) {
			super(name);
		}
		
		/**
		 * this function returns the SQL code that represents the SQL condition
		 * configured in the parameter.
		 * for example the output would be: " (Column1 = 'value1') AND (Column2 LIKE 'value2%')"
		 * @return
		 */
		protected String getCondition() {
			String logicalOperator = (String)(getParameterByName("LOGICAL_OP").getValue());
			List<Map<String,Object>> conditions = (List<Map<String,Object>>)getParameterByName("CONDITIONS").getValue();
			String advancedCondition = (String)(getParameterByName("ADVANCED_COND").getValue());
			Boolean hasBasicConditions = conditions.size() > 0 ? true : false;
			Boolean hasAdvancedConditions = (Boolean)getParameterByName("USE_ADVANCED").getValue();
			String ret = "";
			boolean firstCondFlag = true;
			if (hasBasicConditions) {
				for (Map<String,Object> cond : conditions) {
					String column = getLProtectedChar() + translatetoString("CONDITIONS",cond,"INPUT_COLUMN") + getRProtectedChar();
					String operator = cond.get("OPERATOR").toString();
					String value = cond.get("RVALUE").toString();
					String negate = cond.get("NEGATE").toString();
					if (column != null && value != null && !value.equals("")) {
						String tmp = String.format(" (%1s %2s \" + %3s + \") ", column, operator, value);
						if (negate.equals("true"))
							tmp = " (NOT" + tmp + ") ";
						if (firstCondFlag)
							ret += tmp;
						else
							ret += logicalOperator + tmp;
						firstCondFlag = false;
					}
				}
			}
			if (hasAdvancedConditions) {
				if (firstCondFlag)
					ret += " (\" + " + advancedCondition + " + \") ";
				else
					ret += " " + logicalOperator + " (\" + " + advancedCondition + " + \") ";
			}
			return ret;
		}
		
		public String run(SQL sql) throws java.lang.Exception {
			if (this.previous() == null)
				throw new java.lang.Exception("ELTFilter must have an input connection.");
			else if (columns == null || columns.size() == 0)
				return "";
			else {
				
				return previous().run(sql) + " WHERE " + getCondition();
			}
		}
	}
	
	
	/**
	 * 
	 * @author pparvizi
	 * @since 2011-01-26
	 *
	 */
	final class ELTNodeAggregate extends ELTNode {
		
		public ELTNodeAggregate(String name) {
			super(name);
		}
		
		/**
		 * this function returns the SQL code that represents the GROUP BY 
		 * operation configured in this component.
		 * for example the output would be: " (Column1 = 'value1') AND (Column2 LIKE 'value2%')"
		 * @return
		 */
		protected String getGroupBy() {
			List<Map<String,Object>> groupbys = (List<Map<String,Object>>)getParameterByName("GROUPBYS").getValue();
			Boolean hasGroupBys = groupbys.size() > 0 ? true : false;
			String ret = "";
			boolean firstGroupByFlag = true;
			if (hasGroupBys) {
				for (Map<String,Object> groupby : groupbys) {
					String inputColumn = getLProtectedChar()+groupby.get("INPUT_COLUMN").toString()+getRProtectedChar() ;
					if (firstGroupByFlag)
						ret += inputColumn;
					else
						ret += "," + inputColumn;
					firstGroupByFlag = false;
				}
				return ret;
			}
			return null;
		}
		
		/**
		 * this function is to set SQL physical-name value from groupBy columns.
		 * @param sql all the group by configred in this component will be added to this object in the column list section.
		 */
		protected void setGroupBy(SQL sql) {
			List<Map<String,Object>> groupbys = (List<Map<String,Object>>)getParameterByName("GROUPBYS").getValue();
			for (Map<String,Object> groupby : groupbys) {
				String inputColumn = groupby.get("INPUT_COLUMN").toString();
				String outputColumn = groupby.get("OUTPUT_COLUMN").toString();
				HashMap<String,String> property = sql.getNeedsProperty("column", outputColumn);
				if (property != null) {
					sql.setPropertyValue(sql.needs, "column", outputColumn, "physical-name", inputColumn);
				}
			}
		}		
		/**
		 * this function adds all the operations configured inside this component
		 * such as MAX, SUM, ... to the {@link SQL} object that is passed.
		 * therefore later when the SELECT portion of this SQL statement is 
		 * generated; the operations would be generated correctly in the column list portion. 
		 * @param sql all the operations configred in this component will be added to this object in the column list section.
		 * @return returns true if everything is good; otherwise returns false if there are problems.
		 */
		protected boolean setOperations(SQL sql) {
			List<Map<String,Object>> operations = (List<Map<String,Object>>)getParameterByName("OPERATION").getValue();
			Boolean hasOperations = operations.size() > 0 ? true : false;
			if (hasOperations) {
				for (Map<String,Object> operation : operations) {
					String inputColumn = translatetoString("OPERATION",operation,"INPUT_COLUMN");
					String outputColumn = translatetoString("OPERATION",operation,"OUTPUT_COLUMN");
					String function = translatetoString("OPERATION",operation,"FUNCTION");
					
					HashMap<String,String> property = sql.getNeedsProperty("column", outputColumn);
					if (property != null) {
						//sql.setPropertyValue(sql.needs, "column", outputColumn, "function", function);
						//sql.removePropertyElement(sql.needs, "column", outputColumn);
						//sql.createEmptyPropertyElement(sql.needs, "column", inputColumn);
						//sql.setPropertyValue(sql.needs, "column", inputColumn, "function", function);
						sql.setPropertyValue(sql.needs, "column", outputColumn, "physical-name", inputColumn);
						sql.setPropertyValue(sql.needs, "column", outputColumn, "function", function);
					}
					else {
						return false;
					}
				}
				return true;
			}
			else {
				return false;
			}
		}
		
		public String run(SQL sql) throws java.lang.Exception {
			if (this.previous() == null)
				throw new java.lang.Exception("ELTAggregate must have an input connection.");
			else if (columns == null || columns.size() == 0)
				return "";
			else {
				setOperations(sql);
				setGroupBy(sql);
				return previous().run(sql) + " GROUP BY " + getGroupBy();
			}
		}
	}
	
	
	/**
	 * 
	 * @author pparvizi
	 * @since 2011-01-26
	 *
	 */
	final class ELTNodeInput extends ELTNode {
		
		public ELTNodeInput(String name) {
			super(name);
		}
		
		protected String getTable() {
			String ret = "";
			String schema = (String)getParameterByName("SCHEMA_NAME").getValue();
			String table = (String)getParameterByName("TABLE_NAME").getValue();
			if (schema == null || schema.equals("") || schema.equals("\"\""))
				ret = getLProtectedChar()+"\" + " + table + " + \"" + getRProtectedChar();
			else
				ret = getLProtectedChar()+"\" + " + schema + " + \"" + getRProtectedChar()+"." + getLProtectedChar() + "\" + " + table + " + \""+getRProtectedChar();
			return ret;
		}
		
		protected int currentColumnNumber = 1;
		
		/**
		 * this function returns all the columns in the needs in order
		 * to get all column in order; set the currentColumnNumber 
		 * to 1 and call this function repeatedly.  
		 * @param sql
		 * @return
		 */
		protected HashMap<String,String> getNextNeedsColumn(SQL sql) {
			if (sql.needs == null)
				return null;
			if (currentColumnNumber < 1)
				currentColumnNumber = 1;
			for (HashMap<String, String> e : sql.needs) {
				String type = e.get("type");
				if (type != null && type.equals("column") && e.containsKey("order")) {
					int order = e.get("order") == null ? 0 : Integer.parseInt((String)e.get("order"));
					if (order == currentColumnNumber) {
						currentColumnNumber++;
						return e;
					}
				}
			}
			return null;
		}
		
		/**
		 * this function checks if a given column name exists in the component's
		 * schema.
		 * @param columnName
		 * @return
		 */
		protected boolean isSchemaColumn(String columnName) {
			if (columnName == null)
				return false;
			// go through normal columns first
			for (IMetadataColumn column : columns) {
				if (columnName.equalsIgnoreCase(column.getLabel()))
					return true;
			}
			// go through the additional columns
			Boolean hasAdditionalColumns = (Boolean)getParameterByName("HAS_ADD_COLS").getValue();
			List<Map<String,Object>> additionalColumns = (List<Map<String,Object>>)getParameterByName("ADD_COLS").getValue();
			if (hasAdditionalColumns) {
				for (Map<String,Object> column : additionalColumns) {
					if (columnName.equalsIgnoreCase(column.get("NAME").toString()))
						return true;
				}
			}
			return false;
		}
		
		/**
		 * return true if an a column name exists within the additional columns list
		 * @param columnName
		 * @return
		 */
		protected boolean isAdditionalColumn(String columnName) {
			if (columnName == null)
				return false;
			Boolean hasAdditionalColumns = (Boolean)getParameterByName("HAS_ADD_COLS").getValue();
			List<Map<String,Object>> additionalColumns = (List<Map<String,Object>>)getParameterByName("ADD_COLS").getValue();
			if (hasAdditionalColumns) {
				for (Map<String,Object> column : additionalColumns) {
					if (columnName.equalsIgnoreCase(column.get("NAME").toString()))
						return true;
				}
			}
			return false;
		}
		
		/**
		 * returns the SQL code that makes the additional column.
		 * @param columnName
		 * @return
		 */
		protected String getAdditionalColumnSQL(String columnName) {
			if (columnName == null)
				return null;
			Boolean hasAdditionalColumns = (Boolean)getParameterByName("HAS_ADD_COLS").getValue();
			List<Map<String,Object>> additionalColumns = (List<Map<String,Object>>)getParameterByName("ADD_COLS").getValue();
			if (hasAdditionalColumns) {
				for (Map<String,Object> column : additionalColumns) {
					if (columnName.equalsIgnoreCase(column.get("NAME").toString()))
						return column.get("SQL").toString();
				}
			}
			return null;
		}
		
		
		/** 
		 * this function returns the select list form that is driven from the component's
		 * schema as well as what's needed in the SQL object passed.
		 * @param sql
		 * @return example: column1, COUNT(column2), column3 AS col3
		 */
		protected String getSelectColumns(SQL sql) throws java.lang.Exception {
			String ret = "";
			boolean firstColumnFlag = true;
			
			HashMap<String,String> e;
			currentColumnNumber = 1;
			// read all the needs columns in order. order is important;
			// since columns must be inserted in the same order as the
			// insert list from tELTOutput (insert operation)
			while ((e = getNextNeedsColumn(sql)) != null) {
				String uniqueName = e.get("name");
				String physicalName = e.get("physical-name");
				String function = e.get("function");
				String tableAlias = e.get("table-alias");
				String columnAlias = e.get("alias-name");
				if (isSchemaColumn(physicalName) || isAdditionalColumn(physicalName)) {
					String tmp;
					if (isAdditionalColumn(physicalName))
						tmp = getLProtectedChar() + "\" + " + getAdditionalColumnSQL(physicalName) + " + \"" + getRProtectedChar();
					else
						tmp = getLProtectedChar() +physicalName+getRProtectedChar();
					if (tableAlias != null)
						tmp = tableAlias + "." + tmp;
					if (function != null)
						tmp = function + "(" + tmp + ")";
					if (columnAlias != null) {
						tmp = tmp + " AS " + columnAlias;
					}
					if (firstColumnFlag)
						ret += tmp;
					else
						ret += ", " + tmp;
					firstColumnFlag = false;
					// remove the need from the SQL object
					sql.removePropertyElement(sql.needs, "column", uniqueName);
				}
				else {
					String componentName = (String)getParameterByName("UNIQUE_NAME").getValue();
					throw new java.lang.Exception("Column " + physicalName + " is not defined in the " + componentName + " component");
				}
			}
			if (sql.needs.size() > 0) {
				boolean hasAnyNeedsColumns = false;
				String tmpName = null;
				String tmpType = null;
				for (HashMap<String, String> tmp : sql.needs) {
					tmpType = tmp.get("type");
					if (tmpType != null && tmpType.equals("column")) {
						tmpName = tmp.get("physical-name");
						hasAnyNeedsColumns = true;
						break;
					}
				}
				if (hasAnyNeedsColumns) {
					String componentName = (String)getParameterByName("UNIQUE_NAME").getValue();
					throw new java.lang.Exception("Column " + tmpName + " is not defined in the " + componentName + " component.");
				}
			}
			/*
			for (IMetadataColumn column : columns) {
				if (column.getLabel() == null) continue;
				String columnName = column.getLabel();
				if (sql.getPropertyElement(sql.needs, "column", columnName) != null) {
					String columnFunction = sql.getPropertyValue(sql.needs, "column", columnName, "function");
					String columnTableAlias = sql.getPropertyValue(sql.needs, "column", columnName, "tablealias");
					String columnNameAlias = sql.getPropertyValue(sql.needs, "column", columnName, "namealias");
					String tmp = columnName;
					if (columnTableAlias != null)
						tmp = columnTableAlias + "." + tmp;
					if (columnFunction != null)
						tmp = columnFunction + "(" + tmp + ")";
					if (columnNameAlias != null) {
						tmp = tmp + " AS " + columnNameAlias;
					}
					if (firstColumnFlag)
						ret += tmp;
					else
						ret += ", " + tmp;
					firstColumnFlag = false;
					// remove the need from the SQL object
					sql.removePropertyElement(sql.needs, "column", columnName);
				}
			}
			// go through the additional columns
			Boolean hasAdditionalColumns = (Boolean)getParameterByName("HAS_ADD_COLS").getValue();
			List<Map<String,Object>> additionalColumns = (List<Map<String,Object>>)getParameterByName("ADD_COLS").getValue();
			if (hasAdditionalColumns) {
				for (Map<String,Object> column : additionalColumns) {
					String columnName = column.get("NAME").toString();
					String columnSQL = column.get("SQL").toString();
					if (sql.getPropertyElement(sql.needs, "column", columnName) != null) {
						String columnFunction = sql.getPropertyValue(sql.needs, "column", columnName, "function");
						String columnTableAlias = sql.getPropertyValue(sql.needs, "column", columnName, "tablealias");
						String columnNameAlias = sql.getPropertyValue(sql.needs, "column", columnName, "namealias");
						// if there's no pre-set column alias; then the column name is the alias 
						// more the inputed SQL
						columnNameAlias = columnNameAlias == null ? columnName : columnNameAlias;
						String tmp = "\" + " + columnSQL + " + \"";
						if (columnTableAlias != null)
							tmp = columnTableAlias + "." + tmp;
						if (columnFunction != null)
							tmp = columnFunction + "(" + tmp + ")";
						if (columnNameAlias != null) {
							tmp = tmp + " AS " + columnNameAlias;
						}
						if (firstColumnFlag)
							ret += tmp;
						else
							ret += ", " + tmp;
						firstColumnFlag = false;
						// remove the need from the SQL object
						sql.removePropertyElement(sql.needs, "column", columnName);
					}
				}
			}
			*/
			return ret;
		}
		
		public String run(SQL sql) throws java.lang.Exception {
			if (columns == null || columns.size() == 0)
				throw new java.lang.Exception("tELTPlusInput must have an shcema.");
			else {
				return "SELECT " + getSelectColumns(sql) + " FROM " + getTable();
			}
		}
	}
	
//code-end

    
	IMetadataTable metadata = null;
	List<IMetadataColumn> columns = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
    	metadata = metadatas.get(0);
    	if (metadata!=null) {
    		columns = metadata.getListColumns();
    	}
	}
	
	
	
	String temp = "";
	String components = "";

	ELTNode current_component = null;
	ELTNode previous_component = null;
	ELTNode head = null;
	ELTNode tail = null;
	IElementParameter combinedParameters = node.getElementParameter("COMBINED_PARAMETERS");
	String dbtype = null;
	String conn = null;
	for (IElementParameter combinedComponentParameter : (List<IElementParameter>) combinedParameters.getValue()) {
		// create the ELTNode component and assign parameters/schema
		String componentName = (String)combinedComponentParameter.getChildParameters().get("UNIQUE_NAME").getValue();
		String componentType = ((String)combinedComponentParameter.getChildParameters().get("COMPONENT_NAME").getValue()).toLowerCase();
		current_component = null;
		current_component = componentType.contains("input") ? new ELTNodeInput(componentName) : current_component;
		current_component = componentType.contains("filter") ? new ELTNodeFilter(componentName) : current_component;
		current_component = componentType.contains("aggregate") ? new ELTNodeAggregate(componentName) : current_component;
		current_component = componentType.contains("output") ? new ELTNodeInsert(componentName) : current_component;
		if (current_component != null) {
			current_component.parameters = combinedComponentParameter.getChildParameters().values();
			current_component.columns = ((IMetadataTable)combinedComponentParameter.getChildParameters().get("SCHEMA").getValue()).getListColumns();
			// if this component is an output component; then get the connection 
			// and database type info
			if (componentType.contains("output")) {
				dbtype = (String)current_component.getParameterByName("DBTYPE").getValue();
				conn = "conn_" + (String)current_component.getParameterByName("CONNECTION_" + dbtype).getValue();
			}
			if (head == null)
				head = current_component;
			if (previous_component != null)
				current_component.addInputNode(previous_component);
			previous_component = current_component;
			tail = current_component;
		}
		
		
		for (IElementParameter parameter : combinedComponentParameter.getChildParameters().values()) {
			String name = parameter.getName();
			temp += name + ",";
			if (name != null && name.equals("COMPONENT_NAME")) {
				components += combinedComponentParameter.getChildParameters().get("UNIQUE_NAME").getValue() + "(" + parameter.getValue() + ")" + " -> ";
			}	
		}
	}
	ELTNode eachnode = tail;
	while(true){
		if(eachnode!=null){
			eachnode.setDbType(dbtype);
		}else{
			break;
		}
		eachnode=eachnode.mainInputNode;
	}
	
//	String t1 = "";
//	ELTNode c = head;
//	while (c != null) {
//		t1 += c.getNodeName() + "\n";
//		t1 += "\t" + c.getColumnList(",") + "\n";
//		c = c.next();
//	}
	
	String sql = null;
	String err = null;
	SQL sqlObject = new SQL();
	try {
		sql = tail.run(sqlObject);
	} catch (java.lang.Exception e) {
		err = e.getMessage() + " ";
		e.printStackTrace();
	}
	
	boolean debug = false;
	
//code-end

    stringBuffer.append(TEXT_1);
     if (debug) { 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(components);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(temp);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sql);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(err);
    stringBuffer.append(TEXT_6);
     } 
    stringBuffer.append(TEXT_7);
     if (sql != null) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(sql);
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
     } else { 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(err);
    stringBuffer.append(TEXT_25);
     } 
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}
