package com.parfka.callback;

import java.util.List;

import com.parfka.ParfkaObject;
import com.parfka.ParseException;

public abstract class FindCallback<T extends ParfkaObject> extends ParseCallback<List<T>> {

	public abstract void done(List<T> list, ParseException parseException);
	
	@Override
	void internalDone(List<T> list, ParseException parseException) {
		done(list, parseException);
	}
	
}
