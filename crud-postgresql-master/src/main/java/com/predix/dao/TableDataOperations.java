package com.predix.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import com.predix.datasource.Query;
import com.predix.datasource.QueryInteractor;
import com.predix.model.Company;

public class TableDataOperations {

	QueryInteractor qi = null;
	
 	public String createTable() {
		
		try {
			qi = new QueryInteractor();
			qi.executeUpdateQuery(Query.CREATE_AGRO);
			
			return "Table created successfully";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 	

 	public String createTableTimeSeries() {
		
		try {
			qi = new QueryInteractor();
			qi.executeUpdateQuery(Query.CREATE_TIME_SERIES);
			
			return "Table created successfully";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 	
 	public String insertDataTable(HashMap values) {
 		
 		try {
 			qi = new QueryInteractor();
 			qi.getArrayList(Query.INSERT_AGRO, values);
 			
 			return "Data saved successfully";
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	
 	public String insertTimeSeriesTable(String timeSeriesName, String timeSeriesValue) {
 		
 		try {
 			
 			qi = new QueryInteractor();
 			qi.insertTimeSeries(Query.INSERT_TIME_SERIES, timeSeriesName, timeSeriesValue);
 			
 			return "Data saved successfully";
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	public String updateDataTable(HashMap values) {
 		
 		try {
 			qi = new QueryInteractor();
 			qi.getArrayList(Query.UPDATE_AGRO, values);
 			
 			return "Data saved successfully";
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	public String insertTimeGet(String timeSeriesName, String limit, String order) {
 		
 		try {
 			qi = new QueryInteractor();
 			return qi.insertTimeGet(Query.GET_TIME_SERIES,  timeSeriesName,  limit,  order);
 			
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	public String insertTimeGetLatest(String timeSeriesName, String limit, String order) {
 		
 		try {
 			qi = new QueryInteractor();
 			return qi.insertTimeGetLatest(Query.GET_TIME_SERIES_LATEST,  timeSeriesName,  limit,  order);
 			
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	public JSONObject insertTimeGetObj(String timeSeriesName, String limit, String order) {
 		
 		try {
 			qi = new QueryInteractor();
 			return qi.insertTimeGetObj(Query.GET_TIME_SERIES,  timeSeriesName,  limit,  order);
 			
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	public JSONObject insertTimeGetLatestObj(String timeSeriesName, String limit, String order) {
 		
 		try {
 			qi = new QueryInteractor();
 			return qi.insertTimeGetLatestObj(Query.GET_TIME_SERIES_LATEST,  timeSeriesName,  limit,  order);
 			
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	public String viewData(HashMap values) {
 		
 		try {
 			qi = new QueryInteractor();
 			List<Object> listObject = qi.getArrayListOnCondition(Query.VIEW_AGRO, values);
 			
 			Object[] obj = (Object[])listObject.get(1);
 			System.out.println(obj[0].toString());
 			return obj[0].toString();
 			
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
	/*public static void main(String args[]) {
		
		TableDataOperations tdo = new TableDataOperations();
		
		//tdo.createTable();
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(new Integer(1), "gurunath");
		hm.put(new Integer(2), "25");
		hm.put(new Integer(3), "flat no 2, road no 3");
		hm.put(new Integer(4), "25.00");
		//hm.put(new Integer(5), "1");
		
		
		tdo.insertDataTable(hm);
		tdo.viewData();
		
	}*/
}
