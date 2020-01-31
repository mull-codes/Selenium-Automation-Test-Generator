package com.k00217982.fyp.cloud.mysqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.k00217982.fyp.cloud.Database;
import com.k00217982.fyp.helper.Help;
import com.k00217982.fyp.helper.Logger;


public class MySQL implements Database {
	private String MYSQL_DRIVER_CLASS;
	private String MYSQL_CONNECTION_STRING;
	private String MYSQL_USERNAME;
	private String MYSQL_PASSWORD;
	
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
	
	public MySQL(String mysql_connection_string, String mysql_username, String mysql_password) {
		this.MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
		this.MYSQL_CONNECTION_STRING = mysql_connection_string;
		this.MYSQL_USERNAME = mysql_username;
		this.MYSQL_PASSWORD = mysql_password;
	}
	
	
	public List<HashMap<String,Object>> getResults (String sql) throws SQLException{
		Statement stmt = connect.createStatement();  
		ResultSet rs= stmt.executeQuery(sql);  
		List<HashMap<String, Object>> results = convertResultSetToList(rs);
		//System.out.print("\n");
		//System.out.println(results);
		Logger.logInfo(results.toString());
		return results;
	}
	
	
	public List<HashMap<String,Object>> getResults (String sql, String limit) throws SQLException{
		Statement stmt = connect.createStatement();
		sql = sql + " LIMIT " + limit;
		ResultSet rs= stmt.executeQuery(sql);
		List<HashMap<String, Object>> results = convertResultSetToList(rs);
		//System.out.print("\n");
		//System.out.println(results);
		Logger.logInfo(results.toString());
		return results;
	}
	
	/**
	 * @Description convertResultSetToList(ResultSet rs)
	 * @return List<HashMap<String,Object>>
	 */
	public List<HashMap<String,Object>> convertResultSetToList(ResultSet rs) throws SQLException {
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();

	    while (rs.next()) {
	        HashMap<String,Object> row = new HashMap<String, Object>(columns);
	        for(int i=1; i<=columns; ++i) {
	            row.put(md.getColumnName(i),rs.getObject(i));
	        }
	        list.add(row);
	    }

	    return list;
	}
	
	
	/**
	 * @return connect() boolean
	 */
	public boolean connect() throws SQLException {
		try {
			// This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://" + this.getMYSQL_CONNECTION_STRING() + "/mad2", this.getMYSQL_USERNAME(), this.getMYSQL_PASSWORD());
            
            
//            Statement stmt=connect.createStatement();  
//            ResultSet rs=stmt.executeQuery("select * from user");
            
            Logger.logInfo("Connected to " + this.getMYSQL_CONNECTION_STRING() + " successfully!");
            //System.out.println("Connected to " + this.getMYSQL_CONNECTION_STRING());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Logger.logError("FAILED TO CONNECT TO " + this.getMYSQL_CONNECTION_STRING());
			return false;
		}
		return true;
	}
	
	
	public boolean close() {
		try {
			if(this.statement != null) {
				this.resultSet.close();
			}
			
			if(this.resultSet != null) {
				this.resultSet.close();
			}
			
			if(this.connect != null) {
				connect.close();
			}
			
			Logger.logInfo("Connection close successfully " + this.getMYSQL_CONNECTION_STRING() + "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Logger.logError("Could not close connection from " + this.getMYSQL_CONNECTION_STRING() + "");
			return false;
		}
		return true;
	}
	
	
	
	
	/**
	 * @return the mYSQL_DRIVER_CLASS
	 */
	public String getMYSQL_DRIVER_CLASS() {
		return MYSQL_DRIVER_CLASS;
	}




	/**
	 * @param mYSQL_DRIVER_CLASS the mYSQL_DRIVER_CLASS to set
	 */
	public void setMYSQL_DRIVER_CLASS(String mYSQL_DRIVER_CLASS) {
		MYSQL_DRIVER_CLASS = mYSQL_DRIVER_CLASS;
	}




	/**
	 * @return the mYSQL_CONNECTION_STRING
	 */
	public String getMYSQL_CONNECTION_STRING() {
		return MYSQL_CONNECTION_STRING;
	}




	/**
	 * @param mYSQL_CONNECTION_STRING the mYSQL_CONNECTION_STRING to set
	 */
	public void setMYSQL_CONNECTION_STRING(String mYSQL_CONNECTION_STRING) {
		MYSQL_CONNECTION_STRING = mYSQL_CONNECTION_STRING;
	}




	/**
	 * @return the mYSQL_USERNAME
	 */
	public String getMYSQL_USERNAME() {
		return MYSQL_USERNAME;
	}




	/**
	 * @param mYSQL_USERNAME the mYSQL_USERNAME to set
	 */
	public void setMYSQL_USERNAME(String mYSQL_USERNAME) {
		MYSQL_USERNAME = mYSQL_USERNAME;
	}




	/**
	 * @return the mYSQL_PASSWORD
	 */
	public String getMYSQL_PASSWORD() {
		return MYSQL_PASSWORD;
	}




	/**
	 * @param mYSQL_PASSWORD the mYSQL_PASSWORD to set
	 */
	public void setMYSQL_PASSWORD(String mYSQL_PASSWORD) {
		MYSQL_PASSWORD = mYSQL_PASSWORD;
	}




	

	
}
