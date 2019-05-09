package com.parfka.callback;

import com.parfka.ParseException;

public abstract class FunctionCallback<T> extends ParseCallback<T> {

    public abstract void done(T result, ParseException parseException);
	
	@Override
	void internalDone(T result, ParseException parseException) {
		done(result, parseException);
	}
	
}
