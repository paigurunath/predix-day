package com.predix.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.predix.dao.TableDataOperations;
import com.predix.model.Company;

@RestController
@EnableAutoConfiguration
public class CreateReadUpdateDelete {

	TableDataOperations tdo = new TableDataOperations();
	
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping(value="/createTable", method=RequestMethod.POST)
	public String createTable() {
		try {
			return tdo.createTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	/*@RequestMapping(value="/insertTableData", method=RequestMethod.POST)
	public String insertTableData(@RequestBody Company company ) {
		try {
			
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), company.getStatus());
			
			return tdo.insertDataTable(hm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	@RequestMapping(value="/retrieveTableData", method=RequestMethod.POST)
	public @ResponseBody String retrieveTableData(@RequestBody Company company) {
		try {
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), company.getAppname());
			
			TableDataOperations tdo = new TableDataOperations();
			return tdo.viewData(hm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/updateTableData", method=RequestMethod.POST)
	public @ResponseBody String updateTableData(@RequestBody Company company) {
		try {
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), company.getStatus());
			hm.put(new Integer(2), company.getAppname());
			
			TableDataOperations tdo = new TableDataOperations();
			return tdo.updateDataTable(hm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	*/
	
	@RequestMapping(value="/insertTableData", method=RequestMethod.POST)
	public String insertTableData(@RequestBody Company company ) {
		try {
			TableDataOperations tdo = new TableDataOperations();
			
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), company.getAppname());
			hm.put(new Integer(2), company.getStatus());
			
			return tdo.insertDataTable(hm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	@RequestMapping(value="/updateTableData", method=RequestMethod.POST)
	public String updateTableData(@RequestBody Company company ) {
		try {
			TableDataOperations tdo = new TableDataOperations();
			
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), company.getStatus());
			hm.put(new Integer(2), company.getAppname());
			
			return tdo.updateDataTable(hm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	@RequestMapping(value="/retrieveTableData", method=RequestMethod.POST)
	public @ResponseBody String retrieveTableData(@RequestBody Company company) {
		try {
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), company.getAppname());
			
			TableDataOperations tdo = new TableDataOperations();
			return tdo.viewData(hm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
