package com.parfka.operation;

import org.json.JSONException;
import com.parfka.ParfkaObject;
import com.parfka.encode.ParseObjectEncodingStrategy;

public interface ParseFieldOperation {
	
	abstract Object apply(Object oldValue, ParfkaObject parfkaObject, String key);
	
	abstract Object encode(ParseObjectEncodingStrategy objectEncoder) throws JSONException;

}
