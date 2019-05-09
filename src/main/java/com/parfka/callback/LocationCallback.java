package com.parfka.callback;

import com.parfka.ParseException;
import com.parfka.ParseGeoPoint;

public abstract class LocationCallback extends ParseCallback<ParseGeoPoint> {

	abstract void done(ParseGeoPoint parseGeoPoint, ParseException parseException);

	@Override
	void internalDone(ParseGeoPoint parseGeoPoint, ParseException parseException) {
		done(parseGeoPoint, parseException);
	}
	
}
