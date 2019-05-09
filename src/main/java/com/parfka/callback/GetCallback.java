package com.parfka.callback;

import com.parfka.ParfkaObject;
import com.parfka.ParseException;

public abstract class GetCallback<T extends ParfkaObject> extends ParseCallback<T> {

    public abstract void done(T t, ParseException parseException);
	
	@Override
	void internalDone(T t, ParseException parseException) {
		done(t, parseException);
	}
	
}
