package com.mhb.services.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mhb.services.dbService.DBService;

@Controller
@RequestMapping(value = "/dbService")
public class ServicesController {

	@Autowired
	private DBService dbService;

	@RequestMapping(value = "/findAll", method = { RequestMethod.GET }, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String findAll(@RequestParam(required = false) String table,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		 //String referer = request.getHeader("Referer");
		 /*System.out.println(referer);
		 * response.setHeader("Access-Control-Allow-Origin", referer);
		 * response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		 * response.setHeader("Access-Control-Allow-Methods", "GET");
		 * response.setHeader("Allow", "GET");
		 */
		 response.setContentType("text/javascript");
		 String callback = request.getParameter("callback");
		return callback + "("+dbService.findAll(table).toString()+")";
	}
}
