package com.parfka.operation;

import org.json.JSONException;
import com.parfka.ParfkaObject;
import com.parfka.encode.ParseObjectEncodingStrategy;
import com.parfka.util.ParseEncoder;

public class SetFieldOperation implements ParseFieldOperation {

	private Object value;
	
	public SetFieldOperation(Object value) {
		this.value = value;
	}
	
	@Override
	public Object apply(Object oldValue, ParfkaObject parfkaObject, String key) {
		return value;
	}

	@Override
	public Object encode(ParseObjectEncodingStrategy objectEncoder) throws JSONException {
		
		return ParseEncoder.encode(value, objectEncoder);
		
		/*
		if(value instanceof byte[]) {
			byte[] bytes = (byte[]) value;
			JSONObject output = new JSONObject();
			output.put("__type", "Bytes");
			output.put("base64", Base64.encodeBase64String(bytes));
			return output;				
		}
		
		if(value instanceof Date) {
			Date dt = (Date) value;
			JSONObject output = new JSONObject();
			output.put("__type", "Date");
			output.put("iso", Parfka.encodeDate(dt));
			return output;			
		}
		
		if(value instanceof Map) {
	        Map<String, Object> map = (Map<String, Object>) value;
	        JSONObject json = new JSONObject();
	        for (String key : map.keySet()) {
	          json.put(key, map.get(key));
	        }
	        return json;
	      }		
		
		if(value instanceof ParseFile) {
			ParseFile file = (ParseFile) value;
			JSONObject output = new JSONObject();
			output.put("__type", "File");
			output.put("name", file.getName());
			output.put("url", file.getUrl());
			return output;	
		}
		
		if(value instanceof ParseGeoPoint) {
			ParseGeoPoint gp = (ParseGeoPoint) value;
			JSONObject output = new JSONObject();
			output.put("__type", "GeoPoint");
			output.put("latitude", gp.getLatitude());
			output.put("longitude", gp.getLongitude());
			return output;	
		}
		
		if(value instanceof ParfkaObject) {
			ParfkaObject po = (ParfkaObject) value;
			JSONObject output = new JSONObject();
			output.put("__type", "Pointer");
			output.put("className", po.getClassName());
			output.put("objectId", po.getObjectId());
			return output;	
		}
		
		return value;
		
		*/
	}

}
