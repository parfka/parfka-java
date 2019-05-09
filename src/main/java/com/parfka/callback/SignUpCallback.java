package com.parfka.callback;

import com.parfka.ParseException;

public abstract class SignUpCallback extends ParseCallback<Void> {

	public abstract void done(ParseException parseException);
	
	@Override
	void internalDone(Void paramVoid, ParseException parseException) {
		done(parseException);
	}
	
}
