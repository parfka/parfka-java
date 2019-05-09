package com.parfka.callback;

import com.parfka.ParseException;

public abstract class ParseCallback<T> {
	
	abstract void internalDone(T paramT, ParseException parseException);
	
}
