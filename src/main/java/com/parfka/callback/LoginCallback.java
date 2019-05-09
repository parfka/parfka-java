package com.parfka.callback;

import com.parfka.ParfkaUser;
import com.parfka.ParseException;

public abstract class LoginCallback extends ParseCallback<ParfkaUser> {

	abstract void done(ParfkaUser parseUser, ParseException parseException);
	
	@Override
	void internalDone(ParfkaUser parseUser, ParseException parseException) {
		done(parseUser, parseException);
	}
	
}
