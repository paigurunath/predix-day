package com.example;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.predix.dao.TableDataOperations;
import com.predix.model.Company;

@CrossOrigin
@RestController
public class GreetingController {

	@RequestMapping("/")
	String home() {
		return "Hello I am from Postgresql!!!!";
	}
	
    @RequestMapping(value="/createTable", method=RequestMethod.POST)
	public String createTable() {
		try {
			TableDataOperations tdo = new TableDataOperations();
			return tdo.createTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
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
	

	@RequestMapping(value="/createTableTimeSeries", method=RequestMethod.GET)
	public String createTableTimeSeries() {
		try {
			TableDataOperations tdo = new TableDataOperations();
			return tdo.createTableTimeSeries();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "PASS";
	}
	
	@RequestMapping(value="/timeseriesinsert", method = RequestMethod.GET)
	public @ResponseBody String timeSeriesInsert(@RequestParam(value="timeseriesname", required=false) String timeSeriesName,@RequestParam(value="timeseriesvalue", required=false) String timeSeriesValue){

		TableDataOperations tdo = new TableDataOperations();
		return tdo.insertTimeSeriesTable(timeSeriesName, timeSeriesValue);
		
	}
	
	@RequestMapping(value="/timeseriesget", method = RequestMethod.GET)
	public @ResponseBody String timeSeriesGet(@RequestParam(value="timeseriesname", required=false) String timeSeriesName,
			@RequestParam(value="limit", required=false) String limit,
			@RequestParam(value="order", required=false) String order){

		try{
			TableDataOperations tdo = new TableDataOperations();
			return tdo.insertTimeGet( timeSeriesName,  limit,  order);
			
	        
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "json string";
		
	}
	
	@RequestMapping(value="/timeseriesgetlatest", method = RequestMethod.GET)
	public @ResponseBody String timeSeriesGetLatest(@RequestParam(value="timeseriesname", required=false) String timeSeriesName,
			@RequestParam(value="limit", required=false) String limit,
			@RequestParam(value="order", required=false) String order){

		try{
			TableDataOperations tdo = new TableDataOperations();
			return tdo.insertTimeGetLatest( timeSeriesName,  limit,  order);
			
	        
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "json string";
		
	}
	
	@RequestMapping(value="/timeseriesgetobj", method = RequestMethod.GET)
	public @ResponseBody JSONObject timeSeriesGetObj(@RequestParam(value="timeseriesname", required=false) String timeSeriesName,
			@RequestParam(value="limit", required=false) String limit,
			@RequestParam(value="order", required=false) String order){

		try{
			TableDataOperations tdo = new TableDataOperations();
			return tdo.insertTimeGetObj( timeSeriesName,  limit,  order);
			
	        
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
	}
	
	@RequestMapping(value="/timeseriesgetlatestobj", method = RequestMethod.GET)
	public @ResponseBody JSONObject timeSeriesGetLatestObj(@RequestParam(value="timeseriesname", required=false) String timeSeriesName,
			@RequestParam(value="limit", required=false) String limit,
			@RequestParam(value="order", required=false) String order){

		try{
			TableDataOperations tdo = new TableDataOperations();
			return tdo.insertTimeGetLatestObj( timeSeriesName,  limit,  order);
			
	        
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
	}
}