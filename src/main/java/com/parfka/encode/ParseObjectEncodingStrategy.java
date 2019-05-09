package com.parfka.encode;

import org.json.JSONObject;
import com.parfka.ParfkaObject;

public interface ParseObjectEncodingStrategy {
	
	public abstract JSONObject encodeRelatedObject(ParfkaObject parfkaObject);

}
