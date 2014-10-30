package com.mhb.services.dbService.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.mhb.services.dbService.DBService;
import com.mhb.services.dbService.impl.DbServiceMySqlImpl;
import com.mhb.services.util.DBUtil;
import com.mhb.services.util.DateUtil;

public class DBTest {
	@Test
	public void testy() throws ClassNotFoundException, SQLException{
		String user = "root";
		String password = "mysql";
		String url = "jdbc:mysql://localhost:3306/jssd";
		String driver = "com.mysql.jdbc.Driver";
		Connection conn = DBUtil.getConntection(user, password, url, driver);
		PreparedStatement pstmt = conn.prepareStatement("select * from users");
		ResultSet rs = pstmt.executeQuery();
		List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
		Map<String,Object> column = null;
		boolean header = false;
		while(rs.next()){
			ResultSetMetaData metaData = rs.getMetaData();
			column = new HashMap<String,Object>();
			for(int i=1;i<=metaData.getColumnCount();i++){
				if(!header){
					
				}
				if(metaData.getColumnClassName(i).equals("java.sql.Timestamp")){
					column.put(metaData.getColumnName(i), DateUtil.longToYYYYMMDDString(((Timestamp)rs.getObject(i)).getTime()));
				}
				else{
					column.put(metaData.getColumnName(i), rs.getObject(i));
				}
			}
			datas.add(column);
			header = true;
		}
		String ret = JSON.toJSONString(datas);
		System.out.println(ret);
		rs.close();
		DBUtil.closeStmt(pstmt);
		DBUtil.closeConection(conn);
	}
	
	@Test
	public void testDbService(){
		DBService service = new DbServiceMySqlImpl();
		System.out.println(service.findAll("users"));
	}
	
	
}
