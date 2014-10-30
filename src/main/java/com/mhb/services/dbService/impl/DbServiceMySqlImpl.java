package com.mhb.services.dbService.impl;

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

import com.mhb.services.dbService.base.BaseDBService;
import com.mhb.services.domain.JSONReturn;
import com.mhb.services.exception.TableNameErrorException;
import com.mhb.services.util.DBUtil;
import com.mhb.services.util.DateUtil;
import com.mhb.services.util.SqlUtil;



public class DbServiceMySqlImpl extends BaseDBService {
	
	public JSONReturn findAll(String table) {
		JSONReturn result = new JSONReturn();
		try {
			if(!SqlUtil.isTableName(table)){
				throw new TableNameErrorException();
			}
			Connection conn = DBUtil.getCurrentConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from "+table);
			ResultSet rs = pstmt.executeQuery();
			
			List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
			Map<String,Object> column = null;
			
			while(rs.next()){
				ResultSetMetaData metaData = rs.getMetaData();
				column = new HashMap<String,Object>();
				for(int i=1;i<=metaData.getColumnCount();i++){
					if(metaData.getColumnClassName(i).equals("java.sql.Timestamp")){
						column.put(metaData.getColumnName(i), DateUtil.longToYYYYMMDDString(((Timestamp)rs.getObject(i)).getTime()));
					}
					else{
						column.put(metaData.getColumnName(i), rs.getObject(i));
					}
				}
				datas.add(column);
			}
			result.setDatas(datas);
			result.setMessage("查询成功!");
			result.setResult(JSONReturn.SUCCESS);
		} catch (ClassNotFoundException e) {
			result.setMessage(e.getMessage());
			result.setResult(JSONReturn.FAIL);
			e.printStackTrace();
		} catch (SQLException e) {
			result.setMessage(e.getMessage());
			result.setResult(JSONReturn.FAIL);
			e.printStackTrace();
		} catch (TableNameErrorException e) {
			result.setMessage(e.getMessage());
			result.setResult(JSONReturn.FAIL);
			e.printStackTrace();
		}
		return result;
	}
}
