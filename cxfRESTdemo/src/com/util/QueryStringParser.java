package com.util;

import java.util.HashMap;

public class QueryStringParser {
	HashMap<String,String> queryStringMap;
	public QueryStringParser(){
		queryStringMap = new HashMap<String,String>();
	}
	public HashMap<String,String> parser(String queryString){
		if(queryString!=null){
			int querylast = 0;
			int queryIndex = 0;
			String queryStringItem,key,value;
			String queryPair[];
			do{
				queryIndex = queryString.indexOf('&',querylast);
				if(queryIndex>0){
					 queryStringItem = queryString.substring(querylast,queryIndex);
					 querylast = queryIndex+1;
				}
				else{
					 queryStringItem = queryString.substring(querylast);	
				}
				queryPair = queryStringItem.split("=");
				key = queryPair[0];
				value = queryPair[1];
				queryStringMap.put(key, value);
				
			}while(queryIndex>0);
		}
		return queryStringMap;
	}
	
	public static void main(String args[]){
		QueryStringParser q = new QueryStringParser();
		q.parser("callbackparam=success_jsonpCallback&_=1395039025650&ss=dsds");
	}
}	
