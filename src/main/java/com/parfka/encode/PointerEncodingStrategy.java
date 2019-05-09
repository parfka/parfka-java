package com.parfka.encode;

import com.parfka.ParfkaObject;
import org.json.JSONObject;

public class PointerEncodingStrategy extends PointerOrLocalIdEncodingStrategy {

	private static final PointerEncodingStrategy instance = new PointerEncodingStrategy();

	public static PointerEncodingStrategy get() {
		return instance;
	}

	public JSONObject encodeRelatedObject(ParfkaObject object) {
		if (object.getObjectId() == null) {
			throw new IllegalStateException(
					"unable to encode an association with an unsaved ParfkaObject");
		}
		return super.encodeRelatedObject(object);
	}

}
