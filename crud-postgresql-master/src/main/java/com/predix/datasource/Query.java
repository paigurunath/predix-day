package com.predix.datasource;

public class Query {

	/*public static String CREATE_AGRO = "CREATE TABLE  IF NOT EXISTS  agro  (appname text not null,status TEXT NOT NULL, primary key (appname))";
	public static String INSERT_AGRO = "INSERT INTO agro (appname, status) VALUES (?,?)";
	public static String UPDATE_AGRO = "UPDATE agro SET status = ? where appname = ?";
	public static String VIEW_AGRO = "SELECT status, appname FROM AGRO where appname=?";
	*/
	

	public static String CREATE_AGRO = "CREATE TABLE  IF NOT EXISTS  agro  (appname text not null,status TEXT NOT NULL, primary key (appname))";
	
	public static String CREATE_TIME_SERIES = "CREATE TABLE  IF NOT EXISTS  timeseries (timeseriesname character(255),timseriesvalue double precision,timeseriestime bigint,timeseriesquality integer,tid serial NOT NULL)";
	
	public static String INSERT_AGRO = "INSERT INTO agro (appname, status) VALUES (?,?)";
	
	public static String INSERT_TIME_SERIES = "INSERT INTO timeseries ( timeseriesname, timseriesvalue, timeseriestime, timeseriesquality) VALUES (?,?,?,?)";
	
	public static String UPDATE_AGRO = "UPDATE agro SET status = ? where appname = ?";
	
	public static String VIEW_AGRO = "SELECT status, appname FROM AGRO where appname=?";
	
	public static String GET_TIME_SERIES = "SELECT  timeseriestime, timseriesvalue, timeseriesquality from timeseries where timeseriesname=?  order by timeseriestime desc limit ?";
	
	public static String GET_TIME_SERIES_LATEST = "SELECT  timeseriestime, timseriesvalue, timeseriesquality from timeseries where timeseriesname=?  order by timeseriestime desc limit ?";
	
	/*INSERT INTO public.timeseries(
            timeseriesname, timseriesvalue, timeseriestime, timeseriesquality
            )
    VALUES ('temperature', 30.1, 1458976222, 3
            );
            
            
            -- Table: public.timeseries

-- DROP TABLE public.timeseries;

CREATE TABLE public.timeseries
(
  timeseriesname character(255),
  timseriesvalue double precision,
  timeseriestime bigint,
  timeseriesquality integer,
  tid integer NOT NULL DEFAULT nextval('timeseries_tid_seq'::regclass)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.timeseries
  OWNER TO postgres;

*/
}
