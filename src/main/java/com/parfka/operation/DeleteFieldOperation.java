package com.parfka.operation;

import com.parfka.ParfkaObject;
import org.json.JSONException;
import org.json.JSONObject;
import com.parfka.encode.ParseObjectEncodingStrategy;

public class DeleteFieldOperation implements ParseFieldOperation {

	@Override
	public Object apply(Object oldValue, ParfkaObject paramParfkaObject, String key) {
		return null;
	}

	@Override
	public Object encode(ParseObjectEncodingStrategy objectEncoder)
			throws JSONException {
		JSONObject output = new JSONObject();
	    output.put("__op", "Delete");
	    return output;
	}

}
