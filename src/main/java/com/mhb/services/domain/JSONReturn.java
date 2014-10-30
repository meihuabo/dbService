package com.mhb.services.domain;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 用于返回查询结果
 * @author 梅华波 2014年10月29日 上午1:59:47
 */
public class JSONReturn {
	
	public final static String SUCCESS = "success";
	public final static String FAIL = "fail";
	
	private String message;
	private String result;
	private Object datas;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Object getDatas() {
		return datas;
	}
	public void setDatas(Object datas) {
		this.datas = datas;
	}
	@Override
	public String toString() {
		Map<String,Object> ret = new HashMap<String,Object>();
		ret.put("message", this.message);
		ret.put("result", this.result);
		ret.put("datas", this.datas);
		return JSON.toJSONString(ret);
	}
}
